package net.zabalburu.springdi.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.zabalburu.springdi.config.BeanConfiguration;
import net.zabalburu.springdi.dao.ProductoDAO;
import net.zabalburu.springdi.modelo.Producto;
import net.zabalburu.springdi.servicio.ProductoServicio;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.registerBean(BeanConfiguration.class);
		ctx.refresh();
		System.out.println("Creado el Contexto de Aplicación");
		System.out.println("=================================");
		ProductoServicio servicio = (ProductoServicio) ctx.getBean(ProductoServicio.class);
		//ProductoDAO servicio = (ProductoDAO) ctx.getBean("servicio");
		for(Producto p : servicio.getProductos()) {
			System.out.println(p);
		}
		/*servicio.nuevoProducto(new Producto(null,"Producto Nuevo",245.89,
				servicio.getCategoria(1)));*/
		System.out.println(servicio.getProducto(8));
		ctx.close();
	}

}
