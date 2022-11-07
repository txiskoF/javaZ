package net.zabalburu.reuniones.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import net.zabalburu.reuniones.dao.ReunionesDAO;
import net.zabalburu.reuniones.modelo.Empleado;
import net.zabalburu.reuniones.modelo.Reunion;

@Service
public class ReunionesServicio {
	@Autowired
	private ReunionesDAO dao;
	
	public List<Empleado> getEmpleados(){
		return dao.getEmpleados();
	}
	
	public Empleado getEmpleado(String id) {
		return dao.getEmpleado(id);
	}
	
	public void nuevaReunion(Reunion r) {
		dao.nuevaReunion(r);
	}
	
	public Empleado login(String apellido, String id){
		Empleado e = dao.getEmpleado(id);
		if (e != null) {
			if (!e.getApellidos().equalsIgnoreCase(apellido)) {
				e = null;
			}
		}
		return e;
	}
	
}
