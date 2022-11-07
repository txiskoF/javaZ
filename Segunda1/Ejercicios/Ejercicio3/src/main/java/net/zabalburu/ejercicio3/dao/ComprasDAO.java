package net.zabalburu.ejercicio3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.ejercicio3.modelo.Compra;
import net.zabalburu.ejercicio3.modelo.Editorial;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.modelo.Usuario;

@Repository
@Transactional
public class ComprasDAO {
	@Autowired
	private EntityManager em;
	
	public List<Editorial> getEditoriales() {
		Query q = em.createQuery("Select e From Editorial e");
		return q.getResultList();
	}
	
	public Editorial getEditorial(String id) {
		return em.find(Editorial.class, id);
	}
	
	//Para realizar una busqueda por el texto introducido
	public List<Libro> buscarLibros(String busqueda) {
		Query q = em.createQuery("Select l From Libro l where l.titulo like '%" + busqueda + "%'");
		return q.getResultList();
	}
	
	public Libro getLibro(String id) {
		return em.find(Libro.class, id);
	}
	
	public Usuario getUsuario(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public Compra getCompra(Integer id) {
		return em.find(Compra.class, id);
	}
	
	//Añadir una nueva compra
	public Compra nuevaCompra(Compra c) {
		return em.merge(c);
	}
	
	public Compra modificarCompra(Compra c) {
		System.out.println(c);
		if (getCompra(c.getId())!=null) {
			return em.merge(c);
		} else  {
			return null;
		}
	}
	
	public void eliminarCompra(Integer id) {
		Compra c =getCompra(id); 
		if (c!=null) {
			em.remove(c);
		}
	}
	
}
