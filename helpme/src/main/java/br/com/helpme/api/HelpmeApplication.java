package br.com.helpme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class HelpmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpmeApplication.class, args);
	}

}
