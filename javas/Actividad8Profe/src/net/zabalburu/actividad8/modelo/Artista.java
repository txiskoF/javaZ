package net.zabalburu.actividad8.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Artist")
public class Artista implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ArtistId")
	private Integer id;
	
	@Column(name="Name")
	private String nombre;
	
	@OneToMany(mappedBy = "artista")
	private List<Album> albumes;
	
	public List<Album> getAlbumes() {
		return albumes;
	}


	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
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


	public Artista() {
		// TODO Auto-generated constructor stub
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
		Artista other = (Artista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + "]";
	}

}
