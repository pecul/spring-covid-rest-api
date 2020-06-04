package com.rafi.demo;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.rafi.demo.model.Employee;

public class APIClient {
	private static final WebClient localClient = WebClient.create("http://localhost:8080");

	private static ResponseSpec employees = localClient.get().uri("/employees").accept(MediaType.APPLICATION_JSON)
			.retrieve();

	public static void main(String[] args) throws InterruptedException {
		APIClient apiClient = new APIClient();

		apiClient.getEmployees();
		System.out.println("===> End of main()");
		
		Thread.sleep(5000);
	}

	private void getEmployees() {
		employees.bodyToFlux(Employee.class).subscribe(e-> System.out.println("===> " + e));
	}
}
