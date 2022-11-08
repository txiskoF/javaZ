package net.zabalburu.empleados.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.empleados.dao.EmpleadoRepositorio;
import net.zabalburu.empleados.modelo.Empleado;

@Service
public class EmpleadosServicio {

	@Autowired
	private EmpleadoRepositorio empleadoDAO;

	public List<Empleado> getEmpleados() {
		return empleadoDAO.getEmpleados();
	}

	public Empleado login(String email, String password) {
		Empleado e = empleadoDAO.findByEmailAndPassword(email, password);
		if (e == null) {
			e = new Empleado();
		}
		return e;
	}

	public Empleado getEmpleado(Integer id) {
		return empleadoDAO.findById(id).orElse(null);
	}

	public Empleado guardarEmpleado(Empleado e) {
		return empleadoDAO.save(e);
	}

	public void eliminarEmpleado(Integer id) {
		empleadoDAO.deleteById(id);
	}

	public Empleado getEmpleado(String nombre, String primerApellido) {
		return empleadoDAO.findByNombreAndPrimerApellido(nombre, primerApellido).orElse(null);
	}

}
