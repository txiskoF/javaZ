package dao;

import java.util.List;

import modelo.Producto;

public interface ProductoDAO {
	void añadirProducto(Producto p);
	void eliminarProducto(Producto p);
	Producto getProducto(Integer id);
	List<Producto> getProductos();
	
}
