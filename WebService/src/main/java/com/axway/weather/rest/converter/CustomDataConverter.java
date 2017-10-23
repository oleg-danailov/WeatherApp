package com.axway.weather.rest.converter;

//import com.axway.weather.model.Forecast;
import com.axway.weather.model.WeeklyForecast;
import org.openweathermap.model.Forecast;
import org.openweathermap.model.Main;
import org.openweathermap.model.Response;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class CustomDataConverter implements DataConverter{

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2017-10-28 00:00:00
    @Override
    public WeeklyForecast convertResponse(Response response) {
        WeeklyForecast weeklyForecast = new WeeklyForecast();
        List<com.axway.weather.model.Forecast> dailyForecasts = convertDailyForecasts(response);
        //calculate weekly min and max
//        weeklyForecast.setMaxTemp(25.0);
//        weeklyForecast.setMinTemp(15.0);

//        List<Forecast> list = new ArrayList<>();
//        list.add(new Forecast(15, 25));
//        list.add(new Forecast(13, 20));
//        list.add(new Forecast(12, 20));
        weeklyForecast.setDailyForecasts(dailyForecasts);
        calculateWeeklyMinAndMaxTemp(weeklyForecast);
        return weeklyForecast;
    }

    private void calculateWeeklyMinAndMaxTemp(WeeklyForecast weeklyForecast) {
        weeklyForecast.setMaxTemp(weeklyForecast.getDailyForecasts().get(0).getMaxTemp());
        weeklyForecast.setMinTemp(weeklyForecast.getDailyForecasts().get(0).getMinTemp());
        for (int i = 1; i < weeklyForecast.getDailyForecasts().size(); i++) {
            com.axway.weather.model.Forecast forecast = weeklyForecast.getDailyForecasts().get(i);
            if (weeklyForecast.getMaxTemp() < forecast.getMaxTemp()){
                weeklyForecast.setMaxTemp(forecast.getMaxTemp());
            }
            if (weeklyForecast.getMinTemp() > forecast.getMinTemp()){
                weeklyForecast.setMinTemp(forecast.getMinTemp());
            }
        }
    }

    private List<com.axway.weather.model.Forecast> convertDailyForecasts(Response response) {
        List<com.axway.weather.model.Forecast> result = new ArrayList<>();

        List<Forecast> tempList = new ArrayList<>();
        GregorianCalendar initialDate =  new GregorianCalendar();
        GregorianCalendar current =  new GregorianCalendar();
//        initialDate.setTime(new Date(response.getList().get(0).getDt()));
        try {
            initialDate.setTime(dateFormat.parse(response.getList().get(0).getDtTxt()));//TODO if != null size > 1
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < response.getCnt(); i++) {
            Forecast forecast = response.getList().get(i);
//            current.setTime(new Date(forecast.getDt()));
            try {
                current.setTime(dateFormat.parse(response.getList().get(i).getDtTxt()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            Date date = new Date();
//            date.getDate();

            if(current.get(Calendar.DAY_OF_MONTH) != initialDate.get(Calendar.DAY_OF_MONTH)){

                com.axway.weather.model.Forecast newForecast = createForecast(tempList);
                newForecast.setDate(initialDate.getTime());
                result.add(newForecast);
                tempList =  new ArrayList<>();
                initialDate.setTime(current.getTime());
            } else {
                tempList.add(forecast);
            }

        }
        //collect data inside list while date is the same
        //calculate min and max and create new forecast
        return result;
    }

    private com.axway.weather.model.Forecast createForecast(List<Forecast> inputList) {
        com.axway.weather.model.Forecast forecast = new com.axway.weather.model.Forecast();
        Main first = inputList.get(0).getMain();
        forecast.setMaxTemp(first.getTempMax());
        forecast.setMinTemp(first.getTempMin());
        for (Forecast current: inputList){
            Main main = current.getMain();
            if (main.getTempMax() > forecast.getMaxTemp()){
                forecast.setMaxTemp(main.getTempMax());
            }
            if (main.getTempMin() < forecast.getMinTemp()){
                forecast.setMinTemp(main.getTempMin());
            }
        }
        return forecast;
    }


}
