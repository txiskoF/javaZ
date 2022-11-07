package net.zabalburu.actividad13.controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.zabalburu.actividad13.modelo.Empleado;
import net.zabalburu.actividad13.modelo.Reunion;
import net.zabalburu.actividad13.servicio.ReunionServicio;

@Controller
@SessionAttributes({"empleado"})
public class GestionReuniones {
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private ReunionServicio servicio;
	
	@RequestMapping("/")
	public String login(Model modelo) {
		modelo.addAttribute("empleados", servicio.getEmpleados());
		return "login";
	}
	
	@RequestMapping("login")
	public String validar(@RequestParam String id, @RequestParam String password,
			Model modelo) {
		Empleado e = servicio.login(id, password);
		if (e == null) {
			modelo.addAttribute("error","Usuario / password erróneos");
			modelo.addAttribute("empleados", servicio.getEmpleados());
			return "login";
		} else {
			modelo.addAttribute("empleado",e);
			modelo.addAttribute("convoca",servicio.getReunionesConvoca(id));
			modelo.addAttribute("participa",servicio.getReunionesParticipa(id));
			return "empleado";
		}
	}
	
	@RequestMapping("ConvocarReunion")
	public ModelAndView convocarReunion() {
		ModelAndView mv = new ModelAndView("convocarReunion");
		Reunion r = new Reunion();
		r.setFecha(new Date());
		r.setDuracion(1);
		r.setHora("00:00");
		mv.addObject("reunion", r);
		
		return mv;
	}
	
	@RequestMapping("nuevaReunion")
	public String nuevaReunion(@ModelAttribute Reunion reunion,
			@RequestParam String controlFecha, Model m) {
		try {
			reunion.setFecha(df.parse(controlFecha));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			reunion.setFecha(new Date());
		}
		Empleado e = (Empleado) m.getAttribute("empleado");
		reunion.setConvoca(e);
		reunion = servicio.nuevaReunion(reunion);
		m.addAttribute("reunion", reunion);
		m.addAttribute("empleados", servicio.getEmpleados());
		return "seleccionEmpleados";
	}
	
	@RequestMapping("seleccionar")
	public String seleccionar(@RequestParam String[] id, 
			@RequestParam int idReunion, Model m) {
		servicio.añadirEmpleadosReunion(idReunion, id);
		Empleado e = (Empleado) m.getAttribute("empleado");
		m.addAttribute("convoca",servicio.getReunionesConvoca(e.getId()));
		m.addAttribute("participa",servicio.getReunionesParticipa(e.getId()));
		return "empleado";
	}
	
	@RequestMapping("Finalizar")
	public String finalizar(HttpSession sesion, Model modelo) {
		sesion.invalidate();
		modelo.addAttribute("empleados", servicio.getEmpleados());
		return "login";
	}
	
}
