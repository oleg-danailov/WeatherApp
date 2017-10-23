package com.axway.weather.web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication(scanBasePackages={"com.axway.weather.web"})
public class SpringBootWebApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApp.class, args);
    }
}
