package com.MVC.consumeapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.MVC.consumeapi.controller.LatLongAPIController;
import com.MVC.consumeapi.controller.WeatherAPIController;



@SpringBootApplication
public class ConsumeapiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConsumeapiApplication.class, args);
		/*
		 * WeatherAPIController weatherAPIController =
		 * context.getBean(WeatherAPIController.class);
		 * System.out.println(weatherAPIController.GetWeatherDetails());
		 */
		
		/*
		 * LatLongAPIController latLongAPIController =
		 * context.getBean(LatLongAPIController.class);
		 * System.out.println(latLongAPIController.getLatLong("Thane", "India"));
		 */
	}

}
