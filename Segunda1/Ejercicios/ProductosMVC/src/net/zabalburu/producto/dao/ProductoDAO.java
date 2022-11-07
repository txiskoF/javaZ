package net.zabalburu.producto.dao;
import java.util.List;

import net.zabalburu.producto.modelo.*;
public interface ProductoDAO {
	List<Producto> getProductos();
	Producto getProducto(Integer id);
	void nuevoProducto(Producto p);
	void eliminarProducto(Producto p);
	void eliminarProducto(Integer id);
	List<Categoria> getCategorias();
	Categoria getCategoria(Integer id);
}
