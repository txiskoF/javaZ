package net.zabalburu.clientenoticias.modelo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	
	private Integer idTema;
	
	private Integer subidoPor;
	
	private String noticia;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	private String url;
	
	private String comentarios;

	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Noticia(Integer id, Integer idTema, Integer subidoPor, String noticia, Date fecha, String url,
			String comentarios) {
		super();
		this.id = id;
		this.idTema = idTema;
		this.subidoPor = subidoPor;
		this.noticia = noticia;
		this.fecha = fecha;
		this.url = url;
		this.comentarios = comentarios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTema() {
		return idTema;
	}

	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}

	public Integer getSubidoPor() {
		return subidoPor;
	}

	public void setSubidoPor(Integer subidoPor) {
		this.subidoPor = subidoPor;
	}

	public String getNoticia() {
		return noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
		Noticia other = (Noticia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", idTema=" + idTema + ", subidoPor=" + subidoPor + ", noticia=" + noticia
				+ ", fecha=" + fecha + ", url=" + url + ", comentarios=" + comentarios + "]";
	}
	
	
	
}
