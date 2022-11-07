package net.zabalburu.reuniones.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.reuniones.modelo.Empleado;
import net.zabalburu.reuniones.modelo.Reunion;

@Repository
@Transactional
public class ReunionesPubs implements ReunionesDAO {
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Empleado> getEmpleados() {
		Query q = em.createQuery("Select e From Empleado e Order by e.apellidos, e.nombre");
		return q.getResultList();
	}

	@Override
	public Empleado getEmpleado(String id) {
		return em.find(Empleado.class,id);
	}

	@Override
	public void nuevaReunion(Reunion r) {
		r.getEmpleado().getReunionesConvocadas().add(r);
		em.persist(r);
	}

}
