package net.zabalburu.reuniones.controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.reuniones.modelo.Empleado;
import net.zabalburu.reuniones.modelo.Reunion;
import net.zabalburu.reuniones.modelo.ReunionEmpleado;
import net.zabalburu.reuniones.servicio.ReunionesServicio;

@Controller
@SessionAttributes({"empleado"})
public class Controlador {
	@Autowired
	private ReunionesServicio servicio;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("empleados",servicio.getEmpleados());
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Model m,@RequestParam String apellido, 
			@RequestParam String id) {
		Empleado e = servicio.login(apellido, id);
		
		if (e == null) {
			m.addAttribute("error", "Contraseña errónea");
			m.addAttribute("empleados",servicio.getEmpleados());
			return "login";
		} else {
			m.addAttribute("empleado",e);
			return "reuniones";
		}
	}
	
	@RequestMapping("/finalizar")
	public String finalizar(HttpSession sesion, Model m) {
		sesion.invalidate();
		m.addAttribute("empleados",servicio.getEmpleados());
		return "login";
	}
	
	@RequestMapping("/nueva")
	public String nueva(Model m) {
		Reunion r = new Reunion();
		r.setFecha(new Date());
		m.addAttribute("reunion",r);
		return "nueva";
	}
	
	@RequestMapping("/guardar")
	public String guardar(Model m, @Valid @ModelAttribute Reunion reunion,
			BindingResult result) {
		if (result.hasErrors()) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.set(Calendar.HOUR,0);
			gc.set(Calendar.HOUR_OF_DAY,0);
			gc.set(Calendar.MINUTE,0);
			gc.set(Calendar.SECOND,0);
			gc.set(Calendar.MILLISECOND,0);
			if (reunion.getFecha().compareTo(gc.getTime())<0) {
				result.addError(new FieldError("reunion", "fecha", "La fecha no puede ser anterior a hoy"));
			}
			return "nueva";
		}
		reunion.setEmpleado((Empleado) m.getAttribute("empleado"));
		reunion.setParticipantes(new ArrayList<ReunionEmpleado>());
		servicio.nuevaReunion(reunion);
		return "reuniones";
	}
}
