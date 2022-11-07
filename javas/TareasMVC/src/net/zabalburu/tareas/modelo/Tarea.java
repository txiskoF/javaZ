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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
