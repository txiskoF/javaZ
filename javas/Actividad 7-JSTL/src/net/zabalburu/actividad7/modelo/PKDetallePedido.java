package net.zabalburu.actividad7.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PKDetallePedido implements Serializable{

	private static final long serialVersionUID = 1L;

	//debe de tener  los dos campos que forman la clave primaria
	//en este caso de orderDetails
	@Column(name="ProductID",insertable = false, updatable = false)
	private Integer idProducto;
	
	@Column(name="OrderID",insertable = false, updatable = false)
	private Integer idPedido;
	
	public PKDetallePedido() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		result = prime * result + ((idProducto == null) ? 0 : idProducto.hashCode());
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
		PKDetallePedido other = (PKDetallePedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PKDetallePedido [idProducto=" + idProducto + ", idPedido=" + idPedido + "]";
	}
	
	
	

}
