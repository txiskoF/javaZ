package net.zabalburu.actividad13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("net.zabalburu.actividad13")
public class AppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver ic = new InternalResourceViewResolver();
		ic.setPrefix("/WEB-INF/vistas/");
		ic.setSuffix(".jsp");
		return ic;
	}
}
