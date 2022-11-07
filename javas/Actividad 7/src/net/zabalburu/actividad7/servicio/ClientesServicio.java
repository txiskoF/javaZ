package net.zabalburu.actividad7.servicio;

import java.util.List;

import net.zabalburu.actividad7.dao.ClientesDAO;
import net.zabalburu.actividad7.modelo.Cliente;

public class ClientesServicio {
	private ClientesDAO dao = new ClientesDAO();
	public ClientesServicio() {
		// 
	}

	public List<Cliente> getClientes(){
		return dao.getClientes();
	}
	
	public Cliente getCliente(String id) {
		return dao.getCliente(id);
	}
	
}
