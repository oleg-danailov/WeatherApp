package com.axway.weather.web.service;


import com.axway.weather.model.WeeklyForecast;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocalWeatherServiceImpl implements WeatherService {
    private static final String BASE_URL = "http://localhost:8090/api/";


    private RestTemplate restTemplate = new RestTemplate();

    public WeeklyForecast getForecastByCityName(String cityName) {
        WeeklyForecast response = restTemplate.getForObject(BASE_URL + "forecast?cityName=" + cityName
                , WeeklyForecast.class);
        return response;
    }

    @Override
    public WeeklyForecast getForecastByCoordinates(String longitude, String latitude) {
        WeeklyForecast response = restTemplate.getForObject(BASE_URL + "forecast?lon=" + longitude +
                "&lat=" + latitude
                , WeeklyForecast.class);
        return response;
    }


}
