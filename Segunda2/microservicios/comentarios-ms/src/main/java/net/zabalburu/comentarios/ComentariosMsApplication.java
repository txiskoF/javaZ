package net.zabalburu.comentarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ComentariosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComentariosMsApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
