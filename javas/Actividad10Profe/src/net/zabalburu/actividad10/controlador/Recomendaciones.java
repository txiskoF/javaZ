package net.zabalburu.actividad10.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.zabalburu.actividad10.modelo.Empleado;
import net.zabalburu.actividad10.servicio.RecomendacionEmpresaEJB;
import net.zabalburu.actividad10.servicio.ServicioEJB;

/**
 * Servlet implementation class Recomendaciones
 */
@WebServlet("/Recomendaciones")
public class Recomendaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private RecomendacionEmpresaEJB recomendaciones;
    
    @EJB
    private ServicioEJB servicio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recomendaciones() {
        super();
        
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "";
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		if (accion == null) {
			request.setAttribute("empleados", servicio.getEmpleados());
			pagina = "login.jsp";
		} else if (accion.equals("Entrar")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("password");
			Empleado e = servicio.getEmpleado(id);
			if (e.getId().equals(pwd)) {
				sesion.setAttribute("empleado", e);
				pagina = "libros.jsp";
			} else {
				request.setAttribute("error", "Contraseña errónea");
				request.setAttribute("empleados", servicio.getEmpleados());
				pagina = "login.jsp";
			}
		} else if (accion.equals("VerTodos")) {
			request.setAttribute("libros", servicio.getLibros());
			pagina = "todos.jsp";
		} else if (accion.equals("Anhadir")){
			pagina = añadir(request, sesion);
		} else if (accion.equals("VerRecomendaciones")){
			pagina = verRecomendaciones(request, sesion);
		} else if (accion.contentEquals("Volver")) {
			pagina = "libros.jsp";
		} else if (accion.equals("Recomendar")) {
			pagina = recomendar(request, sesion);
		} else if (accion.equals("Quitar")) {
			pagina = quitar(request, sesion);
		} else if (accion.equals("Salir")) {
			sesion.invalidate();
			request.setAttribute("empleados", servicio.getEmpleados());
			pagina = "login.jsp";
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	private String quitar(HttpServletRequest request, HttpSession sesion) {
		String[] ids = request.getParameterValues("id");
		Empleado e = (Empleado) sesion.getAttribute("empleado");
		for(String id : ids) {
			servicio.quitarLibroListLectura(e.getId(), id);			
		}
		e = servicio.getEmpleado(e.getId());
		sesion.setAttribute("empleado", e);
		return "libros.jsp";
	}


	private String recomendar(HttpServletRequest request, HttpSession sesion) {
		String[] ids = request.getParameterValues("id");
		Empleado e = (Empleado) sesion.getAttribute("empleado");
		for(String id : ids) {
			recomendaciones.añadirRecomendado(e.getId(), id);			
		}
		e = servicio.getEmpleado(e.getId());
		sesion.setAttribute("empleado", e);
		request.setAttribute("libros", recomendaciones.getRecomendados());
		return "recomendados.jsp";
	}


	private String verRecomendaciones(HttpServletRequest request, HttpSession sesion) {
		request.setAttribute("libros", recomendaciones.getRecomendados());
		return "recomendados.jsp";
	}


	private String añadir(HttpServletRequest request, HttpSession sesion) {
		String[] ids = request.getParameterValues("id");
		Empleado e = (Empleado) sesion.getAttribute("empleado");
		for(String id : ids) {
			servicio.añadirLibroListLectura(e.getId(), id);			
		}
		e = servicio.getEmpleado(e.getId());
		sesion.setAttribute("empleado", e);
		return "libros.jsp";
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
