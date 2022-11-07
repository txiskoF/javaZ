package net.zabalburu.tareasrest.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.tareasrest.dao.TareasDAO;
import net.zabalburu.tareasrest.modelo.Tarea;
import net.zabalburu.tareasrest.modelo.Usuario;

@Service
public class TareasServicio {
	@Autowired
	private TareasDAO dao;

	public TareasServicio() {
		super();
	}
	
	public List<Usuario> getUsuarios(){
		return dao.getUsuarios();
	}
	
	public Usuario getUsuario(Integer id) {
		return dao.getUsuario(id);
	}
	
	public List<Tarea> getPendientes(Integer id){
		return dao.getPendientes(id);
	}
	
	public Usuario getUsuario(String usuario, String password) {
		Usuario u = dao.getUsuario(usuario);
		if (u!=null && !u.getPassword().equals(password)) {
			u = null;
		}
		return u;
	}
	public Tarea nuevaTarea(Integer id, Tarea t) {
		return dao.nuevaTarea(id, t);
	}
	
	public Tarea getTarea(Integer id) {
		return dao.getTarea(id);
	}
	
	public void eliminarTarea(Integer id) {
		dao.eliminarTarea(id);
	}
	
	public void modificarTarea(Tarea t) {
		dao.modificarTarea(t);
	}
}
