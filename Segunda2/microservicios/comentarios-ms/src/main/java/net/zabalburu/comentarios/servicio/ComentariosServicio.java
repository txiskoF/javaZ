package net.zabalburu.comentarios.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.comentarios.dao.ComentariosRepositorio;
import net.zabalburu.comentarios.modelo.Comentario;

@Service
public class ComentariosServicio {
	@Autowired
	private ComentariosRepositorio dao;
	
	@Autowired
	private RestTemplate template;
	
	public List<Comentario> getComentarios(){
		return dao.findAll();
	}
	
	public Comentario getComentario(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	
	public Comentario guardarComentario(Comentario c) {
		try {
			template.getForObject("http://productos-ms/productos/{id}",
			 Object.class,c.getIdProducto());
			c = dao.save(c);
			return c;
		} catch (HttpClientErrorException.NotFound ex) {
			return null;
		}
	}
	
	public List<Comentario> getComentariosProducto(Integer idProducto){
		try {
			template.getForObject("http://productos-ms/productos/{id}",
			 Object.class,idProducto);
			return dao.findAllByIdProducto(idProducto);
		} catch (HttpClientErrorException.NotFound ex) {
			return null;
		}
	}
	
	public void eliminarComentario(Integer id) {
		dao.deleteById(id);
	}
}
