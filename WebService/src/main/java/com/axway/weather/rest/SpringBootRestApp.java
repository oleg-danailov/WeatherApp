package com.axway.weather.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication(scanBasePackages={"com.axway.weather.rest"})
public class SpringBootRestApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApp.class, args);
    }


}
