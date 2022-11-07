package net.zabalburu.actividad6.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.zabalburu.actividad6.modelo.Reparacion;
import net.zabalburu.actividad6.modelo.Usuario;
import net.zabalburu.actividad6.service.Servicio;

/**
 * Servlet implementation class Reparaciones
 */
@WebServlet("/reparaciones")
public class Reparaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Servicio servicio = new Servicio();
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reparaciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "";
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		if ((usuario == null && accion != null && !accion.equals("Entrar")) 
			|| accion == null) {
			pagina = "login.jsp";
		} else {
			switch (accion) {
			case "Entrar":
				pagina = login(request,sesion);
				break;
			case "Salir":
				sesion.invalidate();
				pagina = "login.jsp";
				break;
			case "Solicitud":
				pagina = "solicitud.jsp";
				break;
			case "EnviarSolicitud":
				pagina = enviarSolicitud(request,sesion,servicio);
				break;
			case "IrOpciones":
			case "Volver":
				pagina = "opciones.jsp";
				break;
			case "Comprobar":
				pagina = comprobarReparaciones(request,sesion,servicio);
				break;
			case "Reparar":
				request.setAttribute("pendientes", servicio.getReparacionesPendientes());
				pagina = "reparacionesPendientes.jsp";
				break;
			case "Guardar":
				pagina = reparar(request,sesion,servicio);
				break;
			}
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	private String reparar(HttpServletRequest request, HttpSession sesion, Servicio servicio2) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		String[] repNos = request.getParameterValues("repNo");
		String[] strCostes = request.getParameterValues("coste");
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		String error = "";
		for (int i = 0; i < strCostes.length; i++) {
			if (!strCostes[i].isEmpty()) {
				try {
					Number n = (Number) nf.parse(strCostes[i]);
					Double coste = n.doubleValue();
					Integer repNo = Integer.parseInt(repNos[i]);
					servicio.reparar(repNo, usuario.getUsuario(), coste);
				} catch (ParseException ex) {
					error = "No ha sido posible procesar todas las reparaciones debido a que algún coste era erróneo";
					request.setAttribute("error", error);
				}
			}
		}
		request.setAttribute("pendientes", servicio.getReparacionesPendientes());
		return "reparacionesPendientes.jsp";
	}

	private String comprobarReparaciones(HttpServletRequest request, HttpSession sesion, Servicio servicio2) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		request.setAttribute("reparaciones", servicio.getReparacionesUsuario(usuario.getUsuario()));
		return "comprobarReparaciones.jsp";
	}

	private String enviarSolicitud(HttpServletRequest request, HttpSession sesion,
			Servicio servicio) {
		String elemento = request.getParameter("elemento");
		String strFecha = request.getParameter("fechaSolicitud");
		String descripcion = request.getParameter("descripcion");
		List<String> error = new ArrayList<String>();
		Date fecha = null;
		try {
			fecha = df.parse(strFecha);
		} catch (ParseException ex) {} 
		if (fecha == null) {
			error.add("Debe especificarse una fecha de solicitud");
		}
		if (descripcion.isEmpty()) {
			error.add("Debe especificarse la descripción");
		}
		if (!error.isEmpty()) {
			request.setAttribute("errores", error);
			return "solicitud.jsp";
		} else {
			Reparacion r = new Reparacion(0,request.getParameter("usuario"),
					elemento,fecha, descripcion);
			servicio.añadirReparacion(r);
			return "gracias.jsp";
		}
		
	}

	private String login(HttpServletRequest request, HttpSession sesion) {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = "";
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Debe especificar todos los campos";
		} else {
			Usuario usu = servicio.login(usuario, password);
			if (usu == null) {
				error = "Usuario / password erróneos";
			} else {
				sesion.setAttribute("usuario", usu);
			}
		}
		if (error.isEmpty()) {
			return "opciones.jsp";
		} else {
			request.setAttribute("error", error);
			return "login.jsp";
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
