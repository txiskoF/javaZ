package net.zabalburu.actividad7.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.zabalburu.actividad7.modelo.Cliente;

public class ClientesDAO {
	private EntityManager em;
	
	public ClientesDAO() {
		this.em = Persistence.createEntityManagerFactory("Actividad 7")
				.createEntityManager();
	}

	public List<Cliente> getClientes() {
		Query q = em.createQuery("Select c From Cliente c Order By c.empresa");
		return q.getResultList();
	}
	
	public Cliente getCliente(String id) {
		return em.find(Cliente.class, id);
	}
	
}
