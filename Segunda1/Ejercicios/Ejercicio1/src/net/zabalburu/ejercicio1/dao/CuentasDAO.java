package net.zabalburu.ejercicio1.dao;


import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import net.zabalburu.ejercicio1.modelo.Cliente;
import net.zabalburu.ejercicio1.modelo.Concepto;
import net.zabalburu.ejercicio1.modelo.Operacion;

@Repository
@Transactional
public class CuentasDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Cliente getCliente(String nombre) {
		Query q = sessionFactory.getCurrentSession()
			.createQuery("Select c From Cliente c Where c.nombre = :nombre");
		q.setParameter("nombre", nombre);
		Cliente c = null;
		try {
			c = (Cliente) q.getSingleResult();
			Hibernate.initialize(c.getOperaciones());
		} catch (NoResultException ex) {}
		return c;
	}
	
	public List<Concepto> getConceptos(String tipo){
		Query q = sessionFactory.getCurrentSession()
				.createQuery("Select c From Concepto c Where c.tipo = :tipo");
		q.setParameter("tipo", tipo);
		return q.getResultList();
	}
	
	public List<Concepto> getConceptos(){
		Query q = sessionFactory.getCurrentSession()
				.createQuery("Select c From Concepto c Order By c.tipo, c.descripcion");
		return q.getResultList();
	}
	
	public Concepto getConcepto(Integer id) {
		Concepto c = sessionFactory.getCurrentSession()
				.get(Concepto.class, id);
		if (c != null) {
			Hibernate.initialize(c.getOperaciones());
		}
		return c;
	}

	public void nuevoConcepto(Concepto c) {
		sessionFactory.getCurrentSession().save(c);
	}
	
	public Operacion getOperacion(Integer id) {
		Operacion o = sessionFactory.getCurrentSession()
				.get(Operacion.class, id);
		return o;
	}
	
	public void nuevaOperacion(Operacion o) {
		sessionFactory.getCurrentSession().save(o);
		o.getConcepto().getOperaciones().add(o);
		o.getCliente().getOperaciones().add(o);
	}
	
	public void eliminarOperacion(Operacion o) {
		o.getConcepto().getOperaciones().remove(o);
		o.getCliente().getOperaciones().remove(o);
		sessionFactory.getCurrentSession().remove(o);
	}
	
	public void eliminarOperacion(Integer id) {
		eliminarOperacion(getOperacion(id));
	}
	
}
