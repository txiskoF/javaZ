package net.zabalburu.temas.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.temas.modelo.Tema;
import net.zabalburu.temas.servicio.TemasServicio;

@RestController
public class TemasREST {
	
	@Autowired
	private TemasServicio servicio;
	
	@GetMapping("/temas")
	public List<Tema> getTemas(){
		return servicio.getTemas();
	}
	
	@GetMapping("/temas/{id}")
	public ResponseEntity<Tema> getTema(@PathVariable Integer id){
		Tema t = servicio.getTema(id);
		if (t==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(t);
		}
	}
	

}
