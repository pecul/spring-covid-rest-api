package com.rafi.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	@GetMapping(path = "hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getEmployees(@RequestParam(name = "user", defaultValue = "World") String name) {
		return "Hello " + name;
	}

	@GetMapping(path = "/hello", produces = { MediaType.TEXT_HTML_VALUE })
	public String getEmployeehtml() {
		return "Hello HTML";
	}
}
