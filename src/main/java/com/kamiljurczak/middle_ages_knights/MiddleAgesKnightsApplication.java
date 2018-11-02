package com.kamiljurczak.middle_ages_knights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiddleAgesKnightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleAgesKnightsApplication.class, args);
    }
}
