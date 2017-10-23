package com.axway.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeeklyForecast extends Forecast {

    private List<Forecast> dailyForecasts = new ArrayList<>();

    public List<Forecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<Forecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
}
