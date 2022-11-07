package net.zabalburu.reuniones.modelo;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;



@Entity
@Table(name="employee")
public class Empleado implements Serializable{
	//Renombrar las columnas NombreenColumna-Asignado
	@Column(name = "emp_id")
	@Id
	private String id;
	
	@Column(name="lname")
	private String apellidos;
	
	@Column(name="fname")
	private String nombre;
	
	// 1.1 -Campo por el que se mapea en la clase Reunion y que hay que crear alli "empleado"
	@OneToMany(mappedBy = "empleado")
	private List<Reunion> reunionesConvocadas;
	
	// 3.1 -Campo por el que se mapea en la clase ReunionEmpleado y que hay que crear alli "empleado"
	@OneToMany(mappedBy = "empleado")
	private List<ReunionEmpleado> reunionesParticipa;

	

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", apellidos=" + apellidos + ", nombre=" + nombre + ", reunionesConvocadas="
				+ reunionesConvocadas + ", reunionesParticipa=" + reunionesParticipa + "]";
	}

	public List<ReunionEmpleado> getReunionesParticipa() {
		return reunionesParticipa;
	}

	public void setReunionesParticipa(List<ReunionEmpleado> reunionesParticipa) {
		this.reunionesParticipa = reunionesParticipa;
	}

	public List<Reunion> getReunionesConvocadas() {
		return reunionesConvocadas;
	}

	public void setReunionesConvocadas(List<Reunion> reunionesConvocadas) {
		this.reunionesConvocadas = reunionesConvocadas;
	}

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
