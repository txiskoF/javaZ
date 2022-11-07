package net.zabalburu.pedidos.dao;

import java.util.List;

import net.zabalburu.pedidos.modelo.Empleado;

public interface PedidosDAO {
	List<Empleado> getEmpleados();
	Empleado getEmpleado(Integer id);
}
