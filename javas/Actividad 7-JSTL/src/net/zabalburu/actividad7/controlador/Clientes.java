package net.zabalburu.actividad7.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.zabalburu.actividad7.modelo.Cliente;
import net.zabalburu.actividad7.servicio.ClientesServicio;

/**
 * Servlet implementation class Clientes
 */
@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//DELCARO ESTO PARA LA PAGINACION
    private int paginaActual = 1;
	private ClientesServicio servicio = new ClientesServicio();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "clientes.jsp";
		String accion = request.getParameter("accion");
		if (accion == null) {
			request.setAttribute("clientes", servicio.getClientes());
			//AL ENTRAR PASO LAPAGINA 1
			request.setAttribute("pagina", 1);
		} else if (accion.equals("VerPedidos")) {
			String id = request.getParameter("id");
			Cliente c = servicio.getCliente(id);
			request.setAttribute("cliente",c);
			pagina = "pedidos.jsp";
		}else if (accion.equals("IrA")) {
			request.setAttribute("clientes", servicio.getClientes());
			request.setAttribute("pagina", Integer.parseInt(request.getParameter("pag")));
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
