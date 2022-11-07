package net.zabalburu.tareas.modelo;

import java.util.Date;

public class Tarea {
	private Integer id;
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}
	private String descripcion;
	private Date fecha;
	private Empleado empleado;	
	public Tarea() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Tarea(Integer id, String descripcion, Date fecha, Empleado empleado) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.empleado = empleado;
	}



	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	
	
}
