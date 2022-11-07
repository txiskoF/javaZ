package net.zabalburu.actividad14.dao;

import java.util.List;

import net.zabalburu.actividad14.modelo.Curso;
import net.zabalburu.actividad14.modelo.Tema;
import net.zabalburu.actividad14.modelo.Usuario;

public interface CursosDAO {
	void nuevoCurso(Curso curso);
	void modificarCurso(Curso curso);
	void eliminarCurso(Integer id);
	List<Curso> getProximosCursos();
	Curso getCurso(Integer id);
	List<Curso> getCursosApuntado(Integer idUsuario);
	List<Curso> getCursosDisponiblesTema(Integer idTema);
	List<Curso> getCursos();
	boolean darDeBaja(Integer idUsuario, Integer idCurso);
	List<Tema> getTemas();
	Usuario getUsuario(String usuario);
	Tema getTema(Integer id);
}
