package net.zabalburu.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="au_id")
	private String id;
	
	@Column(name="au_lname")
	private String apellidos;
	
	@Column(name="au_fname")
	private String nombre;
	
	@Column(name="address")
	private String direccion;
	
	@Column(name="city")
	private String ciudad;
	
	@Column(name="phone")
	private String telefono;
	
	@ManyToMany
	@JoinTable(name = "titleauthor",
		joinColumns = {@JoinColumn(name="au_id")},
		inverseJoinColumns = {@JoinColumn(name="title_id")}
	)
	private List<Titulo> titulos;

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public Autor() {
		super();
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
		Autor other = (Autor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", apellidos=" + apellidos + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", ciudad=" + ciudad + ", telefono=" + telefono + "]";
	}
	
	
	
}
