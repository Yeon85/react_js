package com.lg.mams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //해제
public class LgMamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LgMamsApplication.class, args);
	}

}
