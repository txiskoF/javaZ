package net.zabalburu.ejercicio3.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="compras")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idlibro")
	private Libro libro;
	
	private Integer unidades;
	
	private Double precio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//Formato para mostrar fecha en miscompras.html
	@JsonFormat(pattern = "yyyy-MM-dd")
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
