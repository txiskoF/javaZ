package net.zabalburu.avisos.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.avisos.modelo.Aviso;
import net.zabalburu.avisos.modelo.Empleado;
import net.zabalburu.avisos.modelo.Respuesta;
import net.zabalburu.avisos.servicio.AvisosServicio;

@RestController
public class AvisosControlador {

	@Autowired
	private AvisosServicio servicio;
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		return servicio.getEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleado> getEmpleado(@PathVariable String id){
		Empleado e = servicio.getEmpleado(id);
		if (e != null) {
			return ResponseEntity.ok(e);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/avisos")
	public List<Aviso> getAvisos(){
		return servicio.getAvisos();
	}
	
	@GetMapping("/avisos/{id}")
	public ResponseEntity<Aviso> getTema(@PathVariable Integer id){
		Aviso aviso = servicio.getAviso(id);
		if (aviso != null) {
			return ResponseEntity.ok(aviso);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/respuestas/{idAviso}")
	public List<Respuesta> getRespuestasAviso(@PathVariable Integer idAviso){
		return servicio.getRespuestasAviso(idAviso);
	}
	
	@PostMapping("/respuestas")
	public ResponseEntity<Respuesta> nuevaRespuesta(@RequestBody Respuesta r) throws URISyntaxException{
		Respuesta resp = servicio.nuevaRespuesta(r);
		return ResponseEntity.created(new URI("http://localhost:8080/respuestas/"+resp.getId())).body(resp);
	}
	
}
