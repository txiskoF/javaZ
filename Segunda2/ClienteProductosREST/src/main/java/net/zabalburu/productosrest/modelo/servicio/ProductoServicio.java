package net.zabalburu.productosrest.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.zabalburu.productosrest.modelo.Categoria;
import net.zabalburu.productosrest.modelo.Producto;
import net.zabalburu.productosrest.modelo.dao.ProductoDAO;


@Service
public class ProductoServicio{
	@Autowired
	private ProductoDAO dao;
	
	public ProductoServicio() {
		
	}

	public ProductoServicio(ProductoDAO dao) {
		super();
		this.dao = dao;
	}

	public ProductoDAO getDao() {
		return dao;
	}

	public void setDao(ProductoDAO dao) {
		this.dao = dao;
	}

	public List<Producto> getProductos() {
		return this.dao.getProductos();
	}

	public Producto getProducto(Integer id) {
		// TODO Auto-generated method stub
		return dao.getProducto(id);
	}

	public List<Categoria> getCategorias() {
		// TODO Auto-generated method stub
		return dao.getCategorias();
	}

	public Categoria getCategoria(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCategoria(id);
	}

	public Producto nuevoProducto(Producto p) {
		// TODO Auto-generated method stub
		return dao.nuevoProducto(p);
	}

	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		dao.eliminarProducto(id);
	}

}
