package net.zabalburu.actividad14.controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.actividad14.modelo.Curso;
import net.zabalburu.actividad14.modelo.Usuario;
import net.zabalburu.actividad14.servicio.CursosServicio;

@Controller
@SessionAttributes({"usuario"})
public class CursosController {

	@Autowired
	private CursosServicio servicio;
	
	@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model modelo, 
			@Valid @ModelAttribute Usuario usuario,
			BindingResult resultado
			) {
		if (resultado.hasErrors()) {
			usuario.setPassword("");
			return "login";
		}
		Usuario user = servicio.login(usuario.getUsuario(), 
				usuario.getPassword());
		if (user == null) {
			modelo.addAttribute("error","Usuario / password erróneos");
			usuario.setPassword("");
			return "login";
		}
		modelo.addAttribute("usuario",user);
		if (user.isAdministrador()) {
			modelo.addAttribute("cursos",servicio.getCursos());
			modelo.addAttribute("hoy", new Date());
			return "administrador";
		} else {
			return "usuario";
		}
	}
	
	@RequestMapping("/Eliminar")
	public String eliminar(Model modelo, @RequestParam Integer id) {
		servicio.eliminarCurso(id);
		modelo.addAttribute("cursos",servicio.getCursos());
		modelo.addAttribute("hoy", new Date());
		return "administrador";
	}
	
	@RequestMapping("/Modificar")
	public String modificar(Model modelo, @RequestParam Integer id) {
		Curso curso = servicio.getCurso(id);
		modelo.addAttribute("curso", curso);
		modelo.addAttribute("temas", servicio.getTemas());
		return "modificarCurso";
	}
	
	@RequestMapping("/Nuevo")
	public String nuevo(Model modelo) {
		Curso c = new Curso();
		GregorianCalendar gc = new GregorianCalendar();
		gc.clear(Calendar.HOUR);
		gc.clear(Calendar.HOUR_OF_DAY);
		gc.clear(Calendar.MINUTE);
		gc.clear(Calendar.SECOND);
		gc.clear(Calendar.MILLISECOND);
		c.setFechaInicio(gc.getTime());
		gc.add(Calendar.DATE,15);
		c.setFechaFin(gc.getTime());
		modelo.addAttribute("curso", c);
		modelo.addAttribute("temas", servicio.getTemas());
		return "modificarCurso";
	}
	
	@RequestMapping("/Guardar")
	public String guardar(Model modelo, 
			@Valid @ModelAttribute Curso curso,
			BindingResult result,
			@RequestParam(required = false) Integer id,
			@RequestParam Integer idTema) {
		curso.setTema(servicio.getTema(idTema));
		if (result.hasErrors()) {
			modelo.addAttribute("curso",curso);
			modelo.addAttribute("temas", servicio.getTemas());
			return "modificarCurso";
		}
		if (id == null) {
			servicio.nuevoCurso(curso);
		} else {
			servicio.modificarCurso(curso);
		}
		modelo.addAttribute("cursos",servicio.getCursos());
		modelo.addAttribute("hoy", new Date());
		return "administrador";
	}
}
