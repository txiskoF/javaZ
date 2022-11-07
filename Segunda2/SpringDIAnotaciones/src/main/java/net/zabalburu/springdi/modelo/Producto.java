package net.zabalburu.springdi.modelo;

public class Producto {
	private Integer id;
	private String nombre;
	private double precio;
	private Categoria categoria;
	
	public Producto() {
		System.out.println("En el constructor de producto");
	}

	public Producto(Integer id, String nombre, double precio) {
		super();
		System.out.println("En el constructor con argumentos de producto");
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto(Integer id, String nombre, double precio, Categoria categoria) {
		super();
		System.out.println("En el constructor con argumentos de producto");
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + "]";
	}

}
