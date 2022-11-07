package net.zabalburu.actividad12.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"net.zabalburu.actividad12"})
@PropertySource("classpath:sql.prop")
public class Config {

	public Config() {
		// TODO Auto-generated constructor stub
	}

}
