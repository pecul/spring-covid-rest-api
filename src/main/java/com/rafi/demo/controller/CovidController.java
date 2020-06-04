package com.rafi.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.rafi.demo.model.covid.Covid;
import com.rafi.demo.model.covid.CovidStatewise;
import com.rafi.demo.util.CovidUtil;

import reactor.core.publisher.Flux;

@RestController
public class CovidController {
	private ResponseSpec covidData = CovidUtil.covidData();

	// Endpoint=> /covid/state/{state}
	// MediaType.APPLICATION_JSON_VALUE => application/json
	// Get Method
	@GetMapping(path = "/covid/state/{state}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<CovidStatewise> getStatewise(@PathVariable String state) {
		return covidData.bodyToMono(Covid.class)
				.flatMapIterable(cs -> cs.getStatewise())
				.filter(sw -> state.equalsIgnoreCase(sw.getState()) || state.equalsIgnoreCase(sw.getStatecode()));
	}
}
