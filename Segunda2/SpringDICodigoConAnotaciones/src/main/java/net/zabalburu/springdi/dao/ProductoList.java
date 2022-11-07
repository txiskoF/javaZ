package net.zabalburu.springdi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.zabalburu.springdi.modelo.Categoria;
import net.zabalburu.springdi.modelo.Producto;

@Repository("productoList")
public class ProductoList implements ProductoDAO {
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Categoria> categorias = new ArrayList<Categoria>();
	public ProductoList() {
		System.out.println("Instanciando ProductoList");
		this.categorias.add(new Categoria(1,"Categoría 1"));
		this.categorias.add(new Categoria(2,"Categoría 3"));
		this.categorias.add(new Categoria(3,"Categoría 3"));
		this.productos.add(new Producto(1,"Producto 1",123.78,this.categorias.get(0)));
		this.productos.add(new Producto(2,"Producto 2",235.8,this.categorias.get(1)));
		this.productos.add(new Producto(3,"Producto 3",92.56,this.categorias.get(0)));
		this.productos.add(new Producto(4,"Producto 4",25.45,this.categorias.get(1)));
		this.productos.add(new Producto(5,"Producto 5",90.56,this.categorias.get(0)));
		this.productos.add(new Producto(6,"Producto 6",18.52,this.categorias.get(2)));
		this.productos.add(new Producto(7,"Producto 7",130.76,this.categorias.get(2)));
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public Producto getProducto(Integer id) {
		Producto p = new Producto();
		p.setId(id);
		int pos = this.productos.indexOf(p);
		return (pos==-1)?null:productos.get(pos);
	}

	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public Categoria getCategoria(Integer id) {
		Categoria c = new Categoria();
		c.setId(id);
		int pos = this.categorias.indexOf(c);
		return (pos==-1)?null:categorias.get(pos);
	}

	public void nuevoProducto(Producto p) {
		Integer id = 1;
		if (this.productos.size()>0) {
			id = this.productos.get(this.productos.size()-1).getId()+1;
		}
		p.setId(id);
		this.productos.add(p);
	}

	public void eliminarProducto(Integer id) {
		Producto p = new Producto();
		p.setId(id);this.productos.remove(p);
	}

}
