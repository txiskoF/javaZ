package net.zabalburu.ejercicio1.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Debe especificarse el cliente")
	private String nombre;
	
	@NotEmpty(message = "La contraseña no puede estar vacía")
	private String password;
	
	@OneToMany(mappedBy = "cliente")
	private List<Operacion> operaciones;

	public Cliente() {
		super();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<Operacion> operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", password=" + password + ", operaciones=" + operaciones
				+ "]";
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public double getTotal() {
		double total = 0;
		for(Operacion o : operaciones) {
			if (o.getConcepto().getTipo().equalsIgnoreCase("I")) {
				total += o.getImporte();
			} else {
				total -= o.getImporte();
			}
		}
		return total;
	}
}
