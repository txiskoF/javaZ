package net.zabalburu.productosrest.modelo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.productosrest.modelo.Categoria;
import net.zabalburu.productosrest.modelo.Producto;

@Repository
public class ProductoREST implements ProductoDAO{

	@Autowired
	private RestTemplate template;
	
	@Override
	public List<Producto> getProductos() {
		Producto[] productos = template.getForObject("http://localhost:8080/productos", Producto[].class);
		return Arrays.asList(productos);
	}

	@Override
	public Producto getProducto(Integer id) {
		Producto p = null;
		try {
		 p = template.getForObject("http://localhost:8080/productos/{id}", Producto.class,id);
		} catch (HttpClientErrorException.NotFound ex) {
			
		}
		return p;
	}

	@Override
	public List<Categoria> getCategorias() {
		Categoria[] cats = template.getForObject("http://localhost:8080/categorias",Categoria[].class);
		return Arrays.asList(cats);
	}

	@Override
	public Categoria getCategoria(Integer id) {
		Categoria c = null;
		try {
		 c = template.getForObject("http://localhost:8080/categorias/{id}", Categoria.class,id);
		} catch (HttpClientErrorException.NotFound ex) {
			
		}
		return c;
	}

	@Override
	public Producto nuevoProducto(Producto p) {
		Producto nuevo = template.postForObject("http://localhost:8080/productos",p, Producto.class);
		return nuevo;
	}

	@Override
	public void eliminarProducto(Integer id) {
		try {
			template.delete("http://localhost:8080/productos/{id}", id);
		} catch (HttpClientErrorException ex) {}
		
	}

}
