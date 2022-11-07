package net.zabalburu.compras.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.zabalburu.compras.modelo.Usuario;
import net.zabalburu.compras.servicio.ServicioCompras;

/**
 * Servlet implementation class Compras
 */
@WebServlet("/Compras")
public class Compras extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compras() {
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
		/*ServicioCompras servicio;
		if (sesion.isNew()) {
			servicio = new ServicioCompras();
			sesion.setAttribute("servicio", servicio);
		} else {
			servicio = (ServicioCompras) sesion.getAttribute("servicio");
		}*/
		
		//
		ServicioCompras servicio = (ServicioCompras) sesion.getAttribute("servicio");
		//si no hay servicio lo creo y guardo en la sesion
		if (servicio == null) {
			servicio = new ServicioCompras();
			sesion.setAttribute("servicio", servicio);
		}
		//si accion null es la 1ª vez y voy a login
		if (accion == null) {
			 pagina = "login.jsp";
		} else {
			switch (accion) {
			// si accion es entrar
			case "Entrar":
				pagina = login(request,sesion,servicio);
				break;
				//Si SE HA ENTRADO SE VA A VER LA LISTA DE PRODUCTOS
			case "Comprar":
				pagina = comprar(request,sesion,servicio);
				break;
				//Si accion es VerCarrito
			case "VerCarrito":
				pagina = verCarrito(request,sesion,servicio);
				break;
			}
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	//Voy a la pagina verCarrito
	private String verCarrito(HttpServletRequest request, HttpSession sesion, ServicioCompras servicio) {
		return "verCarrito.jsp";
	}
	

	private String comprar(HttpServletRequest request, HttpSession sesion, ServicioCompras servicio) {
		//DE LA REQUEST COJO LOS ID Y GUARDO EN UN ARRAY
		String[] ids = request.getParameterValues("id");
		//DE LA REQEST COJO LAS UNIDADES Y GUARDO EN UN ARRAY
		String[] unidades = request.getParameterValues("unidades");
		//RECORRO EL ARRAY DE UNIDADES
		for (int i = 0; i < unidades.length; i++) {
			//SI UNIDADES NO ESTA VACIO
			if (!unidades[i].isEmpty()) {
				//COJO EL NUMERO DE UNIDADES Y LO GUARDO EN UNID
				int unid = Integer.parseInt(unidades[i]);
				//ENTONCES DEL ARRAY IDS COJO EL VALOR Y LO GUARDO EN ID
				int id = Integer.parseInt(ids[i]);
				
				//LLAMO A AÑADIRPRODUCTO DEL SERCICIO Y ASI AÑADIR UN PRODUCTO (AÑADIRDETALLE ) A LA LISTA
				servicio.añadirProducto(id, unid);
			}
		}
		return "listaProductos.jsp";
	}

	private String login(HttpServletRequest request, HttpSession sesion,
			ServicioCompras servicio) {
		//RECOJO EL USUARIO LA PASSWORD Y EL ERROR
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = "";
		Usuario user = null;
		//SI FALTAN DATOS
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Deben especificarse todos los campos";
			//DI NO FALTAN DATOS PERO NO SON CORRECTOS
		} else {
			user = servicio.login(usuario, password);
			if (user == null) {
				error = "Usuario / password erróneos";
			}
		}
		//SI NO HAY ERROR SE GUARDA EL USARIO EN LA SESION Y SE VA AL LISTADO DE PRODUCTOS
		if (error.isEmpty()) {
			sesion.setAttribute("usuario", user);
			return "listaProductos.jsp";
		}
		request.setAttribute("error", error);
		return "login.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
