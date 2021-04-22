package com.meritamerica.assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.meritamerica.assignment5.repositories.AccountHolderRepository;


@SpringBootApplication
public class Assignment5Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment5Application.class, args);
	}

}
