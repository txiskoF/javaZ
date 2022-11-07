package net.zabalburu.ejercicio3.cliente.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.ejercicio3.cliente.dao.ComprasDAO;
import net.zabalburu.ejercicio3.cliente.modelo.Compra;
import net.zabalburu.ejercicio3.cliente.modelo.Editorial;
import net.zabalburu.ejercicio3.cliente.modelo.Libro;

@Service
public class ComprasServicio {
	@Autowired
	private ComprasDAO dao;
	
	//mtodo para recuperar las editoriales
	public List<Editorial> getEditoriales(){
		return dao.getEditoriales();
	}
	
	public List<Libro> getLibrosEditorial(String id) {
		return dao.getLibrosEditorial(id);
	}
	
	public List<Libro> buscarLibros(String busqueda) {
		return dao.buscarLibros(busqueda);
	}

	//VENIR DEL REST
	public Libro getLibro(String id) {
		return dao.getLibro(id);
	}
	
	public Compra nuevaCompra(Compra c, Integer idUsuario) {
		return dao.nuevaCompra(c, idUsuario);
	}
	
	public List<Compra> getCompras(Integer idUsuario){
		return dao.getCompras(idUsuario);
	}
}
