package net.zabalburu.clientenoticias.modelo;

import java.io.Serializable;




public class Tema implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	private String tema;
	public Tema() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tema(Integer id, String tema, Integer idNoticia) {
		super();
		this.id = id;
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
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
		Tema other = (Tema) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", tema=" + tema + "]";
	}
	
	
}
