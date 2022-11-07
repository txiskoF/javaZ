package net.zabalburu.ejercicio3.servicio;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.ejercicio3.dao.ComprasDAO;
import net.zabalburu.ejercicio3.modelo.Compra;
import net.zabalburu.ejercicio3.modelo.Editorial;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.modelo.Usuario;

@Service
public class ComprasServicio {
	@Autowired
	private ComprasDAO dao;
	
	public List<Editorial> getEditoriales() {
		return dao.getEditoriales();
	}
	
	public Editorial getEditorial(String id) {
		return dao.getEditorial(id);
	}
	
	public List<Libro> buscarLibros(String busqueda) {
		return dao.buscarLibros(busqueda);
	}
	
	public Libro getLibro(String id) {
		return dao.getLibro(id);
	}
	
	public Usuario getUsuario(Integer id) {
		return dao.getUsuario(id);
	}
	
	public Compra getCompra(Integer id) {
		return dao.getCompra(id);
	}
	
	public Compra nuevaCompra(Compra c) {
		return dao.nuevaCompra(c);
	}
	
	public Compra modificarCompra(Compra c) {
		return dao.modificarCompra(c);
	}
	
	public void eliminarCompra(Integer id) {
		dao.eliminarCompra(id);
	}
}
