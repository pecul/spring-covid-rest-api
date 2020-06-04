package com.rafi.demo;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.rafi.demo.model.covid.Covid;

import reactor.core.publisher.Mono;

public class CovidClient {
	private static final WebClient covidClient = WebClient.create("https://api.covid19india.org");

	private static ResponseSpec covidStatus = covidClient.get().uri("/data.json").accept(MediaType.APPLICATION_JSON)
			.retrieve();

	public static void main(String[] args) throws InterruptedException {
		CovidClient covidClient = new CovidClient();

		Mono<Covid> covidStatus = covidClient.getCovidStatus();
		covidClient.printCovidStatus(covidStatus);
		System.out.println("===> End of main()");

		Thread.sleep(5000);
	}

	private Mono<Covid> getCovidStatus() {
		return covidStatus.bodyToMono(Covid.class);
	}

	private void printCovidStatus(Mono<Covid> covidStatus) {
		covidStatus.subscribe(cs -> {
			System.out.println("========= State wise ===========");
			cs.getStatewise().stream().filter(sw -> sw.getActive() > 1000).forEachOrdered(System.out::println);
		});
	}
}
