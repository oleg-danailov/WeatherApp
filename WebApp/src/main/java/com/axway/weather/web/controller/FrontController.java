package com.axway.weather.web.controller;


import com.axway.weather.model.WeeklyForecast;
import com.axway.weather.web.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FrontController {

    @Autowired
    private WeatherService weatherService;

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping(value = {"/","/index"})
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = {"/table"})
    public String getTable(@RequestParam(value = "cityName", defaultValue = "London", required = false) String cityName,
                           @RequestParam(value = "lon", required = false) String longitude,
                           @RequestParam(value = "lat", required = false) String latitude, Model model){
        WeeklyForecast forecast = null;
        if (longitude != null && latitude != null){
            forecast = weatherService.getForecastByCoordinates(longitude, latitude);
        } else {
            forecast = weatherService.getForecastByCityName(cityName);
        }
        model.addAttribute("forecast", forecast);
        return "table";
    }


}
