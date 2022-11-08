package net.zabalburu.empleados.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.empleados.modelo.Empleado;
import net.zabalburu.empleados.servicio.EmpleadosServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EmpleadosREST {

	@Autowired
	private EmpleadosServicio servicio;
	
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;

	@GetMapping("/empleados")
	public List<Empleado> getEmpleados() {
		return servicio.getEmpleados();
	}

	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<Empleado> login(@PathVariable String email, @PathVariable String password) {
		Empleado e = servicio.login(email, password);
		if (e == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(e);
		}
	}

	@PostMapping("/empleados")
	public ResponseEntity<?> nuevoEmpleado(@RequestBody Empleado empleado) throws URISyntaxException {
		empleado = servicio.guardarEmpleado(empleado);
		URI uri = new URI("http://empleados-ms/empleados/" + empleado.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> eliminarEmpleado(@PathVariable Integer id) {
		Empleado e = servicio.getEmpleado(id);
		if (e == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarEmpleado(id);
			return ResponseEntity.ok().build();
		}
	}

	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleado> modificarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
		Empleado e = servicio.getEmpleado(id);
		if (e == null) {
			return ResponseEntity.notFound().build();
		} else {
			empleado.setId(id);
			return ResponseEntity.ok(servicio.guardarEmpleado(empleado));
		}
	}

	@GetMapping("/empleados/nombre/{nombre}{primerApellido}")
	public ResponseEntity<Empleado> getEmpleado(@PathVariable String nombre, String primerApellido) {
		Empleado e = servicio.getEmpleado(nombre, primerApellido);
		if (e == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(e);
		}
	}

}
