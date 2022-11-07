package net.zabalburu.actividad12.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.actividad12.conexion.Conexion;

@Repository("modeloBBDD")
public class ModeloBBDD {
	@Autowired
	private Conexion conexion;
	
	private List<String> tablas = new ArrayList<String>();

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}

	public String getBBDD() {
		String bbdd = null;
		try {
			bbdd = conexion.getCnn().getCatalog();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bbdd;
	}
	public List<String> getTablas() {
		return tablas;
	}

	public void setTablas(List<String> tablas) {
		this.tablas = tablas;
	}

	public ModeloBBDD() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		try {
			ResultSet r = this.conexion.getCnn().getMetaData().getTables(null, null, null, 
					new String[]{"TABLE"});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
