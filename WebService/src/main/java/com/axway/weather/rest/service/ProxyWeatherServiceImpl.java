package com.axway.weather.rest.service;


import org.openweathermap.model.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service(value = "proxy")
public class ProxyWeatherServiceImpl implements WeatherService {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String PARAMS = "&appid=39951be17eed9d920840ad6c0827c446&units=metric";

    private RestTemplate restTemplate = new RestTemplate();

    public Response getForecastByCityName(String cityName) {
        Response response = restTemplate.getForObject(BASE_URL + "forecast?q=" + cityName
                + PARAMS, Response.class);
        return response;
    }

    @Override
    public Response getForecastByCoordinates(String longitude, String latitude) {
        Response response = restTemplate.getForObject(BASE_URL + "forecast?lon=" + longitude +
                "&lat=" + latitude
                + PARAMS, Response.class);
        return response;
    }


}
