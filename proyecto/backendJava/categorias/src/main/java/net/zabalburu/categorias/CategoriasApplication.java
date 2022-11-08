package net.zabalburu.categorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CategoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriasApplication.class, args);
	}

	@Bean(name = "balanceado")
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
