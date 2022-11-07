package net.zabalburu.jpa.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.jpa.dao.AutorDAO;
import net.zabalburu.jpa.modelo.Autor;

/**
 * Servlet implementation class Autores
 */
@WebServlet("/Autores")
public class Autores extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private AutorDAO servicio = new AutorDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "autores.jsp";
		String accion = request.getParameter("accion");
		if (accion == null) {
			request.setAttribute("autores", servicio.getAutores());
		} else {
			if (accion.equals("VerLibros")) {
				String id = request.getParameter("id");
				Autor autor = servicio.getAutor(id);
				request.setAttribute("autor", autor);
				pagina = "libros.jsp";
			} else if (accion.equals("Volver")) {
				request.setAttribute("autores", servicio.getAutores());
				pagina = "autores.jsp";
			}
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
