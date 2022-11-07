package net.zabalburu.producto.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.producto.modelo.Categoria;
import net.zabalburu.producto.modelo.Producto;

@Repository(value = "productoHibernate")
@Transactional
public class ProductoHibernate implements ProductoDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Producto> getProductos() {
		Query q = this.sessionFactory.getCurrentSession().createQuery(
			"Select p From Producto p");
		return q.getResultList();
	}

	@Override
	public Producto getProducto(Integer id) {
		return sessionFactory.getCurrentSession().find(Producto.class, id);
	}

	@Override
	public void nuevoProducto(Producto p) {
		p.getCategoria().getProductos().add(p);
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public void eliminarProducto(Producto p) {
		p.getCategoria().getProductos().remove(p);
		sessionFactory.getCurrentSession().remove(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		sessionFactory.getCurrentSession().remove(
			getProducto(id));
	}

	@Override
	public List<Categoria> getCategorias() {
		return sessionFactory.getCurrentSession()
			.createQuery("Select c From Categoria c")
			.getResultList();
	}

	@Override
	public Categoria getCategoria(Integer id) {
		Categoria c = sessionFactory.getCurrentSession()
			.get(Categoria.class, id);
		Hibernate.initialize(c.getProductos());
		return c;
	}

}
