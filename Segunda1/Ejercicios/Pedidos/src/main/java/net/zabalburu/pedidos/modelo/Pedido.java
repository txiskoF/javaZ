package net.zabalburu.pedidos.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Pedido implements Serializable{
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaPedido=" + fechaPedido + ", fechaEnvio=" + fechaEnvio + ", cliente=" + cliente + ", detalles=" + detalles + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private Integer id;
	
	@Column(name="orderdate")
	private Date fechaPedido;
	
	@Column(name="shippeddate")
	private Date fechaEnvio;

	@ManyToOne
	@JoinColumn(name = "employeeid")
	private Empleado empleado;
	
	@ManyToOne
	@JoinColumn(name = "customerid")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private List<DetallePedido> detalles;
	
	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	public double getImporte() {
		double importe = 0;
		for(DetallePedido d : detalles) {
			importe += d.getImporte();
		}
		return importe;
	}
	
}
