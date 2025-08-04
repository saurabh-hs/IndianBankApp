package com.indianbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IndianBankApp {

	public static void main(String[] args) {
		SpringApplication.run(IndianBankApp.class, args);
	}

}
