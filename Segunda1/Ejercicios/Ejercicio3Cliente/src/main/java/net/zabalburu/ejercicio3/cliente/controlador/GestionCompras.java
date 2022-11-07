package net.zabalburu.ejercicio3.cliente.controlador;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.ejercicio3.cliente.modelo.Compra;
import net.zabalburu.ejercicio3.cliente.modelo.Editorial;
import net.zabalburu.ejercicio3.cliente.modelo.Libro;
import net.zabalburu.ejercicio3.cliente.modelo.Usuario;
import net.zabalburu.ejercicio3.cliente.servicio.ComprasServicio;

@Controller
@SessionAttributes({"usuario"})
public class GestionCompras {
	//1 esto
	@Autowired
	private ComprasServicio servicio;
	
	//2esto
	@RequestMapping("/")
	public String index(Model m, Authentication auth) {
		//oBTTENER EL USUSARIO
		Usuario user = (Usuario) auth.getPrincipal();
		//añadirlo al modelo
		m.addAttribute("usuario",user.getNombre());
		//a para obtener la editorial y ñadirla al modelo
		List<Editorial> ed = servicio.getEditoriales();
		m.addAttribute("editoriales", ed);
		return "index";
	}
	
	//3esto
	@RequestMapping("/buscarEditorial")
				//Recibo un parametro que es el id de editoriao y necesito tambien el modelo
	public String buscarLibrosEditorial(@RequestParam String id, Model m) {
		//Al buscar los libros de una editoriao se los pido al servicio
		m.addAttribute("libros",servicio.getLibrosEditorial(id));
				//El nombre es del jsp al que ahy que ir
		return "libros";
	}
	
	@RequestMapping("/buscarLibros")
	public String buscarLibros(@RequestParam String busqueda, Model m) {
		m.addAttribute("libros",servicio.buscarLibros(busqueda));
		return "libros";
	}
	
	//AÑADIR METODO PARA VER LIBRO AL DAO CREAR METODO
	@RequestMapping("/verLibro")
	public String verLibro(@RequestParam String id, Model m) {
		m.addAttribute("libro",servicio.getLibro(id));
		return "libro";
	}
	
	@RequestMapping("/comprarLibro")
	public String comprarLibro(@RequestParam("id") String idLibro,
			@RequestParam("unidades") Integer unidades, 
			//Coger el usuario
			Authentication auth, Model m) {
		Usuario usuario = (Usuario) auth.getPrincipal();
		Libro l = servicio.getLibro(idLibro);
		//Libro l = new Libro();
		//l.setId(idLibro);
		Compra c = new Compra();
		c.setUnidades(unidades);
		c.setLibro(l);
		c.setPrecio(l.getPrecio());
		c.setFecha(new Date());
		servicio.nuevaCompra(c, usuario.getId());
		m.addAttribute("compras", servicio.getCompras(usuario.getId()));
		return "miscompras";
	}
	
	@RequestMapping("/miscompras")
	public String misCompras(Authentication auth, Model m) {
		Usuario usuario = (Usuario) auth.getPrincipal();
		m.addAttribute("compras", servicio.getCompras(usuario.getId()));
		return "miscompras";
	}
}
