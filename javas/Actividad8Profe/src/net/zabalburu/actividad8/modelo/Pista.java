package net.zabalburu.actividad8.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Track")
public class Pista implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="TrackId")
	private Integer id;
	
	
	@Column(name="Name")
	private String nombre;
	
	@Column(name="Milliseconds")
	private Integer duracion;
	
	@Column(name="Bytes")
	private Integer bytes;
	
	@Column(name="UnitPrice")
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name="GenreId")
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name="AlbumId")
	private Album album;
	
	@OneToMany(mappedBy = "pista")
	private List<UsuarioPista> usuarios;
	
	public List<UsuarioPista> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioPista> usuarios) {
		this.usuarios = usuarios;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Pista() {
		// TODO Auto-generated constructor stub
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

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getBytes() {
		return bytes;
	}

	public void setBytes(Integer bytes) {
		this.bytes = bytes;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDuracionTexto() {
		int minutos = this.duracion / 60000;
		int segundos = (minutos % 60000) * 6;
		return minutos + ":" + segundos;
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
		Pista other = (Pista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pista [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", bytes=" + bytes + ", precio="
				+ precio + ", genero=" + genero + ", album=" + album + "]";
	}

}
