package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String clase;
	private String url;
	private String usuario;
	private String password;
	
	private static Connection cnn = null;
		
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
	
	public Connection getConexion() {
		if (cnn == null) {		
		try {
			Class.forName(this.clase);
			Conexion.cnn = DriverManager.getConnection(url, usuario, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		return cnn;
		
	}

}
