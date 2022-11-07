package net.zabalburu.avisoscliente.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.avisoscliente.modelo.Aviso;
import net.zabalburu.avisoscliente.modelo.Empleado;
import net.zabalburu.avisoscliente.servicio.ClienteServicio;


@Controller
@SessionAttributes({"empleado"})
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@RequestMapping("/")
	public String home(Model modelo) {
		List<Empleado> empleados = servicio.getEmpleados();
		modelo.addAttribute("empleados",empleados);
		return "index";
	}
	
	@RequestMapping("/index")
	public String login(
			@RequestParam String empleado, 
			Model modelo) {
		String error = null;
		Empleado e = null;	
		List<Aviso> avisos = servicio.getAvisosEmpleado(empleado);
		
		modelo.addAttribute("empleado",e);
		modelo.addAttribute("avisos",avisos);
		return "avisos";
	}

}
