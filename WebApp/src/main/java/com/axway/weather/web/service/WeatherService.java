package com.axway.weather.web.service;

import com.axway.weather.model.WeeklyForecast;

public interface WeatherService {

    WeeklyForecast getForecastByCityName(String cityName);

    WeeklyForecast getForecastByCoordinates(String longitude, String latitude);
}
