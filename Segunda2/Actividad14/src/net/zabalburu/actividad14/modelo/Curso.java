package net.zabalburu.actividad14.modelo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Curso {
	private Integer id;
	
	@NotEmpty(message = "Debe especificarse el título")
	private String titulo;
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private Tema tema;
	public Curso(Integer id, String titulo, Tema tema, int asistentes, Date fechaInicio, Date fechaFin, double precio) {
		super();
		this.id = id;
		this.tema = tema;
		this.asistentes = asistentes;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.titulo = titulo;
	}

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public int getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private int asistentes;
	
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@Future(message = "La fecha de inicio debe ser posterior a hoy")
	private Date fechaInicio;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	@Future(message = "La fecha de fin debe ser posterior a hoy")
	private Date fechaFin;
	
	@NumberFormat
	@PositiveOrZero(message = "El precio no puede ser negativo")
	private double precio;
	
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", tema=" + tema + ", asistentes=" + asistentes + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", precio=" + precio + "]";
	}
	
	
}
