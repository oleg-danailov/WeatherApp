package com.axway.weather.rest.converter;

import com.axway.weather.model.WeeklyForecast;
import org.openweathermap.model.Response;

public interface DataConverter {

    WeeklyForecast convertResponse (Response response);

}
