package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebappApplication.class, args);
		System.out.println("main");
	}

}