package net.zabalburu.pedidos.modelo;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"order details\"")
public class DetallePedido {
	
	@EmbeddedId
	private DetallePedidoPK id;
	
	public DetallePedidoPK getId() {
		return id;
	}

	public void setId(DetallePedidoPK id) {
		this.id = id;
	}

	@Column(name="quantity")
	private Integer unidades;
	
	@Column(name="unitprice")
	private Double precio;
	
	@Column(name="discount")
	private Double descuento;

	@ManyToOne
	@JoinColumn(name="orderid",insertable = false, updatable = false)
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="productid",insertable = false, updatable = false)
	private Producto producto;
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public DetallePedido() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public double getImporte() {
		return this.unidades * this.precio * (1 - this.descuento);
	}
}
