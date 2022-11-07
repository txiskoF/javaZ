package net.zabalburu.pedidos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.pedidos.dao.PedidosDAO;
import net.zabalburu.pedidos.modelo.Empleado;

@Service
public class PedidosServicio {
	
	@Autowired
	private PedidosDAO dao;
	
	public List<Empleado> getEmpleados() {
		return dao.getEmpleados();
	}

	public Empleado getEmpleado(Integer id) {
		return dao.getEmpleado(id);
	}

}
