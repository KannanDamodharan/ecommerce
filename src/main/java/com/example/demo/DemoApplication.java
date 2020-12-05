package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	Environment environment;

	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("server.port: {}"+port);
		System.out.println("environment.port: {}"+environment.getProperty("server.port"));
		System.out.println("environment.port: {}"+environment.getProperty("server.host"));
	}

}
