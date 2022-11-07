package net.zabalburu.actividad13.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import net.zabalburu.actividad13.dao.ReunionDAO;

import org.springframework.stereotype.Service;

import net.zabalburu.actividad13.modelo.Empleado;
import net.zabalburu.actividad13.modelo.Reunion;

@Service
public class ReunionServicio {
	
	@Autowired
	private ReunionDAO dao;
	
	public List<Empleado> getEmpleados(){
		return dao.getEmpleados();
	}
	public List<Reunion> getReunionesConvoca(String idEmp){
		return dao.getReunionesConvoca(idEmp);
	}
	public List<Reunion> getReunionesParticipa(String idEmp){
		return dao.getReunionesParticipa(idEmp);
	}
	
	public Empleado getEmpleado(String idEmp) {
		return dao.getEmpleado(idEmp);
	}
	
	public Empleado login(String idEmp, String pwd) {
		Empleado e = getEmpleado(idEmp);
		if (e != null) {
			if (!e.getId().equals(pwd)) {
				e = null;
			}
		}
		return e;
	}
	
	public Reunion nuevaReunion(Reunion reunion) {
		return dao.nuevaReunion(reunion);
	}
	
	public void añadirEmpleadosReunion(int idReunion, String[] idEmpleados) {
		dao.añadirEmpleadosReunion(idReunion, idEmpleados);
	}
}
