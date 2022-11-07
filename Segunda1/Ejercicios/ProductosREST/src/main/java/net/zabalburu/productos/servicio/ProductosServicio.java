package net.zabalburu.productos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.productos.dao.ProductosDAO;
import net.zabalburu.productos.modelo.Categoria;
import net.zabalburu.productos.modelo.Producto;

@Service
public class ProductosServicio {
	@Autowired
	private ProductosDAO dao;
	
	public List<Producto> getProductos(){
		return dao.getProductos();
	}
	
	public Producto getProducto(Integer id) {
		return dao.getProducto(id);
	}
	
	public List<Categoria> getCategorias(){
		return dao.getCategorias();
	}
	
	public Categoria getCategoria(Integer id) {
		return dao.getCategoria(id);
	}
	
	public Producto nuevoProducto(Producto p) {
		return dao.nuevoProducto(p);
	}
	
	public Producto modificarProducto(Producto p) {
		return dao.modificarProducto(p);
	}
	
	public Producto eliminarProducto(Integer id) {
		return dao.eliminarProducto(id);
	}
	
	public Categoria nuevoCategoria(Categoria c) {
		return dao.nuevoCategoria(c);
	}
	
	public Categoria modificarCategoria(Categoria c) {
		return dao.modificarCategoria(c);
	}
	
	public Categoria eliminarCategoria(Integer id) {
		return dao.eliminarCategoria(id);
	}
}
