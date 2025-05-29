package com.MVC.consumeapi.controller;

import java.io.File;

import java.lang.StackWalker.Option;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Clock;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.MVC.consumeapi.model.Coordinate;
import com.MVC.consumeapi.model.Datum;
import com.MVC.consumeapi.model.LatLong;
import com.MVC.consumeapi.model.LocationName;
import com.MVC.consumeapi.model.WeatherDetails;
import com.MVC.consumeapi.model.WethDate;

@Controller
public class WeatherAPIController {

	final String BASEURL = "https://api.meteomatics.com/";
	final String USERNAME = "applicationsavenues_singh_amita";
	final String PASSWORD = "t6W4NHjQ4b";
	final String FORMAT = "html";
	final String FILESHORTNAME = "temp." + FORMAT;
	final String FILELONGNAME = "src\\main\\resources\\static\\temp." + FORMAT;
	
	@Autowired
	LatLongAPIController latLongAPIController;
	
	public String GetLatLong() {
		return "lat long data";
	}
	
	@GetMapping("/location") 
	public String GetLocation(Model model) {
		model.addAttribute("locationName", new LocationName());
		System.out.println("GetLocation " + model.toString());
		return "LatLong";
	}
	
	
	  @PostMapping("/location") 
	  public String locationCapture(@ModelAttribute("city-name") String city, @ModelAttribute("country-name") String country, Model model) { 
		  System.out.println("Inside locationCapture " + city + " " + country);
		  
		  //call lat long api and show that on screen
		  //LocationName locationName = new LocationName(city, country);
		  
		  LatLong[] latLongarray = latLongAPIController.getLatLong(city, country);
		  model.addAttribute("locationName", latLongarray[0]);
		  model.addAttribute("test", "successful");
			
		  WeatherDetails weatherDtls = GetWeatherDetails(latLongarray[0].getLatitude(), latLongarray[0].getLongitude()); 
		  model.addAttribute("weatherDtls", weatherDtls);
			 
		  if(weatherDtls.data.size()>0) {
			  for(Datum datum : weatherDtls.data) {
				  switch(datum.getParameter()) {
				  case "t_2m:C":
					  model.addAttribute("temperature", datum.coordinates.get(0).dates.get(0).getValue());
					  break;
					  
				  case "sunrise:sql":
					  model.addAttribute("sunrise", datum.coordinates.get(0).dates.get(0).getValue());
					  break;
					  
				  case "sunset:sql":
					  model.addAttribute("sunset", datum.coordinates.get(0).dates.get(0).getValue());
					  break;
					  
				  case "t_max_2m_24h:C":
					  model.addAttribute("maxtemp", datum.coordinates.get(0).dates.get(0).getValue());
					  break;
					  
				  case "t_min_2m_24h:C":
					  model.addAttribute("mintemp", datum.coordinates.get(0).dates.get(0).getValue());
					  break;
					 
				  default:
						  model.addAttribute("nodata", "true");
						  break;
						  
				  }
			  }
		  }
		  
		  if(latLongarray != null) {
			  String filepath = GetWeatherGraphPath(latLongarray[0].getLatitude(), latLongarray[0].getLongitude());
			  model.addAttribute("filename",filepath);
		  }
		  return "locationdata";
	  }
	 
	 
	/*
	 * @PostMapping("/LocationName") public String locationCapture(@ModelAttribute
	 * LocationName locationName) { //final RedirectView redirectView = new
	 * RedirectView("/LatLong", true); System.out.println("Inside locationCapture "
	 * + locationName.getCity() + " " + locationName.getCountry()); //String str =
	 * model.get("city-name"); return "LatLong"; }
	 */	
	public WeatherDetails GetWeatherDetails(Double lat, Double longitude) {
		URI uri;
		String credentials = USERNAME + ":" + PASSWORD;
        String encoding = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        WeatherDetails weatherDetails = null;
        
		try {
			Clock utcClock = Clock.systemUTC();
			
			uri = new URI(BASEURL + utcClock.instant() 
					+ "/t_2m:C,sunrise:sql,sunset:sql,t_max_2m_24h:C,t_min_2m_24h:C/" 
					+ lat.longValue() + "," + longitude.longValue() 
					+ "/json");
			RestClient restClient = RestClient.create();
			weatherDetails = restClient.get()
										.uri(uri).header("Authorization", "Basic " + encoding)
										.accept(MediaType.APPLICATION_JSON)
										.retrieve()
										.body(WeatherDetails.class);
			System.out.println(weatherDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return weatherDetails;
	}
	
	public String GetWeatherGraphPath(Double lat, Double longitude) {
		URI uri;
		String filename = FILELONGNAME;
		String credentials = USERNAME + ":" + PASSWORD;
        String encoding = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        
		try {
			Clock utcClock = Clock.systemUTC();
								
			//https://api.meteomatics.com/2025-05-26T11:20:00.000+02:00/t_2m:C/51.5073219,-0.1276474/html?model=mix
			
			uri = new URI(BASEURL 
					+ utcClock.instant() 
					+ "P1W:PT1H/t_2m:C/" 
					+ lat.longValue() + "," + longitude.longValue() 
					+ "/" + FORMAT);
			RestClient restClient = RestClient.create();
			String htmlData = restClient.get()
										.uri(uri).header("Authorization", "Basic " + encoding)
										.accept(MediaType.APPLICATION_JSON)
										.retrieve()
										.body(String.class);
			
			if(htmlData.length()>0) {
				File file = new File(filename);
				if(file.exists()) {
					//delete the file
					try {
						file.delete();
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
				
				Files.writeString(Path.of(filename), htmlData, StandardOpenOption.CREATE);
				
			}
			
			System.out.println(" inside GetWeatherGraphPath, no exceptions");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return FILESHORTNAME;
	}
	
}
