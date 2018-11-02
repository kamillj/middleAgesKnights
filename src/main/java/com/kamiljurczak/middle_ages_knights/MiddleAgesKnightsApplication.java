package com.kamiljurczak.middle_ages_knights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:castle.properties")
public class MiddleAgesKnightsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MiddleAgesKnightsApplication.class, args);
//		Castle castle = (Castle) ctx.getBean("castle");
//        System.out.println(castle);
    }
}
