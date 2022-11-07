package net.zabalburu.actividad12.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Conexion {
	private String url;
	private String usuario;
	private String password;
	
	private Connection cnn;
	
	public Conexion(
			@Value("${clase}") String clase,
			@Value("${url}") String url, 
			@Value("${usuario}") String usuario, 
			@Value("${password}") String password) {
		super();
		try {
			Class.forName(clase);
			this.cnn = DriverManager.getConnection(url, usuario, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Connection getCnn() {
		return cnn;
	}

	public void setCnn(Connection cnn) {
		this.cnn = cnn;
	}

	public Conexion() {
		// TODO Auto-generated constructor stub
	}

}
