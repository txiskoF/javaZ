package net.zabalburu.avisoscliente.modelo;

import java.io.Serializable;
import java.util.Date;



public class Respuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	
	private Empleado empleado;
	
	private Aviso aviso;
	
	private Date fecha;
	
	private String mensaje;

	public Respuesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Respuesta(Integer id, Empleado empleado, Aviso aviso, Date fecha, String mensaje) {
		super();
		this.id = id;
		this.empleado = empleado;
		this.aviso = aviso;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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
		Respuesta other = (Respuesta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", empleado=" + empleado + ", aviso=" + aviso + ", fecha=" + fecha + ", mensaje="
				+ mensaje + "]";
	}
	
	
	
	
}
