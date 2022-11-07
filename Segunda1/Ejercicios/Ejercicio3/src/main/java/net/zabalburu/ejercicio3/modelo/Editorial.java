package net.zabalburu.ejercicio3.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="publishers")
public class Editorial {
	@Id
	@Column(name="pub_id")
	private String id;
	
	@Column(name="pub_name")
	private String nombre;
	
	@Column(name="city")
	private String ciudad;
	
	@Column(name="state")
	private String estado;
	
	@Column(name="country")
	private String pais;

	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@JsonIgnore //Ignoro los libros para que no de problemas en GestionCompras
	//al obtener el editorial
	@OneToMany(mappedBy = "editorial") // crear en Libro campo Editorial
	private List<Libro> libros;

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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	// no incluirloslibro
	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", estado=" + estado + ", pais="
				+ pais + "]";
	}
	
}
