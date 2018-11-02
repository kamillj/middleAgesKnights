package com.kamiljurczak.middle_ages_knights;

import com.kamiljurczak.middle_ages_knights.domain.Castle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.kamiljurczak.middle_ages_knights", "com.kamiljurczak.component"})
public class MiddleAgesKnightsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(MiddleAgesKnightsApplication.class, args);
//		Castle castle = (Castle) ctx.getBean("castle");
//        System.out.println(castle);
    }
}
