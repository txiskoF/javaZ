package net.zabalburu.actividad8.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AlbumId")
	private Integer id;
	
	@Column(name="Title")
	private String titulo;

	@ManyToOne
	@JoinColumn(name="ArtistId")
	private Artista artista;
	
	@OneToMany(mappedBy = "album")
	private List<Pista> pistas;
	
	public List<Pista> getPistas() {
		return pistas;
	}

	public void setPistas(List<Pista> pistas) {
		this.pistas = pistas;
	}

	public Album() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
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
		Album other = (Album) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", titulo=" + titulo + ", artista=" + artista + "]";
	}
	
}
