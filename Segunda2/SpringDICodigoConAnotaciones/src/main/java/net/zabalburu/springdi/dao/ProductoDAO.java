package net.zabalburu.springdi.dao;

import java.util.List;

import net.zabalburu.springdi.modelo.Categoria;
import net.zabalburu.springdi.modelo.Producto;

public interface ProductoDAO {
	List<Producto> getProductos();
	Producto getProducto(Integer id);
	List<Categoria> getCategorias();
	Categoria getCategoria(Integer id);
	void nuevoProducto(Producto p);
	void eliminarProducto(Integer id);
}
