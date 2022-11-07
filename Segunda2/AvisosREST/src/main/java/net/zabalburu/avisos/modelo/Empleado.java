package net.zabalburu.avisos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "employee")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private String id;
	
	@Column(name = "fname")
	private String nombre;
	
	@Column(name="lname")
	private String apellido;
	
	@OneToMany(mappedBy = "empleado")
	@JsonIgnore
	private List<Aviso> avisos;
	
	@OneToMany(mappedBy = "empleado")
	@JsonIgnore
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
