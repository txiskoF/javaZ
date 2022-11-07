package net.zabalburu.tareasrest.dao;

import java.util.List;

import net.zabalburu.tareasrest.modelo.Tarea;
import net.zabalburu.tareasrest.modelo.Usuario;

public interface TareasDAO {
	List<Usuario> getUsuarios();
	Usuario getUsuario(Integer id);
	List<Tarea> getPendientes(Integer id);
	Usuario getUsuario(String usuario);
	Tarea nuevaTarea(Integer id, Tarea t);
	Tarea getTarea(Integer id);
	void eliminarTarea(Integer id);
	void modificarTarea(Tarea t);
}
