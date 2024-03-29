package net.zabalburu.tareas.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.zabalburu.tareas.modelo.Empleado;
import net.zabalburu.tareas.modelo.Tarea;

public class TareasServicio {
	private ArrayList<Tarea> tareas = new ArrayList<>();
	private ArrayList<Empleado> empleados = new ArrayList<>();
	
	public TareasServicio() {
		empleados.add(new Empleado(1,"Luis","Lopez","luis@gmail.com","12345"));
		empleados.add(new Empleado(2,"Ana","Perez","ana@gmail.com","12345"));
		empleados.add(new Empleado(3,"Carlos","Sanz","carlos@gmail.com","12345"));
		tareas.add(new Tarea(1,"Tarea 1", new GregorianCalendar(2020,8,21).getTime(),empleados.get(1)));
		tareas.add(new Tarea(2,"Tarea 2", new GregorianCalendar(2020,9,12).getTime(),empleados.get(2)));
		tareas.add(new Tarea(3,"Tarea 3", new GregorianCalendar(2020,9,20).getTime(),empleados.get(1)));
		tareas.add(new Tarea(4,"Tarea 4", new GregorianCalendar(2020,8,25).getTime(),empleados.get(2)));
		tareas.add(new Tarea(5,"Tarea 5", new GregorianCalendar(2020,9,2).getTime(),empleados.get(2)));
		tareas.add(new Tarea(6,"Tarea 6", new GregorianCalendar(2020,8,19).getTime(),empleados.get(1)));
		tareas.add(new Tarea(7,"Tarea 7", new GregorianCalendar(2020,9,1).getTime(),empleados.get(2)));
		tareas.add(new Tarea(8,"Tarea 8", new GregorianCalendar(2020,9,30).getTime(),empleados.get(2)));
	}
	
	public Empleado login(String email, String pwd) {
		Empleado e = null;
		int i;
		for(i=0; i<empleados.size() && 
			!email.equalsIgnoreCase(empleados.get(i).getEmail());
			i++);
		if (i < empleados.size()) {
			if (pwd.equals(empleados.get(i).getPassword())) {
				e = empleados.get(i);
			}
		}
		return e;
	}
	
	public List<Tarea> getTareasEmpleado(Empleado e){
		List<Tarea> tareasE = new ArrayList<>();
		for(Tarea t : tareas) {
			if (t.getEmpleado() == e) {
				tareasE.add(t);
			}
		}
		return tareasE;
	}

	public void nuevaTarea(Integer idEmpleado, String descripcion,
			Date fecha) {
		// Como id el de la �ltima tarea + 1
	}
	
	
	public List<Tarea> getTareasDisponibles(Integer idEmpleado) {
		
	}

	public static void main(String[] args) {
		TareasServicio s = new TareasServicio();
		System.out.println(s.login("noex", "noex"));
		System.out.println(s.login("luis@gmail.com", ""));
		Empleado e = s.login("ana@gmail.com", "12345");
		System.out.println(e.getApellidos() + ",  " + e.getNombre());
		for(Tarea t : s.getTareasEmpleado(e)) {
			System.out.println(t.getDescripcion());
		}
	}
	
	
	
}
