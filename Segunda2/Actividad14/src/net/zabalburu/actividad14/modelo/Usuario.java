package net.zabalburu.actividad14.modelo;

import javax.validation.constraints.NotEmpty;

public class Usuario {
	@NotEmpty(message = "Debe especificarse el usuario")
	private String usuario;
	@NotEmpty(message = "El password no puede estar vacío")
	private String password;
	private boolean administrador;
	private Integer id;
	public Usuario(String usuario, String password, boolean administrador, Integer id) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.administrador = administrador;
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
