/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.api;

import com.Masiv.Roulette.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Services
 * @author Nicolas Reina
 */
@RestController
public class PersonApi {

    @Autowired
    PersonServices services;

      /*
        service to create a roulette
        @Param cedula, name, credit
        @return String
    */
    @RequestMapping(value = "/person/cedula/{cedula}/credit/{credit}/name/{name}", method = RequestMethod.GET)
    public void getPerson(@PathVariable("cedula") int id, @PathVariable("name") String name, @PathVariable("credit") int credit) {
        services.save(id, name, credit);
    }
      /*
        service that a person consults for their id
        @Param id
        @return String
    */
     @RequestMapping(value = "/findByPerson/id/{id}", method = RequestMethod.GET)
    public String getRoulette(@PathVariable("id") int id) {
        return services.person(id);
    }

}
