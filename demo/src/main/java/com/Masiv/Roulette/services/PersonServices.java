/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.services;

import com.Masiv.Roulette.config.PersonDao;
import com.Masiv.Roulette.config.SpringConfiguracion;
import java.math.BigDecimal;
import com.Masiv.Roulette.entity.Person;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

/**
 * service logic
 *
 * @author Nicolas Reina
 */
@Service
public class PersonServices {

    AnnotationConfigApplicationContext contexto
            = new AnnotationConfigApplicationContext(SpringConfiguracion.class);
    PersonDao repository = contexto.getBean(PersonDao.class);

    /*
        Logic to create a roulette
        @Param cedula, name, credit
        @return String
     */
    public void save(int id, String name, int credit) {
        Person p = new Person();
        p.setCredit(credit);
        p.setNamePerson(name);
        BigDecimal bg = new BigDecimal(id);
        p.setIdPerson(bg);
        repository.save(p);
    }

    /*
        Logic that a person consults for their id
        @Param id
        @return String
     */
    public String person(int id) {
        String mensaje = "";
        List<Person> p = repository.findAll();
        for (Person actual : p) {
            if (actual.getIdPerson().intValue() == id) {
                mensaje = "id: " + actual.getIdPerson() + " nombre: " + actual.getNamePerson();
            }
        }
        return (mensaje);
    }
}
