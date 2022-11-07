package net.zabalburu.ofertas.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.ofertas.modelo.Oferta;
import net.zabalburu.ofertas.servicio.OfertasServicio;

@RestController
public class OfertaControlador {
	@Autowired
	private OfertasServicio servicio;
	
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;
	
	
	
	/*@Autowired
	@Qualifier("normal")
	private RestTemplate template2;*/
	
	@GetMapping("/ofertas")
	public List<Oferta> getOfertas(){
		return servicio.getOfertasVigentes();
	}
	
	@GetMapping("/ofertas/{id}")
	public ResponseEntity<Oferta> getOferta(@PathVariable Integer id){
		Oferta o = servicio.getOferta(id);
		if (o == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(o);
		}
	}
	
	@PostMapping("/ofertas")
	public ResponseEntity<Oferta> nuevaOferta(@RequestBody Oferta o) 
			throws URISyntaxException{
		try {
			template.getForObject("http://productos-ms/productos/{id}", Object.class,o.getIdProd());
		} catch (HttpClientErrorException.NotFound ex) {
			return ResponseEntity.notFound().build();
		}
		o = servicio.guardarOferta(o);
		return ResponseEntity.created(new URI("http://localhost:8090/ofertas-ms/ofertas/"+o.getId())).body(o);
	}

	@PutMapping("/ofertas/{id}")
	public ResponseEntity<	Oferta> modificarOferta(@PathVariable Integer id,
			@RequestBody Oferta o) 
			throws URISyntaxException{
		try {
			template.getForObject("http://productos-ms/productos/{id}", Object.class,o.getIdProd());
		} catch (HttpClientErrorException.NotFound ex) {
			return ResponseEntity.notFound().build();
		}
		Oferta o2 = servicio.getOferta(id);
		if (o2 == null) {
			return ResponseEntity.notFound().build();
		}
		o.setId(id);
		o = servicio.guardarOferta(o);
		return ResponseEntity.ok(o);
	}
	
	@DeleteMapping("/ofertas/{id}")
	public ResponseEntity<?> eliminarOferta(@PathVariable Integer id){		
		if (servicio.getOferta(id)!=null) {
			servicio.eliminarOferta(id);
		}
		return ResponseEntity.ok().build();
	}
	
}
