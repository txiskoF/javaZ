package net.zabalburu.actividad13.dao;

import java.util.List;

import net.zabalburu.actividad13.modelo.Empleado;
import net.zabalburu.actividad13.modelo.Reunion;

public interface ReunionDAO {
	Empleado getEmpleado(String idEmp);
	List<Empleado> getEmpleados();
	List<Reunion> getReunionesConvoca(String idEmp);
	List<Reunion> getReunionesParticipa(String idEmp);
	Reunion nuevaReunion(Reunion reunion);
	void añadirEmpleadosReunion(int idReunion, String[] idEmpleados);
}
