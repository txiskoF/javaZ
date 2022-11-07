package net.zabalburu.reuniones.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Reunion implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String nombre;
	
	//Para darle el formato deseado
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@FutureOrPresent
	private Date fecha;
	
	@NotEmpty
	private String hora;
	
	@Min(value = 1)
	private Integer duracion;
	
	@NotEmpty
	private String lugar;
	
	//1.2 - Aqui creo empleado en la columna que se une a la parte One de Empleado
	@ManyToOne
	@JoinColumn(name="convoca")
	private Empleado empleado;
	
	
	// 2.1 - -Campo por el que se mapea en la clase ReunionEmpleado y que hay que crear alli "reunion"
	@OneToMany(mappedBy = "reunion")
	private List<ReunionEmpleado> participantes;
	
	@Override
	public String toString() {
		return "Reunion [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", hora=" + hora + ", duracion="
				+ duracion + ", lugar=" + lugar + ", observaciones=" + observaciones + "]";
	}

	public List<ReunionEmpleado> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<ReunionEmpleado> participantes) {
		this.participantes = participantes;
	}

	private String observaciones;

	public Reunion() {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
