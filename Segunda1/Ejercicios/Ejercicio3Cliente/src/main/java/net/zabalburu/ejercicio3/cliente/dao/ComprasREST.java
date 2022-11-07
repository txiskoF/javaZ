package net.zabalburu.ejercicio3.cliente.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.ejercicio3.cliente.modelo.Compra;
import net.zabalburu.ejercicio3.cliente.modelo.Editorial;
import net.zabalburu.ejercicio3.cliente.modelo.Libro;

@Repository
public class ComprasREST implements ComprasDAO{

	@Autowired
	private RestTemplate template;
	
	@Override
	public List<Editorial> getEditoriales() {
		return template.getForObject("http://localhost:8082/editoriales", List.class);
	}

	@Override
	public List<Libro> getLibrosEditorial(String id) {
		System.out.println("ID: " + id);			//ES EL GETMAPPING QUE HAY EN GESTIONCOMPRASDE EJERCICIO3
		return template.getForObject("http://localhost:8082/libros/editorial/"+id, List.class);
	}

	@Override
	public List<Libro> buscarLibros(String busqueda) {
		return template.getForObject("http://localhost:8082/libros/buscar/"+busqueda, List.class);
	}
	
	//DESPUES DEL dao E IR AL SERVICIO
	@Override
	public Libro getLibro(String id) {
		return template.getForObject("http://localhost:8082/libros/"+id, Libro.class);
	}

	@Override
	public Compra nuevaCompra(Compra c, Integer idUsuario) {
		return template.postForObject("http://localhost:8082/compras/"+idUsuario, c, Compra.class);
	}

	@Override
	public List<Compra> getCompras(Integer idUsuario) {
		return template.getForObject("http://localhost:8082/compras/"+idUsuario, List.class);
	}
}
