package net.zabalburu.trabajos.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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

import net.zabalburu.trabajos.modelo.Trabajo;
import net.zabalburu.trabajos.servicio.TrabajosServicio;

@RestController

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TrabajosREST {

	@Autowired
	private TrabajosServicio servicio;
	
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;

	@GetMapping("/trabajos")
	public List<Trabajo> getTrabajos() {
		return servicio.getTrabajos();
	}

	@GetMapping("/trabajos/{id}")
	public ResponseEntity<Trabajo> getTrabajo(@PathVariable Integer id) {
		Trabajo t = servicio.getTrabajo(id);
		if (t != null) {
			return ResponseEntity.ok(t);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/trabajos/categoria/{idCategoria}")
	public ResponseEntity<List<Trabajo>> getTrabajosCategoria(@PathVariable Integer idCategoria) {
		List<Trabajo> trabajos = servicio.getTrabajosCategoria(idCategoria);
		if (trabajos != null) {
			return ResponseEntity.ok(trabajos);
		} else {
			return ResponseEntity.ok(new ArrayList<Trabajo>());
		}
	}

	@PostMapping("/trabajos")
	public ResponseEntity<?> nuevoTrabajo(@RequestBody Trabajo trabajo) throws URISyntaxException {
		trabajo = servicio.guardarTrabajo(trabajo);
		URI uri = new URI("http://trabajos-ms/trabajos/" + trabajo.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/trabajos/{id}")
	public ResponseEntity<?> eliminarTrabajo(@PathVariable Integer id) {
		Trabajo t = servicio.getTrabajo(id);
		if (t == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarTrabajo(id);
			return ResponseEntity.ok().build();
		}
	}

	@PutMapping("/trabajos/{id}")
	public ResponseEntity<Trabajo> modificarTrabajo(@PathVariable Integer id, @RequestBody Trabajo trabajo) {
		Trabajo t = servicio.getTrabajo(id);
		if (t == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(servicio.guardarTrabajo(trabajo));
		}
	}

	@PostMapping("/trabajos/trabajosPorIds")
	public ResponseEntity<List<Trabajo>> getTrabajosPorIds(@RequestBody List<Integer> listaIds) throws URISyntaxException {
		ArrayList<Trabajo> listaTrabajos = (ArrayList<Trabajo>)servicio.getTrabajosPorIds(listaIds);
		return ResponseEntity.ok(listaTrabajos);
	}
	
}
