package com.shawn.vhrmail;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VhrmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(VhrmailApplication.class, args);
	}

	@Bean
	Queue queue(){
		return new Queue("shawn.mail.welcome");
	}

}
