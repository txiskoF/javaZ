package net.zabalburu.productos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.zabalburu.productos.dao.CategoriaRepositorio;
import net.zabalburu.productos.dao.ProductoRepositorio;
import net.zabalburu.productos.modelo.Categoria;
import net.zabalburu.productos.modelo.Producto;

@Service
public class ProductosServicio {
	@Autowired
	private ProductoRepositorio productoDAO;
	
	@Autowired
	private CategoriaRepositorio categoriaDAO;
	
	public List<Producto> getProductos(){
		return productoDAO.findAll();
	}
	
	public Producto getProducto(Integer id) {
		return productoDAO.findById(id).orElse(null);
	}
	
	public Producto getProducto(String nombre) {
		return productoDAO.findByNombre(nombre).orElse(null);
	}
	
	public Producto guardarProducto(Producto p) {
		return productoDAO.save(p);
	}
	
	public void eliminarProducto(Integer id) {
		productoDAO.deleteById(id);
	}
	
	public List<Categoria> getCategorias(){
		return categoriaDAO.findAll(Sort.by("descripcion"));
	}
	
	public Categoria getCategoria(Integer id) {
		return categoriaDAO.findById(id).orElse(null);
	}
	
	public Categoria guardarCategoria(Categoria c) {
		return categoriaDAO.save(c);
	}
	
	public void eliminarCategoria(Integer id) {
		categoriaDAO.deleteById(id);
	}
	
}
