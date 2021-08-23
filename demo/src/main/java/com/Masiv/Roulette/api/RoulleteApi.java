/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.api;

import com.Masiv.Roulette.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Services
 * @author Nicolas Reina
 */
@RestController
public class RoulleteApi {

    @Autowired
    RouletteServices services;
    
    /*
        Service to create a roulette
        @Param name
        @return String
    */
    @RequestMapping(value = "/saveRoulette/name/{name}", method = RequestMethod.GET)
    public String saveRoulette(@PathVariable("name") String name) {
        return services.save(name);
    }
    /*
        Service that consults a roulette by its id
        @Param name
        @return String
    */
    @RequestMapping(value = "/findByRoulette/id/{id}", method = RequestMethod.GET)
    public String getRoulette(@PathVariable("id") int id) {
        return services.getRoulette(id);
    }
    /*
        Servicio para realizar la apuesta
        @Param idRoc id of roulette
        @Param idPerson id of person
        @Param bet credits placed on the bet
        @Param betValues selected bet
        @return String
    */
    @RequestMapping(value = "/betRoulette/idRoc/{idRoc}/idPerson/{idPerson}/bet/{bet}/betValues/{betValues}", method = RequestMethod.GET)
    public String betRoulette(@PathVariable("idRoc") int idRoc, @PathVariable("idPerson") int idPerson, @PathVariable("bet") int bet, @PathVariable("betValues") String betValues) {
        return services.betRoulette(idRoc, idPerson, bet, betValues);
    }
    /*
        Service to show the result of the bet made
        @Param idRoc id of roulette
        @Param idPerson id of person
        @Param bet credits placed on the bet
        @Param betValues selected bet
        @return String
    */
    @RequestMapping(value = "/betValue/idRoc/{idRoc}/idPerson/{idPerson}/bet/{bet}/betValues/{betValues}", method = RequestMethod.GET)
    public String betValue(@PathVariable("idRoc") int idRoc, @PathVariable("idPerson") int idPerson, @PathVariable("bet") int bet, @PathVariable("betValues") String betValues) {
        return services.betResult(idRoc, idPerson, bet, betValues);
    }

}
