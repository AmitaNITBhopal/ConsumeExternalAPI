package com.MVC.consumeapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.MVC.consumeapi.model.Response;

@SpringBootApplication
public class ConsumeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumeapiApplication.class, args);
		URI uri;
		String credentials = "applicationsavenues_singh_amita" + ":" + "t6W4NHjQ4b";
        String encoding = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
        
		try {
			uri = new URI("https://api.meteomatics.com/2025-05-24T00:00:00Z--2025-05-26T00:00:00Z:PT1H/t_2m:C/52.520551,13.461804/json");
			RestClient restClient = RestClient.create();
			Response response = restClient.get()
										.uri(uri).header("Authorization", "Basic " + encoding)
										.accept(MediaType.APPLICATION_JSON)//.attribute("Authorization", "Basic " + encoding)
										.retrieve()
										.body(Response.class);
			System.out.println(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //URL url = uri.toURL();
		
	}

}
