package net.zabalburu.reuniones.dao;
import java.util.List;

import net.zabalburu.reuniones.modelo.Empleado;
import net.zabalburu.reuniones.modelo.Reunion;

public interface ReunionesDAO {
	List<Empleado> getEmpleados();
	Empleado getEmpleado(String id);
	void nuevaReunion(Reunion r);
}
