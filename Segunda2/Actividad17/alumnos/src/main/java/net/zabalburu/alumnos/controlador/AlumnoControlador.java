package net.zabalburu.alumnos.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.alumnos.modelo.Alumno;
import net.zabalburu.alumnos.servicios.AlumnosServicio;

@RestController
public class AlumnoControlador {
	@Autowired
	private AlumnosServicio servicio;
	
	@GetMapping("/alumnos")
	public List<Alumno> getAlumnos(){
		return servicio.getAlumnos();
	}
	
	@GetMapping("/alumnos/{id}")
	public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id){
		Alumno a = servicio.getAlumno(id);
		if (a == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(a);
		}
	}
	
	@PostMapping("/alumnos")
	public ResponseEntity<Alumno> añadirAlumno(@RequestBody Alumno alumno) throws URISyntaxException{
		alumno = servicio.guardarAlumno(alumno);
		return ResponseEntity.created(new URI("http://localhost:8090/productos/productos/" + alumno.getId())).body(alumno);
	}
	
	@PutMapping("/alumnos/{id}")
	public ResponseEntity<?> modificarAlumno(@PathVariable Integer id, @RequestBody Alumno alumno){
		Alumno buscar = servicio.getAlumno(id);
		if (buscar == null) {
			return ResponseEntity.notFound().build();
		} 
		alumno.setId(id);
		servicio.guardarAlumno(alumno);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/alumnos/{id}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Integer id) {
		Alumno buscar = servicio.getAlumno(id);
		if (buscar == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarAlumno(id);
			return ResponseEntity.ok().build();
		}
	}
	
}
