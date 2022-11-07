package net.zabalburu.reuniones.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reunionempleado")
public class ReunionEmpleado implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//2.2 Aqui creo reunion en la columna que se une a la parte One de Reunion
	@ManyToOne
	@JoinColumn(name="idreunion")
	private Reunion reunion;
	
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	// 3.2 Aqui creo empleado en la columna que se une a la parte One de Empleado
	@ManyToOne
	@JoinColumn(name="idempleado")
	private Empleado empleado;

	@Override
	public String toString() {
		return "ReunionEmpleado [id=" + id + ", reunion=" + reunion + "]";
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public ReunionEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}
}
