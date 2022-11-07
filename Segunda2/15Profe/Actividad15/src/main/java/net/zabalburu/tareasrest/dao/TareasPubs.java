package net.zabalburu.tareasrest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.tareasrest.modelo.Tarea;
import net.zabalburu.tareasrest.modelo.Usuario;

@Repository("tareaspubs")
@Transactional
public class TareasPubs implements TareasDAO {

	@Autowired
	private EntityManager em;
	
	public TareasPubs() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Usuario> getUsuarios() {
		Query q = em.createQuery("Select u From Usuario u");
		return q.getResultList();
	}

	@Override
	public Usuario getUsuario(Integer id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Tarea> getPendientes(Integer id) {
		Usuario u = getUsuario(id);
		List<Tarea> pendientes = new ArrayList<Tarea>();
		for(Tarea t : u.getTareas()) {
			if (!t.isRealizada()) {
				pendientes.add(t);
			}
		}
		return pendientes;
	}

	@Override
	public Usuario getUsuario(String usuario) {
		Query q = em.createQuery("Select u From Usuario u where u.usuario=:usuario");
		Usuario u = null;
		try {
			q.setParameter("usuario", usuario);
			u = (Usuario) q.getSingleResult();
		} catch  (NoResultException ex) {
			
		}
		return u;
	}

	@Override
	public Tarea nuevaTarea(Integer id, Tarea t) {
		t.setUsuario(getUsuario(id));
		em.persist(t);
		return t;
	}

	@Override
	public Tarea getTarea(Integer id) {
		return em.find(Tarea.class, id);
	}

	@Override
	public void eliminarTarea(Integer id) {
		em.remove(getTarea(id));
	}

	@Override
	public void modificarTarea(Tarea t) {
		em.merge(t);
	}

}
