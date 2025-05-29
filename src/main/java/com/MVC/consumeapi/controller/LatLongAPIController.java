package com.MVC.consumeapi.controller;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.MVC.consumeapi.model.LatLong;
import com.MVC.consumeapi.model.LatLongList;
import com.MVC.consumeapi.model.WeatherDetails;

@Controller
public class LatLongAPIController {
	public LatLong[] getLatLong(String city, String country) {
		LatLong[] latLonglist = null;
		
		URI uri;
		
        try {
			uri = UriComponentsBuilder.fromUriString("https://api.api-ninjas.com/v1/geocoding")
					.queryParam("city", "{city}")
					.queryParam("country", "{country}")
					.build(city,country);
			
			RestClient restClient = RestClient.create();
			latLonglist = restClient.get()
										.uri(uri)
										.accept(MediaType.APPLICATION_JSON)
										.header("X-Api-Key", "GsDrLfXDz3vHetT37vUQqQ==fLrCa1LH9youyDna")
										.retrieve()
										.body(LatLong[].class);
			System.out.println(latLonglist[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		return latLonglist;
	}
}
