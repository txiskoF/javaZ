package net.zabalburu.avisos.modelo;

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

@Entity
@Table(name = "avisos")
public class Aviso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "idempleado")
	//@Column(name = "empid")
	private Empleado empleado;
	
	private Date fecha;
	
	private String mensaje;
	
	@OneToMany(mappedBy="aviso")
	private List<Respuesta> respuestas;

	public Aviso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Aviso(Integer id, Empleado empleado, Date fecha, String mensaje, List<Respuesta> respuestas) {
		super();
		this.id = id;
		this.empleado = empleado;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.respuestas = respuestas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
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
		Aviso other = (Aviso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aviso [id=" + id + ", Empleado=" + empleado + ", fecha=" + fecha + ", mensaje=" + mensaje
				+ ", respuestas=" + respuestas + "]";
	}
	
	
	

}
