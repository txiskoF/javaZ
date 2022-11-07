package net.zabalburu.productosrest.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.productosrest.modelo.Categoria;
import net.zabalburu.productosrest.modelo.Producto;
import net.zabalburu.productosrest.servicio.ProductoServicio;

@RestController
public class ProductosREST {
	
	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping("/productos")
	public List<Producto> getProductos() {
		return servicio.getProductos();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id) {
		Producto p = servicio.getProducto(id);
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/productos")
	public ResponseEntity<Producto> nuevoProducto(@RequestBody(required = false) Producto nuevo) throws URISyntaxException {
		if (nuevo == null) {
			return ResponseEntity.noContent().build();
		}
		servicio.nuevoProducto(nuevo);
		URI uri = new URI("http://localhost:8080/productos/" + nuevo.getId());
		return ResponseEntity.created(uri).body(nuevo);
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Producto> eliminarProducto(@PathVariable Integer id) {
		Producto p = servicio.getProducto(id);
		if (p != null) {
			servicio.eliminarProducto(p.getId());
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/*@PostMapping("/productos")
	public Producto nuevoProducto(@RequestBody Producto nuevo) {
		System.out.println(nuevo);
		servicio.nuevoProducto(nuevo);
		return nuevo;
	}*/
	
	@GetMapping("/categorias")
	public List<Categoria> getCategorias(){
		return servicio.getCategorias();
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable Integer id){
		Categoria c = servicio.getCategoria(id);
		if (c!=null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/categorias/{id}/productos")
	public ResponseEntity<List<Producto>> getProductosCategoria(
			@PathVariable Integer id,
			@RequestParam(required = false) String ordenado){
		Categoria c = servicio.getCategoria(id);
		if (c != null) {
			if (ordenado==null) {
				return ResponseEntity.ok(c.getProductos());
			} else {
				List<Producto> productos = c.getProductos();
				Collections.sort(productos,
						new Comparator<Producto>() {

							@Override
							public int compare(Producto p1, Producto p2) {
								// TODO Auto-generated method stub
								return -p1.getNombre().compareTo(p2.getNombre());
							}
						});
				return ResponseEntity.ok(productos);
			}
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/*@GetMapping("/productos/{id}")
	public Producto getProducto(@PathVariable Integer id) {
		return servicio.getProducto(id);
	}*/
	
	/*@GetMapping("/productos2")
	public Producto getProducto2(@RequestParam Integer id) {
		return servicio.getProducto(id);
	}*/
}
