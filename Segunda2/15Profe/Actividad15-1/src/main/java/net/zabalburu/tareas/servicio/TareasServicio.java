package net.zabalburu.tareas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.tareas.dao.TareasREST;
import net.zabalburu.tareas.modelo.Tarea;
import net.zabalburu.tareas.modelo.Usuario;

@Service
public class TareasServicio {
	@Autowired
	private TareasREST dao;
	
	public Usuario login(String usuario, String password) {
		return dao.login(usuario, password);
	}
	
	public List<Tarea> getTareas(Integer idUsuario){
		return dao.getTareas(idUsuario);
	}
	
	public void finalizarTarea(Usuario usuario, Integer idTarea) {
		Tarea t = dao.getTarea(usuario, idTarea);
		t.setRealizada(true);
		dao.modificarTarea(usuario, t);
	}
	
	public void eliminarTarea(Usuario usuario, Integer idTarea) {
		dao.eliminarTarea(usuario, idTarea);
	}
	
	public void nuevaTarea(Usuario usuario, Tarea tarea) {
		dao.nuevaTarea(usuario, tarea);
	}
}
