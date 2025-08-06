package com.indianbank;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@OpenAPIDefinition(
		info = @Info(
				title = "The Indian Bank App",
				description = "Backend REST API's for IndianBankApp",
				version = "v1.0.0",
				contact = @Contact(
						name = "Saurabh Shinde",
						url = "https://github.com/saurabh-hs/IndianBankApp"
				),
				license = @License(
						name = "The Indian Bank",
						url = "https://github.com/saurabh-hs/IndianBankApp"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "The Indian Banking Application Documentation",
				url = "https://github.com/saurabh-hs/IndianBankApp"
		)
)
public class IndianBankApp {

	public static void main(String[] args) {
		SpringApplication.run(IndianBankApp.class, args);
	}

}
