package net.zabalburu.discos.controlador;

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

import net.zabalburu.discos.modelo.Album;
import net.zabalburu.discos.modelo.Cliente;
import net.zabalburu.discos.modelo.Pedido;
import net.zabalburu.discos.servicio.ServicioEJB;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private NumberFormat nf = NumberFormat.getInstance();
    
	@EJB
	private ServicioEJB servicio;
       
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
		String pagina = "";
		HttpSession sesion = request.getSession();
		String accion = request.getParameter("accion");
		if (accion == null) {
			//necesario para tener la lista al comenzar
			request.setAttribute("clientes", servicio.getClientes());
			pagina = "login.jsp";
		}  else if (accion.equals("Entrar")) {
			pagina = entrar(request,sesion);
		} else  if (accion.equals("Salir")) {
			sesion.invalidate();
			pagina = "login.jsp";
		} else  if (accion.equals("Pedir")) {
			pagina = confirmar(request,sesion);
		} else  if (accion.equals("Cancelar")) {
			pagina = cancelar(request,sesion);
		}  else  if (accion.equals("Comprar")) {
			pagina = comprar(request,sesion);
		}  else  if (accion.equals("Eliminar")) {
			pagina = eliminar(request,sesion);
		} 
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	//para eiminar un album
	private String eliminar(HttpServletRequest request, HttpSession sesion) {
		//me llega el id
		String idPedido = request.getParameter("idPedido");
		//lo convierto a integer
        Integer id = new Integer(idPedido);
        //llamo al servicio
		servicio.eliminarPedido(id);
		//llamo a cancelar que hace un volver
		return cancelar(request, sesion);
	}

	private String comprar(HttpServletRequest request, HttpSession sesion)  {
		String idAlbum = request.getParameter("idAlbum");
        String fechaStr = request.getParameter("fecha");
        
        //convertir una FECHA STRING en date
        Date fecha = null;
		try {
			fecha = df.parse(fechaStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//de la sesion cojo el cliente
        Cliente c = (Cliente) sesion.getAttribute("cliente");
        Integer id = new Integer(idAlbum);
        //creo un objeto Album y le asigno el id
        Album a = new Album();
        a.setId(id);
        //creo un objeto pedido
		Pedido p = new Pedido();
		//le asigno los valores necesarios
		p.setCliente(c);
		p.setAlbum(a);
		p.setFechaPedido(fecha);
		p.setPagado(1);
		//llamo a este metodo y le paso un p
		//para guardar el pedido
		servicio.nuevoPedido(p);
		//llamo a cancelar para volver a la pagna anterior
		return cancelar(request, sesion);
	}

	//el metodo cancelar loque hace es volver
	private String cancelar(HttpServletRequest request, HttpSession sesion) {
		request.setAttribute("albumes", servicio.getAlbumes());
		Cliente c = (Cliente) sesion.getAttribute("cliente");
		request.setAttribute("pedidos", servicio.getPedidos(c.getId()));
		request.setAttribute("hoy", df.format(new Date()));
		return "pedidos.jsp";
	}

	//esto sirve para confirmar que quiero cormprar
	private String confirmar(HttpServletRequest request, HttpSession sesion) {
		String strId = request.getParameter("id");
		Integer id = new Integer(strId);
		//mediante el id obtengoun album completo
		Album album = servicio.getAlbum(id);
		request.setAttribute("album", album);
		request.setAttribute("hoy", df.format(new Date()));
		return "confirmar.jsp";
	}

	private String entrar(HttpServletRequest request, HttpSession sesion) {
				String idCli = request.getParameter("id");
				//convertir el String en Integer
				Integer id= new Integer(idCli);
				String password = request.getParameter("password");
				String error = null;
				if ( password.isEmpty()) {
					error = "Debe especificar todos los campos";
					request.setAttribute("clientes", servicio.getClientes());
				} else {
					Cliente c = servicio.login(id, password);
					if (c == null) {
						error = "Usuario / password erróneos";
						request.setAttribute("clientes", servicio.getClientes());
					} else {
						sesion.setAttribute("cliente", c);
					}
				}
				if (error == null) {
					
					//todo esto para usar segun loguee
					request.setAttribute("pedidos", servicio.getPedidos(id));
					request.setAttribute("albumes", servicio.getAlbumes());
					request.setAttribute("hoy", df.format(new Date()));
					return "pedidos.jsp";
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
