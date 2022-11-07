package net.zabalburu.actividad8.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.zabalburu.actividad8.dao.ArtistaDAO;
import net.zabalburu.actividad8.modelo.Artista;
import net.zabalburu.actividad8.modelo.Usuario;
import net.zabalburu.actividad8.modelo.UsuarioPista;
import net.zabalburu.actividad8.servicio.ChinookServicio;

/**
 * Servlet implementation class Chinook
 */
@WebServlet("/Chinook")
public class Chinook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ChinookServicio servicio = new ChinookServicio();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chinook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "artistas.jsp";
		String accion = request.getParameter("accion");
		String inicial;
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		request.getServletContext().setAttribute("iniciales", servicio.getInicialesArtistas());
		if (accion == null) {
			pagina = "login.jsp";
		} else if (accion.equals("Entrar")) {
			pagina = entrar(request,sesion);
			
		} else if (accion.equals("irApag")) {
			pagina = irAPag(request);
		} else if (accion.equals("VerArtistas")) {
			pagina = verArtistas(request);
		} else if (accion.equals("VerArtista")){
			pagina = verArtista(request,sesion);
		} else if (accion.equals("anadir")){
			pagina = añadirCarrito(request,sesion);
		} else if (accion.equals("volver")) {
			pagina = "artistas.jsp";
			List<Artista> artistas = servicio.getArtistas("A");
			request.setAttribute("artistas", servicio.getArtistas("A"));
			request.setAttribute("inicial", "A");
			request.setAttribute("pagina", 1);
			request.setAttribute("totPag", artistas.size()  / 5 + ((artistas.size()%5>0)?1:0));
		}else if (accion.equals("verCarrito")) {
			pagina ="carrito.jsp";
		} else if (accion.equals("quitar")){
			pagina = quitarDelCarrito(request,sesion);
		} else if (accion.equals("finCompra")) {
			pagina = finCompra(request,sesion);
		}
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	private String finCompra(HttpServletRequest request, HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		servicio.finalizarCompra(usuario.getId());
		sesion.setAttribute("carrito", new ArrayList<UsuarioPista>());
		List<Artista> artistas = servicio.getArtistas("A");
		request.setAttribute("artistas", servicio.getArtistas("A"));
		request.setAttribute("inicial", "A");
		request.setAttribute("pagina", 1);
		request.setAttribute("totPag", artistas.size()  / 5 + ((artistas.size()%5>0)?1:0));
		request.setAttribute("mensaje", "Su compra se ha realizado con éxito");
		return "artistas.jsp";
	}

	private String quitarDelCarrito(HttpServletRequest request, HttpSession sesion) {
		String[] strIds = request.getParameterValues("id");
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		for(String strId : strIds) {
			Integer id = Integer.parseInt(strId);
			servicio.quitarPista(id);
		}
		sesion.setAttribute("carrito", servicio.getPendientes(user.getId()));
		return "carrito.jsp";
	}

	private String entrar(HttpServletRequest request, HttpSession sesion) {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String error = null;
		Usuario user = null;
		if (usuario.isEmpty() || password.isEmpty()) {
			error = "Deben especificarse todos los datos";
		} else {
			user = servicio.login(usuario, password);
			if (user == null) {
				error = "Usuario / password erróneos";
			}
		}
		if (error !=null) {
			request.setAttribute("error", error);
			return "login.jsp";
		}
		sesion.setAttribute("usuario", user);
		sesion.setAttribute("carrito", servicio.getPendientes(user.getId()));
		String inicial;
		inicial = "A";
		List<Artista> artistas = servicio.getArtistas(inicial);
		request.setAttribute("artistas", artistas);
		request.setAttribute("inicial", inicial);
		request.setAttribute("pagina", 1);
		request.setAttribute("totPag", artistas.size()  / 5 + ((artistas.size()%5>0)?1:0));
		
		return "artistas.jsp";
	}

	private String añadirCarrito(HttpServletRequest request, HttpSession sesion) {
		String[] strIds = request.getParameterValues("id");
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		for(String strId : strIds) {
			Integer id = Integer.parseInt(strId);
			servicio.añadirPista(user.getId(), id);
		}
		sesion.setAttribute("carrito", servicio.getPendientes(user.getId()));
		return "albumes.jsp";
	}

	private String verArtista(HttpServletRequest request, HttpSession sesion) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		sesion.setAttribute("artista", servicio.getArtista(id));
		return "albumes.jsp";
	}

	private String irAPag(HttpServletRequest request) {
		Integer pagina = Integer.parseInt(request.getParameter("pagina"));
		String inicial = request.getParameter("inicial");
		List<Artista> artistas = servicio.getArtistas(inicial);
		request.setAttribute("artistas", artistas);
		request.setAttribute("inicial", inicial);
		request.setAttribute("pagina", pagina);
		request.setAttribute("totPag", artistas.size()  / 5 + ((artistas.size()%5>0)?1:0));
		return "artistas.jsp";
	}

	private String verArtistas(HttpServletRequest request) {
		String inicial = request.getParameter("inicial");
		List<Artista> artistas = servicio.getArtistas(inicial);
		request.setAttribute("artistas", artistas);
		request.setAttribute("inicial", inicial);
		request.setAttribute("pagina", 1);
		request.setAttribute("totPag", artistas.size()  / 5 + ((artistas.size()%5>0)?1:0));
		return "artistas.jsp";
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
