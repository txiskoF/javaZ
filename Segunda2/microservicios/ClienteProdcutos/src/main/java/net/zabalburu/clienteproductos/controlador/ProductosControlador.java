package net.zabalburu.clienteproductos.controlador;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.clienteproductos.auth.JWTToken;
import net.zabalburu.clienteproductos.auth.TokenServicio;
import net.zabalburu.clienteproductos.auth.UsuarioJWT;
import net.zabalburu.clienteproductos.modelo.Producto;
import net.zabalburu.clienteproductos.servicio.ProductosServicio;

@Controller
@SessionAttributes({"usuario"})
public class ProductosControlador {
	
	@Autowired
	private TokenServicio tokenServicio;
	
	@Autowired
	private ProductosServicio servicio;
	
	@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", servicio.getProductos());
		modelo.addAttribute("categorias", servicio.getCategorias());
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/entrar")
	public String entrar(@RequestParam String usuario, @RequestParam String password,
			Model modelo) {
		String error = null;
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Debe especificar ambos campos";
		} else {
			UsuarioJWT user = servicio.login(usuario, password);
			if (user == null ) {
				error = "Usuario / Password erróneos";
				
			} else {
				modelo.addAttribute("usuario", user);
			}
		}
		if (error != null) {
			modelo.addAttribute("error",error);
			return "login";
		} else {
			modelo.addAttribute("productos", servicio.getProductos());
			modelo.addAttribute("categorias", servicio.getCategorias());
			return "index";
		}
	}
	
	@RequestMapping("/ofertas")
	public String ofertas(Model modelo) {
		modelo.addAttribute("ofertas", servicio.getOfertas());
		return "ofertas";
	}
	
	@RequestMapping("/salir")
	public String salir(Model modelo, HttpSession sesion) {
		modelo.addAttribute("usuario",null);
		sesion.removeAttribute("usuario");
		sesion.invalidate();
		modelo.addAttribute("productos", servicio.getProductos());
		modelo.addAttribute("categorias", servicio.getCategorias());
		return "index";
	}
	
	@RequestMapping("/usuario")
	@ResponseBody
	public UsuarioJWT getUsuario(Model modelo) {
		UsuarioJWT actual = (UsuarioJWT) modelo.getAttribute("usuario");
		return actual;
	}
	
	@RequestMapping("/borrar")
	public String borrar(@RequestParam Integer id, Model modelo) {
		servicio.eliminarProducto(id);
		modelo.addAttribute("productos", servicio.getProductos());
		modelo.addAttribute("categorias", servicio.getCategorias());
		return "index";
	}
	
	@RequestMapping("/nuevoProducto")
	public String nuevoProducto(Model modelo) {
		modelo.addAttribute(new Producto());
		modelo.addAttribute("categorias", servicio.getCategorias());
		return "nuevoProducto";
	}
	
	@RequestMapping("/guardar")
	public String guardar(@Valid @ModelAttribute Producto producto,
			BindingResult res,
			@RequestParam Integer idCategoria,
			Model modelo) {
		modelo.addAttribute("categorias", servicio.getCategorias());
		if (res.hasErrors()) {
			return "nuevoProducto";
		}
		producto.setCategoria(servicio.getCategoria(idCategoria));
		//servicio.guardarProducto(producto);
		modelo.addAttribute("productos", servicio.getProductos());
		return "index";
	}
	
}
