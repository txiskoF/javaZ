package net.zabalburu.actividad13.modelo;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Reunion {
	private int id;
	private String nombre;
	private Date fecha;
	private String hora;
	private int duracion;
	private String lugar;
	private Empleado convoca;
	private String observaciones;
	private List<Empleado> asistentes = new ArrayList<Empleado>();
	
	
	public List<Empleado> getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(List<Empleado> asistentes) {
		this.asistentes = asistentes;
	}
	public Reunion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reunion(int id, String nombre, Date fecha, String hora, int duracion, String lugar, Empleado convoca,
			String observaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.lugar = lugar;
		this.convoca = convoca;
		this.observaciones = observaciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public Empleado getConvoca() {
		return convoca;
	}
	public void setConvoca(Empleado convoca) {
		this.convoca = convoca;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Reunion other = (Reunion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reunión [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", duracion="
				+ duracion + ", lugar=" + lugar + ", convoca=" + convoca + ", observaciones=" + observaciones + "]";
	}
	
	
	
}
