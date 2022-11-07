package net.zabalburu.clienteproductos.servicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.clienteproductos.auth.JWTToken;
import net.zabalburu.clienteproductos.auth.TokenServicio;
import net.zabalburu.clienteproductos.auth.UsuarioJWT;
import net.zabalburu.clienteproductos.modelo.Categoria;
import net.zabalburu.clienteproductos.modelo.Oferta;
import net.zabalburu.clienteproductos.modelo.Producto;
import net.zabalburu.clienteproductos.modelo.dto.OfertaDTO;

@Service
public class ProductosServicio {
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private TokenServicio authServicio;
	
	@Autowired
	private HttpSession sesion;
	
	public List<Producto> getProductos(){
		return Arrays.asList(template.getForObject("http://localhost:8090/productos", 
				Producto[].class));
	}
	
	
	private ResponseEntity<?> consultaConToken(
			String url,
			HttpMethod metodo,
			Object obj,
			Class cls){
		UsuarioJWT usuario = (UsuarioJWT) sesion.getAttribute("usuario");
		if (usuario == null) {
			throw new RuntimeException("Operación ilegal. No hay usuario");
		}
		if (usuario.getExpiracion().before(new Date())) {
			usuario = new UsuarioJWT(authServicio.getRefreshToken(usuario));
			sesion.setAttribute("usuario", usuario);
			System.out.println("Generado REFRESH_TOKEN");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + usuario.getAccessToken());
		System.out.println("Token : " + usuario.getAccessToken());
		HttpEntity<?> entity = new HttpEntity(obj,headers);
		return template.exchange(
				url,
				metodo,
				entity,
				cls);
	}
	
	
	public Producto getProducto(Integer id) {
		Producto p = null;
		try {
			p = template.getForObject("http://localhost:8090/productos/{id}",	 
				Producto.class,
				id);
		} catch (HttpClientErrorException.NotFound ex) {}
		return p;
	}
	
	public List<Oferta> getOfertas(){
		List<Oferta> ofertas = new ArrayList<Oferta>();
		OfertaDTO[] ofertasDTO = template.getForObject(
			"http://localhost:8090/ofertas-ms/ofertas", 
			OfertaDTO[].class);
		for(OfertaDTO o : ofertasDTO) {
			ofertas.add(new Oferta(o.getId(),
					getProducto(o.getIdProd()),
					o.getFecha(),
					o.getPrecio(),
					o.isActiva()));
		}
		return ofertas;
	}
	
	public UsuarioJWT login(String usuario, String password) {
		UsuarioJWT usu = null;
		JWTToken tk = authServicio.getToken(usuario, password);
		if (tk != null) {
			usu = new UsuarioJWT(tk);
		}
		return usu;
	}
	
	public void eliminarProducto(Integer id) {
		try {
			this.consultaConToken("http://localhost:8090/productos/"+id, 
				HttpMethod.DELETE, 
				null, 
				Object.class);
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Categoria> getCategorias(){
		return Arrays.asList(template.getForObject("http://localhost:8090/productos-ms/categorias", 
				Categoria[].class));
	}
	
	public Producto guardarProducto(Producto p) {
		return (Producto) consultaConToken(
				"http://localhost:8090/productos", 
				HttpMethod.POST, 
				p, 
				Producto.class).getBody();
	}
	
	public Categoria getCategoria(Integer idCateg) {
		Categoria c = null;
		try {
			c = template.getForObject(
					"http://localhost:8090/productos-ms/categorias/{id}", 
					Categoria.class,
					idCateg);
		} catch (HttpClientErrorException.NotFound ex) {}
		return c;
	}
	
}
