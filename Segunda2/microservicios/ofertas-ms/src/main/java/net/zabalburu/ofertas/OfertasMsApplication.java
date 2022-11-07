package net.zabalburu.ofertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OfertasMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfertasMsApplication.class, args);
	}

	
	// A través de Eureka empleando el nombre del servicio
	@Bean(name = "balanceado")
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	// Directamente sin pasar por Eureka empleando dirección y puerto
	@Bean(name="normal")
	public RestTemplate getTemplate2() {
		return new RestTemplate();
	}
	
}
