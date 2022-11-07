package net.zabalburu.clienteproductos.modelo;

import java.io.Serializable;
import java.util.Date;

public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Producto producto;
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	private Date fecha;
	
	private double precio;
	
	private boolean activa;

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Oferta(Integer id, Producto producto, Date fecha, double precio, boolean activa) {
		super();
		this.id = id;
		this.producto = producto;
		this.fecha = fecha;
		this.precio = precio;
		this.activa = activa;
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
		return "Oferta [id=" + id + ", producto=" + producto + ", fecha=" + fecha + ", precio=" + precio + ", activa="
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
		Oferta other = (Oferta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
