package net.zabalburu.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.zabalburu.producto.modelo.Categoria;
import net.zabalburu.producto.modelo.Producto;
import net.zabalburu.producto.servicio.ProductoServicio;

@Controller
@SessionAttributes({"categorias","categoria"})
public class ProductoController {
	@Autowired
	private ProductoServicio servicio;
	
	/*@ModelAttribute("productos")
	public List<Producto> getProductos(){
		return servicio.getProductos();
	}*/
	
	/*@RequestMapping(value = "/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", servicio.getProductos());
		return "index";
	}*/
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		List<Categoria> categorias = servicio.getCategorias(); 
		mv.addObject("categorias",categorias);
		//mv.addObject("productos", categorias.get(0).getProductos());
		mv.addObject("categoria", servicio.getCategoria(categorias.get(0).getId()));
		Producto p = new Producto();
		p.setId(0);
		p.setPrecio(0.0);
		mv.addObject("producto", p);
		return mv;
	}
	
	/*@RequestMapping("/nuevo")
	public ModelAndView nuevoProducto(
		@RequestParam String nombre, @RequestParam double precio) {
		ModelAndView mv = new ModelAndView("index");
		Producto p = new Producto();
		p.setNombre(nombre);
		p.setPrecio(precio);
		servicio.nuevoProducto(p);
		mv.addObject("productos", servicio.getProductos());
		return mv;
	}*/
	
	@RequestMapping("/nuevo")
	public ModelAndView nuevoProducto(Model m, @Valid @ModelAttribute Producto producto,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("productos", servicio.getProductos());
		producto.setId(0);
		if (result.hasErrors()) {
			return mv;
		}
		Categoria c = (Categoria) m.getAttribute("categoria");
		producto.setCategoria(c);
		servicio.nuevoProducto(producto);
		m.addAttribute(c);
		Producto p = new Producto();
		p.setId(0);
		p.setPrecio(0.0);
		mv.addObject("producto", p);
		return mv;
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Model modelo, @RequestParam int id) {
		Producto p = servicio.getProducto(id);
		Categoria c = p.getCategoria();
		servicio.eliminarProducto(id);
		modelo.addAttribute("categoria",servicio.getCategoria(c.getId()));
		p = new Producto();
		p.setId(0);
		p.setPrecio(0.0);
		modelo.addAttribute("producto", p);
		return "index";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar2(Model modelo, @PathVariable int id) {
		Producto p = servicio.getProducto(id);
		Categoria c = p.getCategoria();
		servicio.eliminarProducto(id);
		modelo.addAttribute("categoria",servicio.getCategoria(c.getId()));
		p = new Producto();
		p.setId(0);
		p.setPrecio(0.0);
		modelo.addAttribute("producto", p);
		return "index";
	}
	
	@RequestMapping("/seleccionarCategoria")
	public String seleccionarCategoria(@RequestParam Integer id, Model m) {
		Categoria c = servicio.getCategoria(id);
		m.addAttribute("categoria",c);
		Producto p = new Producto();
		p.setId(0);
		p.setPrecio(0.0);
		m.addAttribute("producto", p);
		return "index";
		
	}
	
}
