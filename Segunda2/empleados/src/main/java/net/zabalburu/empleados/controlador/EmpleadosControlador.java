package net.zabalburu.empleados.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.empleados.modelo.Empleado;
import net.zabalburu.empleados.servicio.EmpleadosServicio;

@RestController
public class EmpleadosControlador {

	@Autowired
	private EmpleadosServicio servicio;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/empleados")
	public List<Empleado> getNotas(){
		return servicio.getEmpleados();
	}
	
	@GetMapping("/empleados/{empleado}/{password}")
	public ResponseEntity<Empleado> login(@PathVariable Integer empleado,
			@PathVariable String password){
		Empleado e = servicio.login(empleado, password);
		if (e == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(e);
		}
	}
	
	
}
