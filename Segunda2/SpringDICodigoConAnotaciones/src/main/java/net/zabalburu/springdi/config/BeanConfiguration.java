package net.zabalburu.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import net.zabalburu.springdi.dao.ProductoBBDD;
import net.zabalburu.springdi.dao.ProductoList;
import net.zabalburu.springdi.servicio.ProductoServicio;
import net.zabalburu.springdi.util.Conexion;

@Configuration
@ComponentScan("net.zabalburu.springdi")
@PropertySource("conexion.prop")
public class BeanConfiguration {

	public BeanConfiguration() {
		// TODO Auto-generated constructor stub
	}

	
	
}
