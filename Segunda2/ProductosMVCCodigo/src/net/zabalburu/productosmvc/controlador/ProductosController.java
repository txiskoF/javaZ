package net.zabalburu.productosmvc.controlador;

import java.util.Date;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.zabalburu.productosmvc.modelo.Producto;
import net.zabalburu.productosmvc.servicio.ProductoServicio;

@Controller
@SessionAttributes({"empleado"})
public class ProductosController {
	
	@Autowired
	private ProductoServicio servicio;
	
	/*@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", servicio.getProductos());
		return "index";
	}*/
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("productos", servicio.getProductos());
		mv.addObject("categorias", servicio.getCategorias());
		mv.addObject("empleado", "Juan López");
		Producto p = new Producto();
		p.setFechaCompra(new Date());
		p.setPrecio(0.0);
		mv.addObject("producto",p);
		return mv;
	}
	
	
	@RequestMapping("/nuevo")
	public String nuevo(
/*			@RequestParam("nombre") String nombre,
			@RequestParam("idCategoria") int idCategoria,
			@RequestParam("precio") double precio, */
/*			@RequestParam String nombre,
			@RequestParam int idCategoria,
			@RequestParam double precio,*/
/*			String nombre,
			int idCategoria,
			double precio, */
				@Valid @ModelAttribute Producto producto,
				BindingResult result,
				@RequestParam int idCategoria,
				Model modelo) {
		/*Producto p = new Producto();
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setCategoria(servicio.getCategoria(idCategoria));
		servicio.nuevoProducto(p);*/
		modelo.addAttribute("productos", servicio.getProductos());
		modelo.addAttribute("categorias", servicio.getCategorias());
		if (result.hasErrors()) {
			return "index";
		}
		producto.setCategoria(servicio.getCategoria(idCategoria));
		servicio.nuevoProducto(producto);
		producto.setFechaCompra(new Date());
		modelo.addAttribute("producto", new Producto()); 
		return "index";
	}
	
	@RequestMapping("/nuevo2/{nombre}/{idCategoria}/{precio}")
	public String nuevo2(
			@PathVariable String nombre,
			@PathVariable int idCategoria,
			@PathVariable double precio,
			Model modelo) {
		Producto p = new Producto();
		p.setNombre(nombre);
		p.setPrecio(precio);
		p.setCategoria(servicio.getCategoria(idCategoria));
		servicio.nuevoProducto(p);
		modelo.addAttribute("productos", servicio.getProductos());
		modelo.addAttribute("categorias", servicio.getCategorias());
		return "index";
	}
	
	
}
