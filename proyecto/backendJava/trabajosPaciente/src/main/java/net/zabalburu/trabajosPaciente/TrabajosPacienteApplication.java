package net.zabalburu.trabajosPaciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class TrabajosPacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabajosPacienteApplication.class, args);
	}

	@Bean(name = "balanceado")
	@LoadBalanced
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

}
