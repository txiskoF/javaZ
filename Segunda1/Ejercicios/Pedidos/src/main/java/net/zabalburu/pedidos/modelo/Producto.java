package net.zabalburu.pedidos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Producto implements Serializable{
	@Id
	@Column(name = "productid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="productname")
	private String nombre;
	
	@Column(name="unitprice")
	private String precio;

	@OneToMany(mappedBy = "producto")
	private List<DetallePedido> detalles;
	
	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
