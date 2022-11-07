package net.zabalburu.actividad8.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	public enum Sexo { VARON, MUJER};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre;
	
	private String apellidos;
	
	private Sexo sexo;
	
	private String usuario;
	
	private String hash; // Hash de la contraseña
	
	private String salto;
	
	@OneToMany(mappedBy = "usuario")
	private List<UsuarioPista> canciones;
	
	public List<UsuarioPista> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<UsuarioPista> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo + ", usuario="
				+ usuario + ", hash=" + hash + ", salto=" + salto + "]";
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getSalto() {
		return salto;
	}

	public void setSalto(String salto) {
		this.salto = salto;
	}

	public Usuario() {
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getFoto() {
		if (this.sexo == Sexo.MUJER) {
			return "https://randomuser.me/api/portraits/women/"+id+".jpg"; 
		} else {
			return "https://randomuser.me/api/portraits/men/"+id+".jpg";
		}
	}
	
	
}
