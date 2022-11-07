package net.zabalburu.pedidos.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.zabalburu.pedidos.modelo.Empleado;

@Repository
public class PedidosBBDD implements PedidosDAO {
	@Autowired
	private EntityManager em;
	
	@Override
	public List<Empleado> getEmpleados() {
		Query q = em.createQuery("Select e From Empleado e Order By e.apellidos, e.nombre");
		return q.getResultList();
	}

	@Override
	public Empleado getEmpleado(Integer id) {
		return em.find(Empleado.class, id);
	}

}
