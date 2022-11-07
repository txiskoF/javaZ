package net.zabalburu.springdi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection cnn = null; 
	
	private String clase;
	private String url;
	private String usuario;
	private String password;
	
	
	public Conexion(String clase) {
		super();
		System.out.println("Instanciando Conexion");
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
		System.out.println("Instanciando Conexion");
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
