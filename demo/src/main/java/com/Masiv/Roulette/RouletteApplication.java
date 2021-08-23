package com.Masiv.Roulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan({"com.Masiv", "com.Masiv.Roulette.services", "com.Masiv.Roulette.entity", "com.Masiv.Roulette.config"})
@RestController
public class RouletteApplication {

    public static void main(String[] args) {

        SpringApplication.run(RouletteApplication.class, args);
    }

}
