package net.zabalburu.productosrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class ClienteProductosRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteProductosRestApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
}
