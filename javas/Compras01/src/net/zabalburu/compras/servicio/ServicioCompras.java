package net.zabalburu.compras.servicio;

import java.util.List;

import net.zabalburu.compras.dao.ProductoDAO;
import net.zabalburu.compras.dao.UsuarioDAO;
import net.zabalburu.compras.modelo.Carrito;
import net.zabalburu.compras.modelo.DetalleCarrito;
import net.zabalburu.compras.modelo.Producto;
import net.zabalburu.compras.modelo.Usuario;

public class ServicioCompras {
	private ProductoDAO productoDAO = new ProductoDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Carrito carrito = new Carrito();
	
	public ServicioCompras() {
		// TODO Auto-generated constructor stub
	}
	
	//Obtener Carrito
	public Carrito getCarrito() {
		return carrito;
	}
	
	//El usuario y password pasan por parametros
	public Usuario login(String usuario, String password) {
		//Variable de tipo Ususario el usuario pasado y contrase�a
		Usuario usu = usuarioDAO.getUsuario(usuario);
		//no coincie la contrase�a
		if (usu != null && !usu.getPassword().equals(password)) {
			usu = null;
		}
		return usu;
	}
	
	//Obtener la lista de productos
	public List<Producto> getProductos(){
		return productoDAO.getProductos();
	}
	
	//El idproducto y la cantidad
	public void a�adirProducto(Integer idProducto, int cantidad) {
		//Un nuevo detalleCarrito
		DetalleCarrito dc = new DetalleCarrito();
		//al dc le a�ado la cantidad
		dc.setCantidad(cantidad);
		//con el idProducto obtengo el Producto y se lo a�ado al dc
		dc.setProducto(productoDAO.getProducto(idProducto));
		//a�adir este producto al carrito
		carrito.a�adirDetalle(dc);
	}

	public void quitarProducto(Integer idProducto, int cantidad) {
		DetalleCarrito dc = new DetalleCarrito();
		dc.setCantidad(cantidad);
		dc.setProducto(productoDAO.getProducto(idProducto));
		carrito.quitarDetalle(dc);
	}
	
	public static void main(String[] args) {
		ServicioCompras servicio = new ServicioCompras();
		for(Producto p : servicio.getProductos()) {
			System.out.println(p);
		}
		System.out.println(servicio.login("juan","12345"));
		System.out.println(servicio.login("jlopez","12345"));
		servicio.a�adirProducto(1, 3);
		servicio.a�adirProducto(2, 5);
		servicio.a�adirProducto(3, 4);
		System.out.println(servicio.getCarrito().getDetalles());
		servicio.quitarProducto(3, 4);
		System.out.println(servicio.getCarrito().getDetalles());
	}
	
}
