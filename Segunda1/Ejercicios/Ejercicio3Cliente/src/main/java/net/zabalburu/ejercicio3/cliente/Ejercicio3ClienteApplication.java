package net.zabalburu.ejercicio3.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Ejercicio3ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio3ClienteApplication.class, args);
	}

	//añadir este bean de codificar
	@Bean
	public BCryptPasswordEncoder encoder() {
	  return new BCryptPasswordEncoder();
	}
	
	//añadir este bean de rest temaplete
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.build();
	}
	
}
