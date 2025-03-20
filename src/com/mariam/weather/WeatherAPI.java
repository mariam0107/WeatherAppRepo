package com.mariam.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherAPI {
    private static final String API_KEY = "API";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    public String getForecast(String city) throws IOException {
        String apiUrl = BASE_URL + "?q=" + URLEncoder.encode(city, StandardCharsets.UTF_8.toString()) + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;

        while((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();

        return response.toString();
    }
}
