package net.zabalburu.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.zabalburu.jpa.modelo.Autor;

public class AutorDAO {
	
	private EntityManager em;
	
	public AutorDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AutoresYLibros");
		this.em = factory.createEntityManager();
	}

	public List<Autor> getAutores(){
		Query q = em.createQuery("Select a From Autor a Order By a.apellidos, a.nombre");
		return q.getResultList();
	};
	
	public Autor getAutor(String id) {
		/*Query q = em.createQuery("Select a From Autor where a.id = :id");
		q.setParameter("id", id);
		try {
			return (Autor) q.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}*/
		return em.find(Autor.class, id);
	}
}
