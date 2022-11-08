package net.zabalburu.categorias.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.categorias.modelo.Categoria;
import net.zabalburu.categorias.servicio.CategoriasServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoriasREST {

	@Autowired
	private CategoriasServicio servicio;
		
	@Autowired
	@Qualifier("balanceado")
	private RestTemplate template;

	@GetMapping("/categorias")
	public List<Categoria> getCategorias() {
		return servicio.getCategorias();
	}

	@PostMapping("/categorias")
	public ResponseEntity<?> nuevaCategoria(@RequestBody Categoria categoria) throws URISyntaxException {
		categoria = servicio.guardarCategoria(categoria);
		URI uri = new URI("http://categorias-ms/categorias/" + categoria.getId());
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id) {
		Categoria c = servicio.getCategoriaId(id);
		if (c == null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarCategoria(id);
			return ResponseEntity.ok().build();
		}
	}

}
