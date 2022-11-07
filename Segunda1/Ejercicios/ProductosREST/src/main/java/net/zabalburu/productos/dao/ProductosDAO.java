package net.zabalburu.productos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.productos.modelo.Categoria;
import net.zabalburu.productos.modelo.Producto;

@Repository
@Transactional
public class ProductosDAO {
	@Autowired
	private EntityManager em;
	
	public List<Producto> getProductos(){
		Query q = em.createQuery("Select p From Producto p");
		return q.getResultList();
	}
	
	public Producto getProducto(Integer id) {
		return em.find(Producto.class, id);
	}
	
	public List<Categoria> getCategorias(){
		Query q = em.createQuery("Select p From Categoria p");
		return q.getResultList();
	}
	
	public Categoria getCategoria(Integer id) {
		return em.find(Categoria.class, id);
	}
	
	public Producto nuevoProducto(Producto p) {
		return em.merge(p);
	}
	
	public Producto modificarProducto(Producto p) {
		if (getProducto(p.getId()) != null) {
			return em.merge(p);
		} else {
			return null;
		}
	}
	
	public Producto eliminarProducto(Integer id) {
		Producto p = getProducto(id); 
		if ( p != null) {
			em.remove(p);
			return p;
		} else {
			return null;
		}
	}

	public Categoria nuevoCategoria(Categoria c) {
		return em.merge(c);
	}
	
	public Categoria modificarCategoria(Categoria c) {
		if (getCategoria(c.getId()) != null) {
			return em.merge(c);
		} else {
			return null;
		}
	}
	
	public Categoria eliminarCategoria(Integer id) {
		Categoria c = getCategoria(id); 
		if ( c != null) {
			em.remove(c);
			return c;
		} else {
			return null;
		}
	}
	
}
