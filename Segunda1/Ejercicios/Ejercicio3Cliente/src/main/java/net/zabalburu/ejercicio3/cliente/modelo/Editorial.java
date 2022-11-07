package net.zabalburu.ejercicio3.cliente.modelo;

public class Editorial {
	private String id;
	
	private String nombre;
	
	private String ciudad;
	
	private String estado;
	
	private String pais;

	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Se elimia el list de libros todo lo que es 1:M
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", estado=" + estado + ", pais="
				+ pais + "]";
	}
	
}
