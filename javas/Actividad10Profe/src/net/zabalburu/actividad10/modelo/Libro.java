package net.zabalburu.actividad10.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="titles")
public class Libro implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="title_id", columnDefinition = "varchar(6)")
	private String id;
	
	@Column(name="title")
	private String titulo;
	
	@Column(name="type")
	private String tipo;
	
	@ManyToMany(mappedBy = "listaLectura")
	private List<Empleado> empleadoLectura;
	
	@ManyToMany(mappedBy = "recomendaciones")
	private List<Empleado> recomendadoPor;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Libro() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + "]";
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
		Libro other = (Libro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Empleado> getEmpleadoLectura() {
		return empleadoLectura;
	}

	public void setEmpleadoLectura(List<Empleado> empleadoLectura) {
		this.empleadoLectura = empleadoLectura;
	}

	public List<Empleado> getRecomendadoPor() {
		return recomendadoPor;
	}

	public void setRemcomendadoPor(List<Empleado> remcomendadoPor) {
		this.recomendadoPor = remcomendadoPor;
	}

}
