package net.zabalburu.avisoscliente.modelo;

import java.io.Serializable;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;



public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	
	
	private String nombre;
	
	
	private String apellido;
	
	
	private List<Aviso> avisos;
	
	
	private List<Respuesta> respuestas;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(String id, String nombre, String apellido, List<Aviso> avisos, List<Respuesta> respuestas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.avisos = avisos;
		this.respuestas = respuestas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public void setAvisos(List<Aviso> avisos) {
		this.avisos = avisos;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
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
		Empleado other = (Empleado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", avisos=" + avisos
				+ ", respuestas=" + respuestas + "]";
	}
	
	
}
