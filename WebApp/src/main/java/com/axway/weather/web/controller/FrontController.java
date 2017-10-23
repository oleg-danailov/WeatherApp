package com.axway.weather.web.controller;


import com.axway.weather.model.WeeklyForecast;
import com.axway.weather.web.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FrontController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = {"/","/index"})
    public String getIndex(Model model){
//        model.addAttribute("thyme", "The Thymeleaf");

        WeeklyForecast forecast = weatherService.getForecastByCityName("Sofia");
        model.addAttribute("forecast", forecast);
        return "index";
    }


}
