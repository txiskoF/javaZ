package net.zabalburu.actividad10.servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.zabalburu.actividad10.modelo.Empleado;
import net.zabalburu.actividad10.modelo.Libro;

/**
 * Session Bean implementation class RecomendacionEmpresaEJB
 */
@Singleton
@LocalBean
public class RecomendacionEmpresaEJB {
	@PersistenceContext(name = "Actividad10")
	private EntityManager em;
	
	public List<Libro> getRecomendados(){
		Query q = em.createQuery("Select distinct e.recomendaciones From Empleado e");
		return q.getResultList();
	}
	
	public void añadirRecomendado(String idEmpleado, String idLibro) {
		Empleado e = em.find(Empleado.class, idEmpleado);
		Libro l = em.find(Libro.class, idLibro);
		e.getRecomendaciones().add(l);
	}
	
    /**
     * Default constructor. 
     */
    public RecomendacionEmpresaEJB() {
        // TODO Auto-generated constructor stub
    }

}
