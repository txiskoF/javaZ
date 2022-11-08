package net.zabalburu.trabajosPaciente.controlador;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.trabajosPaciente.modelo.TrabajoPaciente;
import net.zabalburu.trabajosPaciente.servicio.TrabajoPacienteServicio;

@RestController

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TrabajoPacienteREST {
	
	@Autowired
	private TrabajoPacienteServicio servicio;
	
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;
	
	@GetMapping("/trabajosPaciente/{idPaciente}")
	public ResponseEntity<List<TrabajoPaciente>> getTrabajosPacientePorIdPaciente(@PathVariable Integer idPaciente) {
		List<TrabajoPaciente> t = servicio.getTrabajosPacientePorIdPaciente(idPaciente);
		if (t != null) {
			return ResponseEntity.ok(t);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/trabajosPaciente")
	public ResponseEntity<?> nuevoTrabajoPaciente(@RequestBody TrabajoPaciente trabPac) throws URISyntaxException {
		trabPac = servicio.crearTrabajoPaciente(trabPac);
		URI uri = new URI("http://trabajosPaciente-ms/trabajosPaciente/" + trabPac.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/trabajosPaciente/{id}")
	public ResponseEntity<?> eliminarTrabajoPaciente(@PathVariable Integer id) {
		servicio.eliminarTrabajoPaciente(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/trabajosPaciente/{idTrabajo}/{idPaciente}")
	@Transactional
	public ResponseEntity<?> eliminarTrabajoPaciente(@PathVariable Integer idTrabajo, @PathVariable Integer idPaciente) {
		servicio.eliminarTrabajoPacientePorIdTrabajoIdPaciente(idTrabajo, idPaciente);
		return ResponseEntity.ok().build();
	}

}
