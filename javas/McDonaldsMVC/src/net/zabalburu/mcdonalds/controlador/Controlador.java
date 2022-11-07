package net.zabalburu.mcdonalds.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.mcdonalds.modelo.Producto;
import net.zabalburu.mcdonalds.servicio.Servicio;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Servicio servicio = new Servicio();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enviar = request.getParameter("Enviar");
		String[] ids = request.getParameterValues("id");
		if (enviar == null) {
			request.getRequestDispatcher("ListaProductos.jsp").forward(request, response);
		} else {
			if (ids == null) {
				request.setAttribute("error", "Debe seleccionar algún producto");
				request.getRequestDispatcher("ListaProductos.jsp").forward(request, response);
			} else {
				mostrar(request, response);
				request.getRequestDispatcher("MostrarMenu.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) {
		String[] ids = request.getParameterValues("id");
		List<Producto> productos = servicio.getProductos();
		List<Producto> seleccionados = new ArrayList<Producto>();
		for(String strId : ids) {
			Integer id = Integer.parseInt(strId);
			seleccionados.add(productos.get(id));
		}
		request.setAttribute("seleccionados", seleccionados);
	}

}
