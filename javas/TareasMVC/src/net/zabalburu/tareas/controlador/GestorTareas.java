package net.zabalburu.tareas.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.tareas.modelo.Empleado;
import net.zabalburu.tareas.servicio.TareasServicio;

/**
 * Servlet implementation class GestorTareas
 */
@WebServlet("/GestorTareas")
public class GestorTareas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TareasServicio servicio = new TareasServicio();
	private Empleado empleado;
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestorTareas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pagina = "";
		String accion = request.getParameter("accion");
		if (accion == null) {
			pagina = "login.jsp";
		} else {
			switch (accion) {
				case "Entrar": {
					pagina = entrar(request, response);
					break;
				}
				case "Añadir": {
					pagina = añadir(request, response);
					break;
				}
				case "Borrar": {
					pagina = borrarTarea(request,response);
					break;
				}
			
			}

		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	private String borrarTarea(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		servicio.borrarTarea(id);
		request.setAttribute("empleado", empleado);
		request.setAttribute("tareas", servicio.getTareasEmpleado(empleado));
		return "ListaTareas.jsp";
	}

	private String añadir(HttpServletRequest request, HttpServletResponse response) {
		String descripcion = request.getParameter("descripcion");
		String strFecha = request.getParameter("fecha");
		String error ="";
		if (descripcion.isEmpty() || strFecha.isEmpty()) {
			error = "Faltan datos obligatorios";
		} 
		if (!error.isEmpty()) {
			request.setAttribute("error", error);
		} else {
			Date fecha;
			try {
				fecha = df.parse(strFecha);
			} catch (ParseException e) {
				fecha = new Date();
			}
			servicio.nuevaTarea(empleado.getId(), descripcion, fecha);
		}
		request.setAttribute("empleado", empleado);
		request.setAttribute("tareas", servicio.getTareasEmpleado(empleado));
		return "ListaTareas.jsp";
	}

	private String entrar(HttpServletRequest request, HttpServletResponse response) {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = "";
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Faltan datos obligatorios";
		}else {
			empleado = servicio.login(usuario, password);
			if (empleado == null) {
				error = "Usuario / password erróneos";
			} 
		}
		if (error.isEmpty()) {
			request.setAttribute("empleado", empleado);
			request.setAttribute("tareas", servicio.getTareasEmpleado(empleado));
			return "ListaTareas.jsp";
		} else {
			request.setAttribute("error", error);
			return "login.jsp";
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
