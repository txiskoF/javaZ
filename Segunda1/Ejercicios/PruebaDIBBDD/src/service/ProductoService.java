package service;

import java.util.List;

import dao.ProductoDAO;
import modelo.Producto;

public class ProductoService {
	private ProductoDAO productoDAO;
	private String nombre;
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ProductoService() {
		super();
	}

	/*public ProductoService(ProductoDAO productoDAO) {
		super();
		this.productoDAO = productoDAO;
	}
	*/

	public ProductoDAO getProductoDAO() {
		return productoDAO;
	}

	public void setProductoDAO(ProductoDAO productoDAO) {
		this.productoDAO = productoDAO;
	}
	
	public void nuevoProducto(Producto p) {
		this.productoDAO.añadirProducto(p);
	}
	
	public void eliminarProdcuto(Producto p) {
		this.productoDAO.eliminarProducto(p);
	}
	
	public Producto getProducto(Integer prodNo) {
		return this.productoDAO.getProducto(prodNo);
	}
	
	public List<Producto> getProductos(){
		return this.productoDAO.getProductos();
	}
	
}
