package net.zabalburu.productos.controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import net.zabalburu.productos.modelo.Categoria;
import net.zabalburu.productos.modelo.Producto;
import net.zabalburu.productos.servicio.ProductosServicio;

@RestController
public class ProductoREST {

	@Autowired
	private ProductosServicio servicio;
	
	@Value("${server.port}")
	private Integer puerto;
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return servicio.getProductos();
	}
	
	/*@GetMapping("/productos/{dato}")
	public ResponseEntity<Producto> getProducto(@PathVariable String dato, @RequestParam String q){
		Producto p;
		if (q.equalsIgnoreCase("id")) {
			p = servicio.getProducto(Integer.parseInt(dato));
		} else {
			p = servicio.getProducto(dato);
		}
		if (p==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}*/
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id){
		Producto p = servicio.getProducto(id);
		System.out.println("PUERTO : " + puerto);
		if (p==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	@GetMapping("/productos/nombre/{nombre}")
	public ResponseEntity<Producto> getProducto(@PathVariable String nombre){
		Producto p = servicio.getProducto(nombre);
		if (p==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	@PostMapping("/productos")
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto producto) throws URISyntaxException{
		producto = servicio.guardarProducto(producto);
		URI uri = new URI("http://localhost:8081/productos/"+producto.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> modificarProducto(@PathVariable Integer id,@RequestBody Producto producto){
		Producto p = servicio.getProducto(id);
		if (p==null) {
			return ResponseEntity.notFound().build();
		} else {
			producto.setId(id);
			return ResponseEntity.ok(servicio.guardarProducto(producto));
		}
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Integer id){
		Producto p = servicio.getProducto(id);
		if (p==null) {
			return ResponseEntity.notFound().build();
		} else {
			servicio.eliminarProducto(id);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("/categorias")
	public List<Categoria> getCategorias(){
		return servicio.getCategorias();
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable Integer id){
		Categoria c = servicio.getCategoria(id);
		if (c==null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(c);
		}
	}
	
	@GetMapping("/categorias/{id}/productos")
	public ResponseEntity<List<Producto>> getProductosCategoria(@PathVariable Integer id){
		Categoria c = servicio.getCategoria(id);
		if (c != null) {
			return ResponseEntity.ok(c.getProductos());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(path = "/productos/token", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getToken(JwtAuthenticationToken token) {
		String resultado = "{";
		resultado += "\"nombre\":\"" + token.getName() + "\",";
		resultado += "\"Scopes:\"[";
		for(GrantedAuthority ga: token.getAuthorities()) {
			resultado+="\"" + ga.getAuthority() + "\",";
		}
		resultado = resultado.substring(0,resultado.length()-1)+"],";
		//resultado += "\"authorities\":\"" + token.getAuthorities().toString() + "\",";
		resultado += "\"details\":\"" + token.getDetails().toString() + "\",";
		resultado += "\"principal\":\"" + token.getPrincipal().toString() + "\",";
		resultado += "\"token\":\"" + token.getToken().toString() + "\",";
		Map<String,Object> attrs = token.getTokenAttributes();
		resultado += "\"Atributos\":[";
		for(String clave :attrs.keySet()) {
			resultado +="\"" + clave + "\":\"" + attrs.get(clave) + "\",";
		}
		resultado = resultado.substring(0,resultado.length()-1)+"],";
		resultado += "\"token_attributes\":\"" + token.getTokenAttributes().toString() + "\"";
		resultado += "}";
		
		String usuario = token.getTokenAttributes().get("preferred_name").toString();
		String nombre = token.getTokenAttributes().get("nombre").toString();
		String apellidos = token.getTokenAttributes().get("family_name").toString();
		String email = token.getTokenAttributes().get("email").toString();
		String roles = token.getTokenAttributes().get("scope").toString();
		
		return resultado;
	}
	
}
