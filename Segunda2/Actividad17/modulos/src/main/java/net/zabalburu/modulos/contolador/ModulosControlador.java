package net.zabalburu.modulos.contolador;

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

import net.zabalburu.modulos.modelo.Modulo;
import net.zabalburu.modulos.servicio.ModulosServicio;

@RestController
public class ModulosControlador {
	@Autowired
	private ModulosServicio servicio;
	
	@GetMapping("/modulos")
	public List<Modulo> getModulos(){
		return servicio.getModulos();
	}
	
	@GetMapping("/modulos/{id}")
	public ResponseEntity<Modulo> getModulo(@PathVariable Integer id){
		Modulo a = servicio.getModulo(id);
		if (a == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(a);
		}
	}
	
	@PostMapping("/modulos")
	public ResponseEntity<Modulo> añadirModulo(@RequestBody Modulo Modulo) throws URISyntaxException{
		Modulo = servicio.guardarModulo(Modulo);
		return ResponseEntity.created(new URI("http://localhost:8090/modulos/" + Modulo.getId())).body(Modulo);
	}
	
	@PutMapping("/modulos/{id}")
	public ResponseEntity<?> modificarModulo(@PathVariable Integer id, @RequestBody Modulo Modulo){
		Modulo buscar = servicio.getModulo(id);
		if (buscar == null) {
			return ResponseEntity.notFound().build();
		} 
		Modulo.setId(id);
		servicio.guardarModulo(Modulo);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/modulos/{id}")
	public ResponseEntity<?> eliminarModulo(@PathVariable Integer id) {
		Modulo buscar = servicio.getModulo(id);
		if (buscar == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarModulo(id);
			return ResponseEntity.ok().build();
		}
	}
}
