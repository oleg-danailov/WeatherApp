package com.axway.weather.rest.controller;

import com.axway.weather.model.WeeklyForecast;
import com.axway.weather.rest.converter.DataConverter;
import com.axway.weather.rest.service.WeatherService;
import org.openweathermap.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class WeatherController {


    @Autowired
    @Qualifier("proxy")
    private WeatherService weatherService;

    @Autowired
    private DataConverter dataConverter;

    @RequestMapping(value = "/forecast", method = RequestMethod.GET, params = "cityName")
    public WeeklyForecast getForecastByCityName(@RequestParam(name = "cityName") String cityName){
        Response response = weatherService.getForecastByCityName(cityName);
        return dataConverter.convertResponse(response);
    }
    @RequestMapping(value = "/forecast", method = RequestMethod.GET, params = {"lon", "lat"})
    public Object getForecastByCoordinates(@RequestParam(name = "lon") String longitude,
                                           @RequestParam(name = "lat") String latitude){

        Response response = weatherService.getForecastByCoordinates(longitude, latitude);
        return dataConverter.convertResponse(response);

    }


}
