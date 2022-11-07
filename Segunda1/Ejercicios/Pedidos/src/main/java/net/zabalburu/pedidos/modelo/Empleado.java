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
@Table(name = "employees")
public class Empleado implements Serializable{
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", pedidos=" + pedidos + "]";
	}

	@Id
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "firstname")
	private String nombre;
	
	@Column(name = "lastname")
	private String apellidos;
	
	@OneToMany(mappedBy = "empleado")
	private List<Pedido> pedidos;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
