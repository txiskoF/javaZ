package net.zabalburu.actividad7.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//asi porque hay espacio en blanco
@Table(name = "\"Order Details\"")
public class DetallePedido implements Serializable{

	//esto para meter la tabla que hemos crado antes
	@EmbeddedId
	private PKDetallePedido id;
	
	@ManyToOne
	//al formar parte de una claveEmebida obliga a insertable y updatable
	@JoinColumn(name="OrderID", insertable = false, updatable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="ProductID", insertable = false, updatable = false)
	private Producto producto;
	
	@Override
	public String toString() {
		return "DetallePedido [id=" + id + ", pedido=" + pedido + ", producto=" + producto + ", unidades=" + unidades
				+ ", precio=" + precio + ", descuento=" + descuento + "]";
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
		DetallePedido other = (DetallePedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "Quantity")
	private Integer unidades;
	
	@Column(name = "UnitPrice")
	private Double precio;
	
	@Column(name = "Discount")
	private Double descuento;
	
	public PKDetallePedido getId() {
		return id;
	}

	public void setId(PKDetallePedido id) {
		this.id = id;
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

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public DetallePedido() {
		// TODO Auto-generated constructor stub
	}

}
