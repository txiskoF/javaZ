package net.zabalburu.actividad10.modelo;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="emp_id",columnDefinition = "CHAR(9)")
	private String id;
	
	@Column(name="lname")
	private String apellidos;
	
	@Column(name="fname")
	private String nombre;
	
	@Column(name="minit")
	private String incial;
	
	@ManyToMany
	@JoinTable(name = "listaLectura",
		joinColumns = {@JoinColumn(name="emp_id",columnDefinition = "char(9)")},
		inverseJoinColumns = {@JoinColumn(name="title_id",columnDefinition = "varchar(6)")})
	private List<Libro> listaLectura;
	
	@ManyToMany
	@JoinTable(name = "recomendaciones",
		joinColumns = {@JoinColumn(name="emp_id")},
		inverseJoinColumns = {@JoinColumn(name="title_id")})
	private List<Libro> recomendaciones;
	
	public List<Libro> getListaLectura() {
		return listaLectura;
	}

	public void setListaLectura(List<Libro> listaLectura) {
		this.listaLectura = listaLectura;
	}

	public List<Libro> getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(List<Libro> recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIncial() {
		return incial;
	}

	public void setIncial(String incial) {
		this.incial = incial;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", apellidos=" + apellidos + ", nombre=" + nombre + ", incial=" + incial + "]";
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

}
