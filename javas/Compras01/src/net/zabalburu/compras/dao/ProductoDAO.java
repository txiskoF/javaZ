package net.zabalburu.compras.dao;

import java.util.ArrayList;
import java.util.List;

import net.zabalburu.compras.modelo.Producto;

public class ProductoDAO {
	//Creo el arraylist
	List<Producto> productos = new ArrayList<Producto>();
	
	//los producos que tendre
	public ProductoDAO() {
		productos.add(new Producto(1,"Producto 01",123.45));
		productos.add(new Producto(2,"Producto 02",200.34));
		productos.add(new Producto(3,"Producto 03",89.54));
		productos.add(new Producto(4,"Producto 04",165.90));
		productos.add(new Producto(5,"Producto 05",98.76));
		productos.add(new Producto(6,"Producto 06",45.5));
	}

	//obtener lista de productos
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	//Obtener producto segun id
	public Producto getProducto(Integer id) {
		//Creo variable de tipo producto
		Producto buscar = new Producto();
		//le doy el id que me pasan
		buscar.setId(id);
		//devuelvo de la lista de productos el que se corresponde al id pasado
		return productos.get(productos.indexOf(buscar));
	}
}
