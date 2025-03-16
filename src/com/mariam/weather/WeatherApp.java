package com.mariam.weather;

import java.io.IOException;

public class WeatherApp {
    public static void main(String[] args) throws IOException {
        WeatherAPI api = new WeatherAPI();
        System.out.println(api.getForecast("Detroit"));
    }
}
