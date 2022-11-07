package net.zabalburu.producto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("conexion")
public class Conexion {
	private String clase;
	@Value("${url}")
	private String url;
	@Value("${usuario}")
	private String usuario;
	@Value("${password}")
	private String password;
	

	private static Connection cnn = null;

	public Conexion(@Value("${clase}") String clase) {
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
		if (Conexion.cnn == null) {
			try {
				Class.forName(this.clase);
				Conexion.cnn = DriverManager.getConnection(url,usuario,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Conexion.cnn;
	}

}
