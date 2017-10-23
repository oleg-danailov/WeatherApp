package com.axway.weather.rest.service;

import org.openweathermap.model.Response;

public interface WeatherService {

    Response getForecastByCityName(String cityName);

    Response getForecastByCoordinates(String longitude, String latitude);
}
