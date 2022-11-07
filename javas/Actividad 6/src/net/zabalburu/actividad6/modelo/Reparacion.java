package net.zabalburu.actividad6.modelo;

import java.util.Date;

public class Reparacion {
	private Integer rep_no;
	private String usuario = "";
	private String elemento ="";
	private Date fechaSolicitud;
	private String descripcion = "";
	private Date fechaReparacion;
	private Double coste;
	private String reparador = "";
	public Reparacion(Integer rep_no, String usuario, String elemento, Date fechaSolicitud, String descripcion,
			Date fechaReparacion, Double coste, String reparador) {
		super();
		this.rep_no = rep_no;
		this.usuario = usuario;
		this.elemento = elemento;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
		this.fechaReparacion = fechaReparacion;
		this.coste = coste;
		this.reparador = reparador;
	}
	
	public Reparacion(Integer rep_no, String usuario, String elemento, Date fechaSolicitud, String descripcion) {
		super();
		this.rep_no = rep_no;
		this.usuario = usuario;
		this.elemento = elemento;
		this.fechaSolicitud = fechaSolicitud;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Reparacion [rep_no=" + rep_no + ", usuario=" + usuario + ", elemento=" + elemento + ", fechaSolicitud="
				+ fechaSolicitud + ", descripcion=" + descripcion + ", fechaReparacion=" + fechaReparacion + ", coste="
				+ coste + ", reparador=" + reparador + "]";
	}
	
	public Reparacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getRep_no() {
		return rep_no;
	}
	public void setRep_no(Integer rep_no) {
		this.rep_no = rep_no;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaReparacion() {
		return fechaReparacion;
	}
	public void setFechaReparacion(Date fechaReparacion) {
		this.fechaReparacion = fechaReparacion;
	}
	public Double getCoste() {
		return coste;
	}
	public void setCoste(Double coste) {
		this.coste = coste;
	}
	public String getReparador() {
		return reparador;
	}
	public void setReparador(String reparador) {
		this.reparador = reparador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rep_no == null) ? 0 : rep_no.hashCode());
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
		Reparacion other = (Reparacion) obj;
		if (rep_no == null) {
			if (other.rep_no != null)
				return false;
		} else if (!rep_no.equals(other.rep_no))
			return false;
		return true;
	}
	
}
