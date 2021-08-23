/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.services;

import com.Masiv.Roulette.config.BoxDao;
import com.Masiv.Roulette.config.PersonDao;
import com.Masiv.Roulette.config.RouletteDao;
import com.Masiv.Roulette.config.SpringConfiguracion;
import com.Masiv.Roulette.entity.Box;
import com.Masiv.Roulette.entity.Person;
import com.Masiv.Roulette.entity.Roulette;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 *service logic
 * @author Nicolas Reina
 */
@Service
public class RouletteServices {

    AnnotationConfigApplicationContext contexto
            = new AnnotationConfigApplicationContext(SpringConfiguracion.class);

    RouletteDao repository = contexto.getBean(RouletteDao.class);

    BoxDao repositoryBox = contexto.getBean(BoxDao.class);

    PersonDao repositoryPerson = contexto.getBean(PersonDao.class);
     /*
        Logic to show the result of the bet made
        @Param id id of roulette
        @return String
    */
    public String getRoulette(int id) {
        BigDecimal bg = new BigDecimal(id);
        if (repository.existsById(bg)) {
            return ("successful operation");
        } else {
            return ("Operation rejected");
        }
    }
     /*
        Logic to show the result of the bet made
        @Param name name of roulette
        @return String
    */
    public String save(String name) {
        Roulette r = new Roulette();
        BigDecimal bg = new BigDecimal(repository.findAll().size() + 2);
        r.setIdRoc(bg);
        r.setNameRoc(name);
        r.setEstado("ABIERTA");
        repository.save(r);
        return ("roullete created <br>" + "id: " + r.getIdRoc() + " name: " + r.getNameRoc());
    }
     /*
        Logic to show the result of the bet made
        @Param idRoc id of roulette
        @Param idPerson id of person
        @Param bet credits placed on the bet
        @Param betValues selected bet
        @return String
    */
    public String betRoulette(int idRoc, int idPerson, int valueBet, String bet) {
        String validacion = "";
        Person per = new Person();
        List<Person> p = repositoryPerson.findAll();
        for (Person actual : p) {
            if (actual.getIdPerson().intValue() == idPerson) {
                per = actual;
            }
        }
        if (valueBet > 10000) {
            validacion = "the stakes are very high";
        }
        if (per.getCredit() < valueBet) {
            validacion = "you don't have enough credit";
        } else {
            per.setCredit(per.getCredit() - valueBet);
            repositoryPerson.save(per);
            validacion = "They bet on: " + bet + " with a balance of: " + valueBet + ", your new balance is: " + per.getCredit();
        }
        return validacion;
    }
     /*
        Logic to show the result of the bet made and draw the number from the roulette wheel
        @Param idRoc id of roulette
        @Param idPerson id of person
        @Param bet credits placed on the bet
        @Param betValues selected bet
        @return String
    */
    public String betResult(int idRoc, int idPerson, int valueBet, String bet) {
        String validacion = "";
        Person p = new Person();
        List<Person> lstp = repositoryPerson.findAll();
        for (Person actual : lstp) {
            if (actual.getIdPerson().intValue() == idPerson) {
                p = actual;
            }
        }
        int aleatorio = (int) (Math.random() * 36) + 1;
        Box b = new Box();
        List<Box> lstBox = repositoryBox.findAll();
        for (Box actual : lstBox) {
            if (actual.getIdBox().intValue() == aleatorio) {
                b = actual;
            }
        }
        Roulette r = new Roulette();
        List<Roulette> lstRoulette = repository.findAll();
        for (Roulette actual : lstRoulette) {
            if (actual.getIdRoc().intValue() == idRoc) {
                r = actual;
            }
        }
        if (bet.equalsIgnoreCase("negro") && b.getColor().equalsIgnoreCase("negro") || bet.equalsIgnoreCase("rojo") && b.getColor().equalsIgnoreCase("rojo") ) {
            p.setCredit((int) (valueBet * 1.8) + p.getCredit());
            validacion = "El numero que salio es: " + aleatorio + " de color: " + b.getColor() + "<br>"
                    + "Gano: " + (int) (valueBet * 1.8) + ", su nuevo saldo es: " + p.getCredit();
        } else {
                if (b.getNumberBox() == Integer.parseInt(bet)) {
                    p.setCredit((valueBet * 5) + p.getCredit());
                    validacion = "El numero que salio es: " + aleatorio + " de color: " + b.getColor() + "<br>"
                            + "Gano: " + (valueBet * 5) + ", su nuevo saldo es: " + p.getCredit();
                } else {
                    validacion = "El numero que salio es: " + aleatorio + " de color: " + b.getColor() + "<br>"
                            + "Gano: " + 0 + ", su nuevo saldo es: " + p.getCredit();
                }
        }
        r.setEstado("CERRADA");
        repository.save(r);
        repositoryPerson.save(p);
        return validacion;
    }

}
