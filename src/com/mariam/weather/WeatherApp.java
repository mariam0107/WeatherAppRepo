package com.mariam.weather;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args)  {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What city would you like to see the weather forecast for?: ");
            String city = scanner.nextLine();

            WeatherAPI api = new WeatherAPI();
            String forecastString = api.getForecast(city);

            WeatherResponseParser parser = new WeatherResponseParser();
            parser.parseAndPrint(forecastString);
        }
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}
