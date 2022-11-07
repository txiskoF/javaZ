package net.zabalburu.ejercicio3.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="titles")
public class Libro {
	@Id
	@Column(name="title_id")
	private String id;
	
	@Column(name="title")
	private String titulo;
	
	@Column(name="type")
	private String tipo;
	
	@Column(name="price")
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name = "pub_id")//La columna por la que se une con Editorial
	private Editorial editorial;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Compra> compras;

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", precio=" + precio + ", editorial="
				+ editorial + "]";
	}
	
	
}
