package net.zabalburu.springdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import net.zabalburu.springdi.dao.ProductoBBDD;
import net.zabalburu.springdi.dao.ProductoList;
import net.zabalburu.springdi.servicio.ProductoServicio;
import net.zabalburu.springdi.util.Conexion;

@Configuration
@PropertySource("conexion.prop")
public class BeanConfiguration {

	public BeanConfiguration() {
		// TODO Auto-generated constructor stub
	}

	@Bean
	public ProductoList productoList() {
		return new ProductoList();
	}
	
	@Bean
	public Conexion conexion() {
		Conexion cnn = new Conexion("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cnn.setUrl("jdbc:sqlserver://localhost:1234;databaseName=Northwind");
		cnn.setUsuario("sa");
		cnn.setPassword("a404daw2");
		return cnn;
	}
	
	@Bean
	public ProductoBBDD productoBBDD() {
		ProductoBBDD productoBBDD = new ProductoBBDD();
		productoBBDD.setConexion(conexion()); // Inyección por referencia
		return productoBBDD;
	}
	
	@Bean
	public ProductoServicio servicio() {
		ProductoServicio servicio = new ProductoServicio();
		//servicio.setDao(productoList());
		servicio.setDao(productoBBDD());
		return servicio;
	}
	
}
