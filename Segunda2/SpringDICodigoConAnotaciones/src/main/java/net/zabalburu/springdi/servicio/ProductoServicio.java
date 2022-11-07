package net.zabalburu.springdi.servicio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import net.zabalburu.springdi.dao.ProductoDAO;
import net.zabalburu.springdi.modelo.Categoria;
import net.zabalburu.springdi.modelo.Producto;

@Service
@Scope("singleton")
@Lazy(true)
public class ProductoServicio { // implements InitializingBean, DisposableBean{
	@Autowired
	@Qualifier("productoList")
	private ProductoDAO dao;
	
	public ProductoServicio() {
		System.out.println("Instanciando Servicio");
	}

	public ProductoServicio(ProductoDAO dao) {
		super();
		this.dao = dao;
	}

	public ProductoDAO getDao() {
		return dao;
	}

	public void setDao(ProductoDAO dao) {
		this.dao = dao;
	}

	public List<Producto> getProductos() {
		return this.dao.getProductos();
	}

	public Producto getProducto(Integer id) {
		// TODO Auto-generated method stub
		return dao.getProducto(id);
	}

	public List<Categoria> getCategorias() {
		// TODO Auto-generated method stub
		return dao.getCategorias();
	}

	public Categoria getCategoria(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCategoria(id);
	}

	public void nuevoProducto(Producto p) {
		// TODO Auto-generated method stub
		dao.nuevoProducto(p);
	}

	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		dao.eliminarProducto(id);
	}

/*	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Eliminamos el servicio");
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Después de creado el servicio");
	}*/
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Después de creado el servicio");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Antes de eliminar el servicio");
	}

}
