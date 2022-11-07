package dao;

import java.util.List;

import modelo.Producto;

public interface ProductoDAO {
	void a�adirProducto(Producto p);
	void eliminarProducto(Producto p);
	Producto getProducto(Integer id);
	List<Producto> getProductos();
	
}
