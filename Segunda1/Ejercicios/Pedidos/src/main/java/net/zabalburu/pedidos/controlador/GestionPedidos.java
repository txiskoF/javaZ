package net.zabalburu.pedidos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.zabalburu.pedidos.modelo.Empleado;
import net.zabalburu.pedidos.servicio.PedidosServicio;

@Controller
public class GestionPedidos {
	
	@Autowired
	private PedidosServicio servicio;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("empleados", servicio.getEmpleados());
		return "index";
	}
	
	@RequestMapping("/pedidos")
	public String pedidos(Model m, @RequestParam Integer id) {
		Empleado e = servicio.getEmpleado(id);
		m.addAttribute("empleado",e);
		return "pedidos";
	}
}
