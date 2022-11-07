package dao;

import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoList implements ProductoDAO {
	private List<Producto> productos = new ArrayList<>();
	
	@Override
	public void añadirProducto(Producto p) {
		this.productos.add(p);

	}

	@Override
	public void eliminarProducto(Producto p) {
		this.productos.remove(p);

	}

	@Override
	public Producto getProducto(Integer prodNo) {
		Producto p = new Producto();
		p.setProdNo(prodNo);
		return this.productos.get(this.productos.indexOf(p));
	}

	@Override
	public List<Producto> getProductos() {
		return this.productos;
	}

}
