package net.zabalburu.productosmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("conexion")
public class Conexion {
	
	private Connection cnn = null; 
	
	@Value("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	private String clase;
	
	@Value("jdbc:sqlserver://localhost:1234;databaseName=Northwind")
	private String url;
	
	@Value("sa")
	private String usuario;
	
	@Value("a404daw2")
	private String password;
	
	public Conexion(String clase) {
		super();
		this.clase = clase;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Conexion() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConexion() {
		if (cnn!=null) return cnn;
		try {
			Class.forName(clase);
			cnn = DriverManager.getConnection(url,usuario,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.cnn;
	}
	
	
}
