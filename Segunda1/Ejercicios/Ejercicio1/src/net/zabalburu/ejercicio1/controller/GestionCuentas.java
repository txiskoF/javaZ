package net.zabalburu.ejercicio1.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.ejercicio1.modelo.Cliente;
import net.zabalburu.ejercicio1.modelo.Concepto;
import net.zabalburu.ejercicio1.modelo.Operacion;
import net.zabalburu.ejercicio1.service.CuentaService;

@Controller
@SessionAttributes({"cliente","conceptos"})
public class GestionCuentas {
	@Autowired
	private CuentaService servicio;
	
	
	@RequestMapping("/")
	public String index(Model m) {
		Cliente c = new Cliente();
		m.addAttribute("cliente", c);
		return "index";
	}
	
	@PostMapping("/login")
	public String login(Model m, @ModelAttribute @Valid Cliente cliente,
			BindingResult result) {
		System.out.println(cliente);
		System.out.println(result);
		if (result.hasErrors()) {
			cliente.setPassword("");
			return "index";
		}
		Cliente c = servicio.login(cliente.getNombre(), cliente.getPassword());
		if (c == null) {
			result.addError(new FieldError("cliente", "password", "Usuario / password erróneos"));
			return "index";
		}
		m.addAttribute("cliente", c);
		m.addAttribute("conceptos", servicio.getConceptos());
		Operacion o = new Operacion();
		o.setFecha(new Date());
		o.setImporte(0.0);
		m.addAttribute("operacion", o);
		return "cliente";
	}
	
	@RequestMapping("/guardarOperacion")
	public String guardar(Model m, 
			@RequestParam Integer idConcepto,@ModelAttribute Operacion operacion) {
		operacion.setCliente((Cliente) m.getAttribute("cliente"));
		operacion.setConcepto(servicio.getConcepto(idConcepto));
		servicio.nuevaOperacion(operacion);
		Operacion o = new Operacion();
		o.setFecha(new Date());
		o.setImporte(0.0);
		m.addAttribute("operacion", o);
		return "cliente";
	}
	
	@RequestMapping("/volver")
	public String volver(Model m, HttpSession sesion) {
		sesion.invalidate();
		Cliente c = new Cliente();
		m.addAttribute("cliente",c);
		return "index";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Model m, @RequestParam Integer id) {
		servicio.eliminarOperacion(id);
		Cliente c = (Cliente) m.getAttribute("cliente");
		c = servicio.getCliente(c.getNombre());
		m.addAttribute("cliente",c);
		Operacion o = new Operacion();
		o.setFecha(new Date());
		o.setImporte(0.0);
		m.addAttribute("operacion", o);
		return "cliente";
	}
	
	@GetMapping("/nuevoConcepto")
	public String nuevoConcepto(Model m) {
		Concepto c = new Concepto();
		m.addAttribute("concepto",c);
		return "concepto";
	}
	
	@RequestMapping("/guardarConcepto")
	public String guardarConcepto(Model m, @Valid @ModelAttribute Concepto concepto,
			BindingResult result) {
		if (result.hasErrors()) {
			return "concepto";
		}
		servicio.nuevoConcepto(concepto);
		m.addAttribute("conceptos",servicio.getConceptos());
		Operacion o = new Operacion();
		o.setFecha(new Date());
		o.setImporte(0.0);
		m.addAttribute("operacion", o);
		return "cliente";
	}

	@RequestMapping("/volverCliente")
	public String volverCliente(Model m) {
		Operacion o = new Operacion();
		o.setFecha(new Date());
		o.setImporte(0.0);
		m.addAttribute("operacion", o);
		return "cliente";
	}
	
}
