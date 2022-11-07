package net.zabalburu.noticias.controlador;

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

import net.zabalburu.noticias.modelo.Noticia;
import net.zabalburu.noticias.servicio.NoticiasServicio;

@RestController
public class NoticiasControlador {

	@Autowired
	private NoticiasServicio servicio;
	
	
	@GetMapping("/noticias/tema/{idTema}")
	public ResponseEntity<List<Noticia>> getNoticiasTema(@PathVariable Integer idTema){
		List<Noticia> noticias = servicio.getNoticiasTema(idTema);
		if (noticias != null) {
			return ResponseEntity.ok(noticias);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/noticias")
	public ResponseEntity<Noticia> nuevaNoticia(@RequestBody Noticia n) throws URISyntaxException{
		n = servicio.guardarNoticia(n);
		if (n != null) {
			return ResponseEntity
					.created(new URI("http://localhost:8082/noticias/"+n.getId()))
					.body(n);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
