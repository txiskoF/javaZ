package net.zabalburu.springdi.servicio;

import java.util.List;

import net.zabalburu.springdi.dao.ProductoDAO;
import net.zabalburu.springdi.modelo.Categoria;
import net.zabalburu.springdi.modelo.Producto;

public class ProductoServicio{
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

	public void nuevoProducto(Producto p) {
		// TODO Auto-generated method stub
		dao.nuevoProducto(p);
	}

	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		dao.eliminarProducto(id);
	}

}
