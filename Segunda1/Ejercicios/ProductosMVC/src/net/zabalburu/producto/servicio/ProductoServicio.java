package net.zabalburu.producto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.zabalburu.producto.dao.ProductoDAO;
import net.zabalburu.producto.modelo.*;

@Service
public class ProductoServicio {
	@Autowired
	@Qualifier("productoHibernate")
	private ProductoDAO productoDAO;
	
	public List<Producto> getProductos(){
		return productoDAO.getProductos();
	}
	
	public Producto getProducto(Integer id) {
		return productoDAO.getProducto(id);
	}
	
	public void nuevoProducto(Producto p) {
		productoDAO.nuevoProducto(p);
	}
	
	public void eliminarProducto(Integer id) {
		productoDAO.eliminarProducto(id);
	}
	
	public void eliminarProducto(Producto p) {
		productoDAO.eliminarProducto(p);
	}
	
	public List<Categoria> getCategorias(){
		return productoDAO.getCategorias();
	}
	
	public Categoria getCategoria(Integer id) {
		return productoDAO.getCategoria(id);
	}
	
}
