package net.zabalburu.productosrest.modelo.dao;

import java.util.List;

import net.zabalburu.productosrest.modelo.Categoria;
import net.zabalburu.productosrest.modelo.Producto;



public interface ProductoDAO {
	List<Producto> getProductos();
	Producto getProducto(Integer id);
	List<Categoria> getCategorias();
	Categoria getCategoria(Integer id);
	Producto nuevoProducto(Producto p);
	void eliminarProducto(Integer id);
}
