package net.zabalburu.ejercicio3.cliente.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.zabalburu.ejercicio3.cliente.modelo.Compra;
import net.zabalburu.ejercicio3.cliente.modelo.Editorial;
import net.zabalburu.ejercicio3.cliente.modelo.Libro;

public interface ComprasDAO {
	List<Editorial> getEditoriales();
	List<Libro> getLibrosEditorial(String id);
	List<Libro> buscarLibros(String busqueda);
	Libro getLibro(String id); //AL REST
	Compra nuevaCompra(Compra c, Integer idUsuario);
	List<Compra> getCompras(Integer idUsuario);
}
