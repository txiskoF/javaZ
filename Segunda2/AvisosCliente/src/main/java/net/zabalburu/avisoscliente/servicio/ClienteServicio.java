package net.zabalburu.avisoscliente.servicio;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.avisoscliente.modelo.Aviso;
import net.zabalburu.avisoscliente.modelo.Empleado;


@Service
public class ClienteServicio {
	@Autowired
	private RestTemplate template;
	
	public List<Empleado> getEmpleados(){
		return Arrays.asList(template.getForObject("http://localhost:8080/empleados", Empleado[].class));
	}
	
	public Empleado login(Integer idEmpleado) {
		return template.getForObject("http://localhost:8080/login/{idEmpleado}", 
				Empleado.class,idEmpleado);
	}
	
	public List<Aviso> getAvisosEmpleado(String idEmpleado) {
		return Arrays.asList(template.getForObject("http://localhost:8080/avisos/{idEmpleado}", Aviso[].class,idEmpleado));
	}
	
	

}
