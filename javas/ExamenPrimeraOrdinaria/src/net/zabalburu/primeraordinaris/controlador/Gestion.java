package net.zabalburu.primeraordinaris.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.zabalburu.primeraordinaris.modelo.Concepto;
import net.zabalburu.primeraordinaris.modelo.Operacion;
import net.zabalburu.primeraordinaris.modelo.Usuario;
import net.zabalburu.primeraordinaris.servicio.ServicioEJB;

/**
 * Servlet implementation class Gestion
 */
@WebServlet("/Gestion")
public class Gestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
	@EJB
	private ServicioEJB servicio;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "";
		HttpSession sesion = request.getSession();
		String accion = request.getParameter("accion");
		if (accion == null) {
			pagina = "login.jsp";
		} else if (accion.equals("Acceder")) {
			pagina = acceder(request,sesion);
		} else if (accion.equals("Guardar")) {
			pagina = guardar(request,sesion);
		} else if (accion.equals("Volver")) {
			sesion.invalidate();
			pagina = "login.jsp";
		} else if (accion.equals("GuardarConcepto")) {
			pagina = guardarConcepto(request,sesion);
		} else if (accion.equals("Nuevo Concepto")){
			pagina="nuevoConcepto.jsp";
		} else if (accion.equals("VolverConcepto")){
			request.setAttribute("conceptos", servicio.getConceptos());
			request.setAttribute("hoy", df.format(new Date()));
			pagina="operaciones.jsp";
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	private String guardarConcepto(HttpServletRequest request, HttpSession sesion) {
		String descripcion = request.getParameter("descripcion");
		String tipo = request.getParameter("tipo");
		if (descripcion.isEmpty()) {
			request.setAttribute("error", "Debe especificarse la descripción");
			return "nuevoConcepto.jsp";
		}
		Concepto c = new Concepto();
		c.setDescripcion(descripcion);
		c.setTipo(tipo);
		servicio.nuevoConcepto(c);
		request.setAttribute("conceptos", servicio.getConceptos());
		request.setAttribute("hoy", df.format(new Date()));
		return "operaciones.jsp";
	}

	private String guardar(HttpServletRequest request, HttpSession sesion) {
		String strImporte = request.getParameter("importe");
		Integer concepto = Integer.parseInt(request.getParameter("concepto"));
		String strFecha = request.getParameter("fecha");
		String comentarios = request.getParameter("comentarios");
		double importe = 0;
		String error = null;
		try {
			Number n = (Number) nf.parse(strImporte);
			importe = n.doubleValue();
			if (importe <= 0) {
				error = "El importe debe ser MAYOR que 0";
			}
		} catch (ParseException ex ) {
			error ="El importe debe ser un valor numérico con decimales";
		}
		if (error != null) {
			request.setAttribute("error", error);
		} else {
			Operacion o = new Operacion();
			Date fecha;
			try {
				fecha = df.parse(strFecha);
			} catch (ParseException ex) {
				fecha = new Date();
			}
			o.setComentarios(comentarios);
			
			o.setConcepto(servicio.getConcepto(concepto));
			o.setImporte(importe);
			o.setFecha(fecha);
			Usuario usuario = (Usuario) sesion.getAttribute("usuario"); 
			o.setUsuario(usuario);
			servicio.nuevaOperacion(o);
			sesion.setAttribute("usuario", servicio.getUsuario(usuario.getId()));
		}
		request.setAttribute("conceptos", servicio.getConceptos());
		request.setAttribute("hoy", df.format(new Date()));
		return "operaciones.jsp";
	}

	private String acceder(HttpServletRequest request, HttpSession sesion) {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = null;
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Debe especificar todos los campos";
		} else {
			Usuario u = servicio.login(usuario, password);
			if (u == null) {
				error = "Usuario / password erróneos";
			} else {
				sesion.setAttribute("usuario", u);
			}
		}
		if (error == null) {
			request.setAttribute("conceptos", servicio.getConceptos());
			request.setAttribute("hoy", df.format(new Date()));
			return "operaciones.jsp";
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
