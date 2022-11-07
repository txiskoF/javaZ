package net.zabalburu.ejercicio3.cliente.modelo;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Libro {
	private String id;
	
	private String titulo;
	
	private String tipo;
	
	private Double precio;
	
	private Editorial editorial;
	
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
