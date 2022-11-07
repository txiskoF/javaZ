package net.zabalburu.tareas.controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.zabalburu.tareas.modelo.Tarea;
import net.zabalburu.tareas.modelo.Usuario;
import net.zabalburu.tareas.servicio.TareasServicio;

@Controller
@SessionAttributes({"usuario"})
public class TareasControlador {
	@Autowired
	private TareasServicio servicio;
	
	//AL INICIAR VOY AL LOGIN
	@RequestMapping("/")
	public String inicio() {
		System.out.println("login");
		return "login";
	}
	
	//EN EL LOGIN
	@RequestMapping("/login")
	public String login(@RequestParam String usuario, @RequestParam String password,
			Model modelo) {
		List<String> error = new ArrayList<String>();
		Usuario u = null;
		if (usuario.isEmpty()) {
			error.add("Debe expecificarse el usuario");
		} if (password.isEmpty()) {
			error.add("Debe expecificarse la contraseña");
		}
		if (error.isEmpty()) {
			u = servicio.login(usuario, password);
			if (u == null) {
				error.add("Usuario / password erróneos");
			}
		}
		if (error.isEmpty()) {
			//METO EN EL MODELO EL USUARIO
			modelo.addAttribute("usuario",u);
			//DE ESE USUARIO COJO SUS TAREAS
			modelo.addAttribute("tareas", servicio.getTareas(u.getId()));
			//PARA PINTAR UNA TAREA VACIA
			Tarea t = new Tarea();
			t.setFecha(new Date());
			modelo.addAttribute("tarea", t);
			return "tareas";
		} else {
			//SI AHY ERRORES VUELVO AL LOGIN
			modelo.addAttribute("errores",error);
			return "login";
		}
	}
	
	@RequestMapping("/Salir")
	public String salir(HttpSession sesion) {
		sesion.invalidate();
		return "login";
	}
	
	
	@RequestMapping("/Finalizar")
	public String finalizarTarea(@RequestParam Integer idTarea, Model modelo) {
		//DEL MODELO COJO EL USUARIO
		Usuario u =(Usuario) modelo.getAttribute("usuario");
		//LLAMO A ESTE METODO Y LE PASO PARAMETROS
		servicio.finalizarTarea(u, idTarea);
		//VUELVO A COGER LA TAREAS Y METERLAS EN EL SERVICIO
		modelo.addAttribute("tareas", servicio.getTareas(u.getId()));
		//PINTO UNA TAREA VACIA
		Tarea t =  new Tarea();
		t.setFecha(new Date());
		modelo.addAttribute("tarea", t);
		return "tareas";
	}
	
	@RequestMapping("/Eliminar")
	public String eliminarTarea(@RequestParam Integer idTarea, Model modelo) {
		//DEL MODELO COJO EL USUARIO
		Usuario u =(Usuario) modelo.getAttribute("usuario");
		//LLAMO A ELIMINAR TAREA
		servicio.eliminarTarea(u, idTarea);
		//VUELVO AMETER EN EL MODELO LAS TAREAS COMO QUEAN
		modelo.addAttribute("tareas", servicio.getTareas(u.getId()));
		//PINTO UNA TAREA VACIA
		Tarea t =  new Tarea();
		t.setFecha(new Date());
		modelo.addAttribute("tarea",t);
		return "tareas";
	}
	
	
	@RequestMapping("/nueva")
	public String nuevaTarea(@ModelAttribute @Valid Tarea tarea,
			BindingResult result, Model modelo) {
		//DEL MODELO COJO EL USUARIO
		Usuario u =(Usuario) modelo.getAttribute("usuario");
		//SI HAY ERRORES CONTINUO EN EL FORMULARIO
		if (result.hasErrors()) {
			modelo.addAttribute("tareas", servicio.getTareas(u.getId()));
			return "tareas";
		}
		System.out.println(tarea);
		//LLAMO AL SERVICIO Y PASO LA TAREA
		servicio.nuevaTarea(u, tarea);
		//METO EN EL MODELO COMO QUEDAN LAS TAREAS
		modelo.addAttribute("tareas", servicio.getTareas(u.getId()));
		//PINTO UNA TAREA VACIA
		Tarea t =  new Tarea();
		t.setFecha(new Date());
		modelo.addAttribute("tarea",t);
		return "tareas";
	}
}
