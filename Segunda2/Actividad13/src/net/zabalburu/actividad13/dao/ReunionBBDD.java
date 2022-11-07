package net.zabalburu.actividad13.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.actividad13.modelo.Empleado;
import net.zabalburu.actividad13.modelo.Reunion;
import net.zabalburu.actividad13.util.Conexion;

@Repository
public class ReunionBBDD implements ReunionDAO {

	@Autowired
	private Conexion cnn;
	
	@Override
	public List<Empleado> getEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			ResultSet rst = cnn.getConexion()
					.createStatement()
					.executeQuery(
					"Select * From Employee Order by lname,fname");
			while (rst.next()) {
				empleados.add(cargarEmpleado(rst));
			}
			rst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empleados;
	}

	private Empleado cargarEmpleado(ResultSet rst) {
		Empleado e = new Empleado();
		try {
			e.setId(rst.getString("emp_id"));
			e.setApellidos(rst.getString("lname"));
			e.setNombre(rst.getString("fname"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public List<Reunion> getReunionesConvoca(String idEmp) {
		List<Reunion> reuniones = new ArrayList<>();
		try {
			PreparedStatement pst = cnn.getConexion()
					.prepareStatement(
					"Select * From Reunion Where convoca=? Order by fecha desc");
			pst.setString(1, idEmp);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				reuniones.add(cargarReunion(rst));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reuniones;
	}

	private Reunion cargarReunion(ResultSet rst) {
		Reunion r = new Reunion();
		try {
			r.setConvoca(getEmpleado(rst.getString("convoca")));
			r.setDuracion(rst.getInt("duracion"));
			r.setObservaciones(rst.getString("observaciones"));
			r.setFecha(rst.getDate("fecha"));
			r.setHora(rst.getString("hora"));
			r.setId(rst.getInt("id"));
			r.setLugar(rst.getString("lugar"));
			r.setNombre(rst.getString("nombre"));
			PreparedStatement pst = cnn.getConexion()
				.prepareStatement(
				"Select e.emp_id, e.lname, e.fname " +
			    "From Employee e, ReunionEmpleado re " +
			    "Where e.emp_id = re.idEmpleado and re.idReunion=?");
			pst.setInt(1, r.getId());
			ResultSet rstE = pst.executeQuery();
			while (rstE.next()) {
				r.getAsistentes().add(cargarEmpleado(rstE));
			}
			rstE.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public List<Reunion> getReunionesParticipa(String idEmp) {
		List<Reunion> reuniones = new ArrayList<>();
		try {
			PreparedStatement pst = cnn.getConexion()
					.prepareStatement(
					"Select r.id,r.nombre,r.fecha,r.hora,r.duracion,r.lugar,r.convoca,r.observaciones "+ 
					"From Reunion r, ReunionEmpleado re " +
					"Where r.id=re.idReunion And idEmpleado=? Order by r.fecha desc");
			pst.setString(1, idEmp);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				reuniones.add(cargarReunion(rst));
			}
			rst.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reuniones;
	}

	@Override
	public Empleado getEmpleado(String idEmp) {
		Empleado e = null;
		try {
			PreparedStatement pst = cnn.getConexion()
					.prepareStatement(
					"Select * From Employee Where emp_id=?");
			pst.setString(1, idEmp);
			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				e = cargarEmpleado(rst);
			}
			rst.close();
			pst.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public Reunion nuevaReunion(Reunion reunion) {
		try {
			PreparedStatement pst = cnn.getConexion()
					.prepareStatement(
					"Insert Into Reunion(nombre,fecha,hora,duracion,lugar,convoca,observaciones) "+
					"values (?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1,reunion.getNombre());
			pst.setDate(2,new java.sql.Date(reunion.getFecha().getTime()));
			pst.setString(3,reunion.getHora());
			pst.setInt(4,reunion.getDuracion());
			pst.setString(5,reunion.getLugar());
			pst.setString(6,reunion.getConvoca().getId());
			pst.setString(7,reunion.getObservaciones());
			pst.executeUpdate();
			ResultSet rst = pst.getGeneratedKeys();
			if (rst.next()) {
				reunion.setId(rst.getInt(1));
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reunion;
	}

	@Override
	public void añadirEmpleadosReunion(int idReunion, String[] idEmpleados) {
		try {
			PreparedStatement pst = cnn.getConexion()
					.prepareStatement("Insert into reunionEmpleado(idReunion,idEmpleado) "+
							"values(?,?)");
			for(String id : idEmpleados) {
				pst.setInt(1,idReunion);
				pst.setString(2,id);
				pst.executeUpdate();
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
