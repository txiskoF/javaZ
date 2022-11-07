package net.zabalburu.tareas.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.tareas.modelo.Tarea;
import net.zabalburu.tareas.modelo.Usuario;

@Repository
public class TareasREST {
	@Autowired
	private RestTemplate template;
	
	private final String HOST = "http://localhost:8080/";
	
	public Usuario login(String usuario, String password) {
		Usuario u = null;
		try {
			u = template.getForObject(HOST+"usuarios/{usuario}/{password}", Usuario.class,usuario,password);
		} catch (HttpClientErrorException.NotFound ex) {
			
		}
		return u;
	}
	
	public List<Tarea> getTareas(Integer idUsuario){
		Tarea[] t = template.getForObject(HOST+"usuarios/{id}/tareas", Tarea[].class,idUsuario);
		return Arrays.asList(t);
	}
	
	public Tarea getTarea(Usuario usuario, Integer idTarea) {
		Tarea t = null;
		try {
			t = template.getForObject(HOST+"/usuarios/{idUsuario}/tareas/{idTarea}",Tarea.class,usuario.getId(),idTarea);
		} catch (HttpClientErrorException.NotFound ex) {
		}
		return t;
	}
	
	public void modificarTarea(Usuario usuario, Tarea tarea) {
		try {
			template.put(HOST+"/usuarios/{id}/tareas", tarea,usuario.getId());
		} catch (HttpClientErrorException.NotFound ex) {
		}
	}
	
	public void eliminarTarea(Usuario usuario, Integer idTarea) {
		try {
			template.delete(HOST+"/usuarios/{idUsuario}/tareas/{idTarea}",usuario.getId(), idTarea);
		} catch (HttpClientErrorException.NotFound ex) {
		}
	}

	public void nuevaTarea(Usuario usuario, Tarea tarea) {
		try {
			template.postForObject(HOST+"/usuarios/{id}/tareas", tarea,Tarea.class,usuario.getId());
		} catch (HttpClientErrorException.NotFound ex) {
		}
	}
	
}
