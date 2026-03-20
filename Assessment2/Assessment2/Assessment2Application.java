package com.example.Assessment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Assessment2.web.TrackController;

@SpringBootApplication
public class Assessment2Application {
	
	@Autowired
	TrackController trackController;

	public static void main(String[] args) {
		System.out.println("Application Context is Loaded!!!");
		SpringApplication.run(Assessment2Application.class, args);
	}

}
