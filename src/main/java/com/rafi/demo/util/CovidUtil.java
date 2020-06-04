package com.rafi.demo.util;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

public class CovidUtil {
	public static ResponseSpec covidData() {
		final WebClient covidClient = WebClient.create("https://api.covid19india.org");
		return covidClient.get().uri("/data.json").accept(MediaType.APPLICATION_JSON).retrieve();
	}
}
