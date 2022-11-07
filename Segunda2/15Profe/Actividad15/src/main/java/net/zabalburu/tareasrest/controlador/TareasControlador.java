package net.zabalburu.tareasrest.controlador;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.tareasrest.modelo.Tarea;
import net.zabalburu.tareasrest.modelo.Usuario;
import net.zabalburu.tareasrest.servicio.TareasServicio;

@RestController
public class TareasControlador {

	@Autowired
	private TareasServicio servicio;
	
	@RequestMapping(method = RequestMethod.GET,path = "/usuarios")
	public List<Usuario> getUsuarios(){
		return servicio.getUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Integer id){
		Usuario u = servicio.getUsuario(id);
		if (u!=null) {
			return ResponseEntity.ok(u);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/usuarios/{id}/tareas")
	public ResponseEntity<List<Tarea>> getTareasUsuario(@PathVariable Integer id){
		Usuario u = servicio.getUsuario(id);
		if (u!=null) {
			return ResponseEntity.ok(u.getTareas());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/usuarios/{id}/pendientes")
	public ResponseEntity<List<Tarea>> getTareasPendientesUsuario(@PathVariable Integer id){
		Usuario u = servicio.getUsuario(id);
		if (u!=null) {
			return ResponseEntity.ok(servicio.getPendientes(id));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/usuarios/{usuario}/{password}")
	public ResponseEntity<Usuario> login(@PathVariable String usuario,
			@PathVariable String password){
		Usuario u = servicio.getUsuario(usuario, password);
		if (u == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(u);
		}
	}
	
	@PostMapping("/usuarios/{id}/tareas")
	public ResponseEntity<Tarea> nuevaTarea(@PathVariable Integer id,
		@RequestBody Tarea nueva) throws URISyntaxException{
		System.out.println(nueva);
		Usuario usuario = servicio.getUsuario(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		} else {
			nueva = servicio.nuevaTarea(id, nueva);
			return ResponseEntity.created(new URI("http://localhost:8080/usuarios/"+id+
					"/tareas/"+nueva.getId())).build();
		}
	}
	
	@GetMapping("/usuarios/{idUsuario}/tareas/{idTarea}")
	public ResponseEntity<Tarea> getTarea(@PathVariable Integer idUsuario,
			@PathVariable Integer idTarea){
		Tarea t = servicio.getTarea(idTarea);
		if (t==null || t.getUsuario().getId()!= idUsuario) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(t);
		}
	}

	@DeleteMapping("/usuarios/{idUsuario}/tareas/{idTarea}")
	public ResponseEntity<Tarea> eliminarTarea(@PathVariable Integer idUsuario,
			@PathVariable Integer idTarea){
		Tarea t = servicio.getTarea(idTarea);
		if (t==null || t.getUsuario().getId()!= idUsuario) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarTarea(idTarea);
			return ResponseEntity.ok().build();
		}
	}
	
	@PutMapping("/usuarios/{id}/tareas")
	public ResponseEntity<Tarea> modificarTarea(@PathVariable Integer id,
		@RequestBody Tarea t) {
		Usuario usuario = servicio.getUsuario(id);
		Tarea tarea = servicio.getTarea(t.getId());
		if (usuario == null || tarea == null) {
			return ResponseEntity.notFound().build();
		} else {
			t.setUsuario(usuario);
			servicio.modificarTarea(t);
			return ResponseEntity.ok().build();
		}
	}
}
