package org.kata.kata311;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Kata311Application {

    public static void main(String[] args) {
        SpringApplication.run(Kata311Application.class, args);
    }

}
