package net.zabalburu.productosmvc.modelo;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Producto {
	private Integer id;
	
	@NotEmpty(message = "El nombre no puede estar vacío")
	@Size(min=3, max=30, message = "El nombre debe tener entre 3 y 20 posiciones")
	private String nombre;
	
	@Positive(message = "El precio debe ser MAYOR QUE 0")
	@NumberFormat(style = Style.NUMBER)
	private double precio;
	
	private Categoria categoria;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "La fecha de compra no puede ser posterior a hoy")
	private Date fechaCompra;
	
	public Date getFechaCompra() {
		return fechaCompra;
	}

	public Producto(Integer id,
			@NotEmpty(message = "El nombre no puede estar vacío") @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 20 posiciones") String nombre,
			@Positive(message = "El precio debe ser MAYOR QUE 0") double precio, Categoria categoria,
			@PastOrPresent Date fechaCompra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.fechaCompra = fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

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
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria
				+ ", fechaCompra=" + fechaCompra + "]";
	}

}
