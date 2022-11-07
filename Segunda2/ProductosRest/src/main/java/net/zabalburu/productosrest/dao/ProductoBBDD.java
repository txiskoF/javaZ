package net.zabalburu.productosrest.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.productosrest.modelo.Categoria;
import net.zabalburu.productosrest.modelo.Producto;

@Repository("productoBBDD")
@Transactional
public class ProductoBBDD implements ProductoDAO {
	@Autowired
	private EntityManager em;

	public ProductoBBDD() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Producto> getProductos() {
		Query q = em.createQuery("Select p From Producto p");
		return q.getResultList();
	}

	@Override
	public Producto getProducto(Integer id) {
		return em.find(Producto.class, id);
	}

	@Override
	public List<Categoria> getCategorias() {
		Query q = em.createQuery("Select c From Categoria c");
		return q.getResultList();
	}

	@Override
	public Categoria getCategoria(Integer id) {
		return em.find(Categoria.class, id);
	}

	@Override
	public Producto nuevoProducto(Producto p) {
		em.persist(p);
		System.out.println(p);
		return p;
	}

	@Override
	public void eliminarProducto(Integer id) {
		em.remove(getProducto(id));
	}

}
