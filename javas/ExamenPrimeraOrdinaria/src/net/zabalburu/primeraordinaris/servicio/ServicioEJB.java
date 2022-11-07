package net.zabalburu.primeraordinaris.servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import net.zabalburu.primeraordinaris.modelo.Concepto;
import net.zabalburu.primeraordinaris.modelo.Operacion;
import net.zabalburu.primeraordinaris.modelo.Usuario;

/**
 * Session Bean implementation class ServicioEJB
 */
@Stateless
@LocalBean
public class ServicioEJB {
	@PersistenceContext(unitName = "ExamenPrimeraOrdinaria")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ServicioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public Usuario login(String usuario, String password) {
    	Usuario u = null;
    	Query q = em.createQuery("Select u From Usuario u "+
    			"where u.usuario=:usuario");
    	q.setParameter("usuario", usuario);
    	try {
    		u = (Usuario) q.getSingleResult();
    		if (!u.getPassword().equalsIgnoreCase(password)) {
    			u = null;
    		} else {
    			Hibernate.initialize(u.getOperaciones());
    		}
    	} catch (NoResultException ex ) {
    		u =  null;
    	}
    	return u;
    }

    public Usuario getUsuario(Integer id) {
    	Usuario u = em.find(Usuario.class, id);
    	Hibernate.initialize(u.getOperaciones());
    	return u;
    }
    
    public List<Concepto> getConceptos(String tipo){
    	Query q = em.createQuery("Select c From Concepto c " +
    			" where c.tipo=|tipo Order by c.descripcion");
    	q.setParameter("tipo", tipo);
    	return q.getResultList();
    }
    
    public List<Concepto> getConceptos(){
    	Query q = em.createQuery("Select c From Concepto c " +
    			" Order by c.tipo, c.descripcion");
    	return q.getResultList();
    }
    
    public Concepto getConcepto(Integer id) {
    	return em.find(Concepto.class, id);
    }
    
    public Operacion getOperacion(Integer id) {
    	return em.find(Operacion.class, id);
    }
    
    public Concepto nuevoConcepto(Concepto c) {
    	em.persist(c);
    	return c;
    }
    
    public void nuevaOperacion(Operacion o) {
    	em.persist(o);
    }
    
    public void eliminarOperacion(Integer idOperacion) {
    	em.remove(getOperacion(idOperacion));
    }

}
