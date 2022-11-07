package net.zabalburu.productos.controlador;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.zabalburu.productos.modelo.Categoria;
import net.zabalburu.productos.modelo.Producto;
import net.zabalburu.productos.servicio.ProductosServicio;

@RestController
public class ProductosREST {
	
	@Autowired
	private ProductosServicio servicio;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return servicio.getProductos();
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> getProducto(@PathVariable("id") Integer id){
		Producto p = servicio.getProducto(id);
		/*if (p != null) {
			return new ResponseEntity<Producto>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(path="/productos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto p) throws URISyntaxException{
		Producto nuevo = servicio.nuevoProducto(p);
		if (nuevo != null) {
			return ResponseEntity.created(new URI("/productos/"+nuevo.getId())).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path="/productos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificarProducto(@RequestBody Producto p) throws URISyntaxException{
		Producto nuevo = servicio.modificarProducto(p);
		if (nuevo != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/productos/{id}")
	public ResponseEntity<?> modificarProducto(@PathVariable("id") Integer id){
		Producto eliminar = servicio.eliminarProducto(id);
		if (eliminar != null) {
			return ResponseEntity.ok(eliminar);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping("/categorias")
	public List<Categoria> getCategorias(){
		return servicio.getCategorias();
	}
	
	@PostMapping(path="/categorias", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> nuevoCategoria(@RequestBody Categoria c) throws URISyntaxException{
		Categoria nuevo = servicio.nuevoCategoria(c);
		if (nuevo != null) {
			return ResponseEntity.created(new URI("/categorias/"+nuevo.getId())).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(path="/categorias", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> modificarCategoria(@RequestBody Categoria c) throws URISyntaxException{
		Categoria nuevo = servicio.modificarCategoria(c);
		if (nuevo != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path="/categorias/{id}")
	public ResponseEntity<?> modificarCategoria(@PathVariable("id") Integer id){
		Categoria eliminar = servicio.eliminarCategoria(id);
		if (eliminar != null) {
			return ResponseEntity.ok(eliminar);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
