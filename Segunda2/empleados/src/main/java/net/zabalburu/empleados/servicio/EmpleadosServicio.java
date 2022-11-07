package net.zabalburu.empleados.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.zabalburu.empleados.dao.EmpleadosRepositorio;
import net.zabalburu.empleados.modelo.Empleado;

public class EmpleadosServicio {

	@Autowired
	private EmpleadosRepositorio dao;
	
	public List<Empleado> getEmpleados(){
		return dao.findAll();
	}
	
	public Empleado login(Integer idEmpleado, String password){
		Empleado e = dao.findByIdAndExtension(idEmpleado, password);
        if (e != null){
            if (!e.getExtension().equals(password)){
               e = null;
            }
        }
        return e;
    }
}
