package net.zabalburu.clienteproductos.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import net.zabalburu.clienteproductos.modelo.Producto;

public class OfertaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer idProd;
	
	public Integer getIdProd() {
		return idProd;
	}

	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}

	private Date fecha;
	
	private double precio;
	
	private boolean activa;

	public OfertaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}


	@Override
	public String toString() {
		return "OfertaDTO [id=" + id + ", idProd=" + idProd + ", fecha=" + fecha + ", precio=" + precio + ", activa="
				+ activa + "]";
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
		OfertaDTO other = (OfertaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
