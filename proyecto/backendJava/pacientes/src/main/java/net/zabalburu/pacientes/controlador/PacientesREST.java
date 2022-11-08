package net.zabalburu.pacientes.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.transaction.Transactional;

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

import net.zabalburu.pacientes.modelo.Paciente;
import net.zabalburu.pacientes.servicio.PacientesServicio;
import net.zabalburu.pacientes.servicio.TrabajoPacienteServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH, RequestMethod.TRACE})
public class PacientesREST {

	@Autowired
	private PacientesServicio servicio;

	@Autowired
	private TrabajoPacienteServicio servicioTrabajoPaciente;
	
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;

	@GetMapping("/pacientes")
	public List<Paciente> getPacientes() {
		return servicio.getPacientes();
	}
	
	@PostMapping("/pacientes")
	public ResponseEntity<?> nuevoPaciente(@RequestBody Paciente paciente) throws URISyntaxException {
		paciente = servicio.guardarPaciente(paciente);
		URI uri = new URI("http://pacientes-ms/pacientes/" + paciente.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/pacientes/{id}")
	@Transactional
	public ResponseEntity<?> eliminarPaciente(@PathVariable Integer id) {
		Paciente p = servicio.getPaciente(id);
		if (p == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicioTrabajoPaciente.eliminarTrabajoPacientesIdPaciente(id);
			servicio.eliminarPaciente(id);
			return ResponseEntity.ok().build();
		}
	}

	@PutMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> modificarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
		Paciente p = servicio.getPaciente(id);
		if (p == null) {
			return ResponseEntity.ok(null);
		} else {
			paciente.setId(id);
			return ResponseEntity.ok(servicio.guardarPaciente(paciente));
		}
	}

	@GetMapping("/pacientes/paciente/{nombre}/{primerApellido}")
	public ResponseEntity<Paciente> buscarPaciente(@PathVariable String nombre, @PathVariable String primerApellido) {
		Paciente p = servicio.getPacienteNombre(nombre, primerApellido);
		if (p == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}

	@GetMapping("/pacientes/pacientessn/{ssn}")
	public ResponseEntity<Paciente> buscarPacienteSsn(@PathVariable Long ssn) {
		Paciente p = servicio.getPacienteSsn(ssn);
		if (p == null) {
			return ResponseEntity.ok(new Paciente());
		} else {
			return ResponseEntity.ok(p);
		}
	}

	@GetMapping("/pacientes/pacientenif/{nif}")
	public ResponseEntity<Paciente> buscarPacienteNif(@PathVariable String nif) {
		Paciente p = servicio.getPacienteNif(nif);
		if (p == null) {
			return ResponseEntity.ok(new Paciente());
		} else {
			return ResponseEntity.ok(p);
		}
	}

}
