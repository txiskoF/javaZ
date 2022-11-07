package net.zabalburu.actividad8.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.zabalburu.actividad8.modelo.Artista;

public class ArtistaDAO {
	private EntityManager em;
	public ArtistaDAO() {
		this.em = Persistence.createEntityManagerFactory("Actividad8")
				.createEntityManager();
	}
	
	public List<Artista> getArtistas(){
		Query q = em.createQuery("Select a From Artista a Order By a.nombre");
		return q.getResultList();
	}

	public Artista getArtista(Integer id) {
		return em.find(Artista.class, id);
	}
	
	public List<String> getInicialesArtistas(){
		Query q = em.createQuery("Select distinct substring(a.nombre,1,1) From Artista a");
		return q.getResultList();
	}
	
	public List<Artista> getArtistas(String inicial){
		Query q = em.createQuery("Select a From Artista a where substring(a.nombre,1,1)=:inicial Order By a.nombre");
		q.setParameter("inicial", inicial);
		return q.getResultList();
	}
	
	public static void main(String[] args) {
		ArtistaDAO dao = new ArtistaDAO();
		System.out.println(dao.getArtistas("A"));
	}
}
