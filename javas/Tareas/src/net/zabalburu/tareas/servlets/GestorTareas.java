package net.zabalburu.tareas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.tareas.modelo.Empleado;
import net.zabalburu.tareas.modelo.Tarea;
import net.zabalburu.tareas.servicio.TareasServicio;

/**
 * Servlet implementation class GestorTareas
 */
@WebServlet("/GestorTareas")
public class GestorTareas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TareasServicio servicio;
    private Empleado e;
    private DateFormat df = DateFormat.getDateInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestorTareas() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		servicio = new TareasServicio();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		mostrarFormulario(response,"");
		
	}

	private void mostrarFormulario(HttpServletResponse response, String error) throws IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		out.println("<!doctype html>\r\n" + 
				"<html lang=\"es\">\r\n" + 
				"  <head>\r\n" + 
				"    <!-- Required meta tags -->\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"\r\n" + 
				"    <!-- Bootstrap CSS -->\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"    <title>Gestor de Tareas</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n");
		
		out.println("<div class='container'>");
		out.println("<div class='row mt-5'>");
		out.println("<div class='col-3'></div>");
		out.println("<div class='col-6'>");
		out.println("<form action='GestorTareas' method='POST'>\r\n" + 
				"  <div class=\"form-group\">\r\n" + 
				"    <label for=\"usuario\">Usuario (email)</label>\r\n" + 
				"    <input type=\"email\" class=\"form-control\" id=\"usuario\" name='usuario' aria-describedby=\"emailHelp\">\r\n" + 
				"  </div>\r\n" + 
				"  <div class=\"form-group\">\r\n" + 
				"    <label for=\"pwd\">Password</label>\r\n" + 
				"    <input type=\"password\" class=\"form-control\" id=\"pwd\" name='password'>\r\n" + 
				"  </div>\r\n" + 
				"  <button type=\"submit\" class=\"btn btn-primary\">Enviar</button>\r\n" + 
				"</form>");
		if (!error.isEmpty()) {
			out.println("<div class='alert alert-danger mt-3'>" + error + "</div>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println( 
				"    <!-- Optional JavaScript -->\r\n" + 
				"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n" + 
				"    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("usuario");
		if (usuario != null) {
			String password = request.getParameter("password");
			if (usuario.isEmpty() || password.isEmpty()) {
				mostrarFormulario(response, "Usuario / contraseña no pueden estar vacíos");
			} else {
				e = servicio.login(usuario, password);
				if (e == null) {
					mostrarFormulario(response, "Usuario / contraseña erróneos");
				} else {
					mostrarTareas(response);
				}
			}
		} else {
			// Añadir Tarea
		}
	}


	private void mostrarTareas(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;UTF-8");
		out.println("<!doctype html>\r\n" + 
				"<html lang=\"es\">\r\n" + 
				"  <head>\r\n" + 
				"    <!-- Required meta tags -->\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"\r\n" + 
				"    <!-- Bootstrap CSS -->\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n" + 
				"\r\n" + 
				"    <title>Listado de Tareas</title>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n");
		out.println("<div class='container'>");
		out.println("<div class='row mt-1'>");
		out.println("<div class='col-3'></div>");
		out.println("<div class='col-6'>");
		out.println("<h1>Tareas de " + e.getApellidos() + ", " +
				e.getNombre() + "</h1>");
		List<Tarea> tareas = servicio.getTareasEmpleado(e);
		if (tareas.isEmpty()) {
			out.println("<div class='alert alert-info mt-3'>No hay tareas asignadas</div>");
		} else {
			out.println("<table class=\"table\">\r\n" + 
					"  <thead>\r\n" + 
					"    <tr>\r\n" + 
					"      <th scope=\"col\">#</th>\r\n" + 
					"      <th scope=\"col\">Descripción</th>\r\n" + 
					"      <th scope=\"col\">Fecha</th>\r\n" + 
					"    </tr>\r\n" + 
					"  </thead>\r\n" + 
					"  <tbody>\r\n");
			for(Tarea t : tareas) {
				out.println("<tr>\r\n" + 
					"      <th scope=\"row\">" + t.getId() + "</th>\r\n" + 
					"      <td>" + t.getDescripcion() + "</td>\r\n" + 
					"      <td>" + df.format(t.getFecha()) +"</td>\r\n" + 
					"    </tr>\r\n");
			}
			out.println("  </tbody>\r\n" + 
					"</table>");
		}
		
		// Añadir formulario Nueva Tarea
		// Select descripciones getTareasDisponibles(null)
		// Input Date para la fecha
		
		out.println("  <a href='GestorTareas' class='btn btn-primary'>Volver</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println( 
				"    <!-- Optional JavaScript -->\r\n" + 
				"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\r\n" + 
				"    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\" integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\"></script>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
	}

}
