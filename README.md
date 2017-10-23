WeatherApp

Simple rest proxy and web app

root project (weather-app) - mvn install
web-service mvn spring-boot:run
web-app mvn spring-boot:run

rest service is at http://localhost:8090/api/forecast
web app - http://localhost:8080/index
This can be changed from resources/application.yml

If you press "Get my location" button, app will try to get current location from browser
and display data in table.

If you type city name in the input and press "Search city",
app will try to retrieve data for that city.


