package net.zabalburu.comentarios.controlador;

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

import net.zabalburu.comentarios.modelo.Comentario;
import net.zabalburu.comentarios.servicio.ComentariosServicio;

@RestController
public class ComentariosREST {
	
	@Autowired
	private ComentariosServicio servicio;
	
	@GetMapping("/comentarios")
	public List<Comentario> getComentarios(){
		return servicio.getComentarios();
	}
	
	@GetMapping("/comentarios/{id}")
	public ResponseEntity<Comentario> getComentario(@PathVariable Integer id){
		Comentario c = servicio.getComentario(id);
		if (c != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/comentarios/producto/{idProducto}")
	public ResponseEntity<List<Comentario>> getComentariosProducto(@PathVariable Integer idProducto){
		List<Comentario> comentarios = servicio.getComentariosProducto(idProducto);
		if (comentarios != null) {
			return ResponseEntity.ok(comentarios);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/comentarios")
	public ResponseEntity<Comentario> nuevoComentario(@RequestBody Comentario c) throws URISyntaxException{
		c = servicio.guardarComentario(c);
		if (c != null) {
			return ResponseEntity
					.created(new URI("http://localhost:8082/comentarios/"+c.getId()))
					.body(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/comentarios/{id}")
	public ResponseEntity<Comentario> modificarComentario(
			@PathVariable Integer id,
			@RequestBody Comentario c) throws URISyntaxException{
		Comentario comentario = servicio.getComentario(id);
		if (comentario == null) {
			return ResponseEntity.notFound().build();
		}
		c.setId(id);
		c = servicio.guardarComentario(c);
		if (c != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/comentarios/{id}")
	public ResponseEntity<?> eliminarComentario(@PathVariable Integer id){
		servicio.eliminarComentario(id);
		return ResponseEntity.ok().build();
	}
	
}
