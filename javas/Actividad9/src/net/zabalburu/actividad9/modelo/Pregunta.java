package net.zabalburu.actividad9.modelo;

import java.util.Date;
import java.util.List;

public class Pregunta {
	
    private Integer id;
    private Usuario usuario;
    private Date fecha;
    private String texto;
    private Integer respuestaA;

	

	public Pregunta(Integer id, Usuario usuario, Date fecha, String texto, Integer respuestaA) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.texto = texto;
		this.respuestaA = respuestaA;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getRespuestaA() {
		return respuestaA;
	}

	public void setRespuestaA(Integer respuestaA) {
		this.respuestaA = respuestaA;
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
		Pregunta other = (Pregunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", texto=" + texto + ", respuestaA="
				+ respuestaA + "]";
	}
	
	

}
