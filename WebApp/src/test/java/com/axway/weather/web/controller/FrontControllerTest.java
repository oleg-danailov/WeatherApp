package com.axway.weather.web.controller;

import com.axway.weather.web.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.junit.Assert.*;

public class FrontControllerTest {

    @Test
    public void testGetTablePositive() throws Exception {
        WeatherService weatherServiceMock = Mockito.mock(WeatherService.class);
        Model modelMock = Mockito.mock(Model.class);
        FrontController frontController = new FrontController();


        frontController.setWeatherService(weatherServiceMock);
        frontController.getTable("Sofia", null, null, modelMock);

        Mockito.verify(weatherServiceMock).getForecastByCityName("Sofia");
        Mockito.verify(modelMock).addAttribute("forecast", null);

        frontController.getTable(null, "1", "2", modelMock);
        Mockito.verify(weatherServiceMock).getForecastByCoordinates("1", "2");

    }

}