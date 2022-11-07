package net.zabalburu.mcdonalds.modelo;

public class Producto {
	private String categoria;
	private String producto;
	private double calorias;
	private double grasaSaturada;
	private double porcDiaGrasaSaturada;
	private double colesterol;
	private double porcDiaColesterol;
	
	public Producto(String categoria, String producto, double calorias, double grasaSaturada,
			double porcDiaGrasaSaturada, double colesterol, double porcDiaColesterol) {
		super();
		this.categoria = categoria;
		this.producto = producto;
		this.calorias = calorias;
		this.grasaSaturada = grasaSaturada;
		this.porcDiaGrasaSaturada = porcDiaGrasaSaturada;
		this.colesterol = colesterol;
		this.porcDiaColesterol = porcDiaColesterol;
	}

	public Producto() {
		super();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getGrasaSaturada() {
		return grasaSaturada;
	}

	public void setGrasaSaturada(double grasaSaturada) {
		this.grasaSaturada = grasaSaturada;
	}

	public double getPorcDiaGrasaSaturada() {
		return porcDiaGrasaSaturada;
	}

	public void setPorcDiaGrasaSaturada(double porcDiaGrasaSaturada) {
		this.porcDiaGrasaSaturada = porcDiaGrasaSaturada;
	}

	public double getColesterol() {
		return colesterol;
	}

	public void setColesterol(double colesterol) {
		this.colesterol = colesterol;
	}

	public double getPorcDiaColesterol() {
		return porcDiaColesterol;
	}

	public void setPorcDiaColesterol(double porcDiaColesterol) {
		this.porcDiaColesterol = porcDiaColesterol;
	}
	
	
	
}
