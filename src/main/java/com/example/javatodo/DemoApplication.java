package com.example.javatodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@RequestMapping("/app")
	public String Up(){return "up ?!?  ";}

	public static void main(String[] args) {
		 SpringApplication.run(DemoApplication.class, args);
	}
}
