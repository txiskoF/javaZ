package net.zabalburu.actividad10.servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import net.zabalburu.actividad10.modelo.Empleado;
import net.zabalburu.actividad10.modelo.Libro;

/**
 * Session Bean implementation class ServicioEJB
 */
@Stateful
@LocalBean
public class ServicioEJB {
	@PersistenceContext(unitName = "Actividad10")
	private EntityManager em;
	
	public Empleado getEmpleado(String id) {
		Empleado e = em.find(Empleado.class, id);
		Hibernate.initialize(e.getListaLectura());
		return e;
	}
	
	public Libro getLibro(String id) {
		return em.find(Libro.class, id);
	}
	
	public List<Empleado> getEmpleados(){
		Query q = em.createQuery("Select e From Empleado e Order by e.apellidos, e.nombre");
		return q.getResultList();
	}
	
	public List<Libro> getLibros(){
		Query q = em.createQuery("Select l From Libro l Order by l.titulo");
		return q.getResultList();
	}
	
	public void añadirLibroListLectura(String idEmpleado, String idLibro) {
		Empleado e = getEmpleado(idEmpleado);
		Libro l = getLibro(idLibro);
		e.getListaLectura().add(l);
	}
	
	public void quitarLibroListLectura(String idEmpleado, String idLibro) {
		Empleado e = getEmpleado(idEmpleado);
		Libro l = getLibro(idLibro);
		e.getListaLectura().remove(l);
	}
	
    /**
     * Default constructor. 
     */
    public ServicioEJB() {
        // TODO Auto-generated constructor stub
    }

}
