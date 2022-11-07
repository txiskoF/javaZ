package net.zabalburu.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Actividad151Application {

	public static void main(String[] args) {
		SpringApplication.run(Actividad151Application.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
}
