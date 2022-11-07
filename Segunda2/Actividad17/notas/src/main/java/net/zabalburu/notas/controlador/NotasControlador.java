package net.zabalburu.notas.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.notas.modelo.Nota;
import net.zabalburu.notas.servicio.NotasServicio;

@RestController
public class NotasControlador {
	@Autowired
	private NotasServicio servicio;
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/notas")
	public List<Nota> getNotas(){
		return servicio.getNotas();
	}
	
	@GetMapping("/notas/{id}")
	public ResponseEntity<Nota> getNota(@PathVariable Integer id){
		Nota n = servicio.getNota(id);
		if (n == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(n);
		}
	}
	
	@GetMapping("/notas/alumno/{idAlumno}")
	public List<Nota> getNota(@PathVariable Integer idAlumno,
		@RequestParam(name = "m",required = false) Integer idModulo,
		@RequestParam(name = "e", required = false) Integer evaluacion){
		return servicio.getNotasAlumno(idAlumno, idModulo, evaluacion);
	}
	
	@GetMapping("/notas/modulo/{idModulo}")
	public List<Nota> getNotasModulo(@PathVariable Integer idModulo,
		@RequestParam(name="e", required=false) Integer evaluacion){
		return servicio.getNotasModulo(idModulo, evaluacion);
	}
	
	@PostMapping("/notas")
	public ResponseEntity<Nota> nuevaNota(@RequestBody Nota nota) throws URISyntaxException{
		try {
			template.getForEntity("http://alumnos/alumnos/{id}", Object.class,nota.getIdAlumno());
			template.getForEntity("http://modulos/modulos/{id}", Object.class,nota.getIdModulo());
		} catch (HttpClientErrorException.NotFound ex) {
			ex.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		nota = servicio.guardarNota(nota);
		return ResponseEntity.created(new URI("http://localhost:8090/notas/"+nota.getId())).body(nota);
	}
	
	@PutMapping("/notas/{id}")
	public ResponseEntity<Nota> modificarNota(@RequestBody Nota nota, @PathVariable Integer id){
		Nota n = servicio.getNota(id);
		if (n == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			template.getForEntity("http://alumnos/alumnos/{id}", Object.class,nota.getIdAlumno());
			template.getForEntity("http://modulos/modulos/{id}", Object.class,nota.getIdModulo());
		} catch (HttpClientErrorException.NotFound ex) {
			ex.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		nota.setId(id);
		nota = servicio.guardarNota(nota);
		return ResponseEntity.ok(nota);
	}
	
	@DeleteMapping("/notas/{id}")
	public ResponseEntity<?> eliminarNota(@PathVariable Integer id){
		servicio.eliminarNota(id);
		return ResponseEntity.ok().build();
	}
}
