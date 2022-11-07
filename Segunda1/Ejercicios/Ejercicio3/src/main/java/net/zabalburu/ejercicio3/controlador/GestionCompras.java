package net.zabalburu.ejercicio3.controlador;

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

import net.zabalburu.ejercicio3.modelo.Compra;
import net.zabalburu.ejercicio3.modelo.Editorial;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.modelo.Usuario;
import net.zabalburu.ejercicio3.servicio.ComprasServicio;

@RestController
public class GestionCompras {
	@Autowired
	private ComprasServicio servicio;
	
	//ObtnerEditoriales
	@GetMapping("/editoriales")
	public ResponseEntity<?> getEditoriales(){
		return ResponseEntity.ok(servicio.getEditoriales());
	}
	
	//Obtener Editoriales por id
	@GetMapping("/editoriales/{id}")
	public ResponseEntity<?> getEditorial(@PathVariable(name = "id") String id){
		Editorial e = servicio.getEditorial(id);
		if (e!=null) {
			//Si es correcto
			return ResponseEntity.ok(e);
		} else {
			//Si no se encuentrra
			return ResponseEntity.notFound().build();
		}
	}
	
	//Obtener libros de la Editorial por el id dela Editorial
	@GetMapping("/libros/editorial/{id}")
	public ResponseEntity<?> getLibrosEditorial(@PathVariable(name = "id") String id){
		Editorial e = servicio.getEditorial(id);
		if (e!=null) {
			return ResponseEntity.ok(e.getLibros());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Retornar libros por palabara buscada
	@GetMapping("/libros/buscar/{busqueda}") //Esta es la direccion que hay que poner el el REST
	public ResponseEntity<?> buscarLibros(@PathVariable(name = "busqueda") String busqueda){
		return ResponseEntity.ok(servicio.buscarLibros(busqueda));
	}
	
	//Retornar el libro segun id
	@GetMapping("/libros/{id}")
	public ResponseEntity<?> getLibro(@PathVariable(name = "id") String id){
		Libro l = servicio.getLibro(id);
		if (l!=null) {
			return ResponseEntity.ok(l);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Retornar compras del usuario por id
	@GetMapping("/compras/{id}")
	public ResponseEntity<?> getCompra(@PathVariable(name = "id") Integer idUsuario){
		Usuario u = servicio.getUsuario(idUsuario);
		if (u!=null) {
			return ResponseEntity.ok(u.getCompras());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	//Añadir una compra a BBDD mediante iddeusuario
	@PostMapping("/compras/{id}")
	public ResponseEntity<?> nuevaCompra(@PathVariable(name = "id") Integer idUsuario,
			//Se envia la informacion de la compra en el cuerpo de la pagina
			@RequestBody Compra c){
		Usuario u = servicio.getUsuario(idUsuario);
		if (u != null) {
			c.setUsuario(u);
			c = servicio.nuevaCompra(c);	
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	//Modiifcar la compra con el id de compra
	@PutMapping("/compras/{id}")
	public ResponseEntity<?> modificarCompra(@PathVariable(name = "id") Integer id,
			@RequestBody Compra c){
		c.setId(id);
		c = servicio.modificarCompra(c);
		if (c != null) {
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	//Eleimiar la compra marcada
	@DeleteMapping("/compras/{id}")
	public ResponseEntity<?> eliminarCompra(@PathVariable(name = "id") Integer id){
		Compra c = servicio.getCompra(id);
		if (c != null) {
			servicio.eliminarCompra(id);
			return ResponseEntity.ok(c);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
