package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.Producto;
import service.ProductoService;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//ProductoService servicio = (ProductoService) ctx.getBean("productoServicio");
		ProductoService servicio = (ProductoService) ctx.getBean("productoServicio.class");
		servicio.nuevoProducto(new Producto(1,"Primer Producto"));
		servicio.nuevoProducto(new Producto(2,"Segundo Producto"));
		servicio.nuevoProducto(new Producto(3,"Tercer Producto"));
		servicio.nuevoProducto(new Producto(4,"Cuarto Producto"));	
		for(Producto p : servicio.getProductos()) {
			System.out.println(p);
		}
		((ClassPathXmlApplicationContext) ctx).close();
	
	}

}
