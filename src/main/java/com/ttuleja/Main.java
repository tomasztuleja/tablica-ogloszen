package com.ttuleja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Tomal on 2017-06-14.
 */

/**
 * Metoda uruchamiająca aplikację Springową
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}
