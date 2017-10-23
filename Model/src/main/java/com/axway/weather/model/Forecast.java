package com.axway.weather.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forecast implements Comparable<Forecast> {

    private Double minTemp;
    private Double maxTemp;
    private Date date;

    public Forecast(){
        //default constructor
    }
    public Forecast (double minTemp, double maxTemp){
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(Forecast forecast) {
        return this.date.compareTo(forecast.getDate());
    }
}
