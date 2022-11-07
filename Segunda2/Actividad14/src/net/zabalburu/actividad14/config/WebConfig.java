package net.zabalburu.actividad14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan("net.zabalburu.actividad14")
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver getResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/vistas/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
}
