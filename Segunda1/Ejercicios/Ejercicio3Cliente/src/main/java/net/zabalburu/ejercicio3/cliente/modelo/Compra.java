package net.zabalburu.ejercicio3.cliente.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Compra {
	private Integer id;
	
	private Usuario usuario;
	
	private Libro libro;
	
	private Integer unidades;
	
	private Double precio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	public Compra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", usuario=" + usuario + ", libro=" + libro + ", unidades=" + unidades + ", precio="
				+ precio + ", fecha=" + fecha + "]";
	}
	
	
	
}
