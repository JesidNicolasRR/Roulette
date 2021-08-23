/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.config;

import com.Masiv.Roulette.entity.Person;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nicolas Reina
 */
@Repository
public interface PersonDao extends JpaRepository<Person, BigDecimal>{
    
}
