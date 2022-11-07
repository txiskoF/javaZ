package net.zabalburu.actividad14.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.zabalburu.actividad14.dao.CursosDAO;

import org.springframework.stereotype.Service;

import net.zabalburu.actividad14.modelo.Curso;
import net.zabalburu.actividad14.modelo.Tema;
import net.zabalburu.actividad14.modelo.Usuario;

@Service
public class CursosServicio {
	@Autowired
	private CursosDAO dao;
	
	public void nuevoCurso(Curso curso) {
		dao.nuevoCurso(curso);
	}
	public void modificarCurso(Curso curso) {
		dao.modificarCurso(curso);
	}
	public void eliminarCurso(Integer id) {
		dao.eliminarCurso(id);
	}
	public List<Curso> getProximosCursos(){
		return dao.getProximosCursos();
	}
	public Curso getCurso(Integer id) {
		return dao.getCurso(id);
	}
	public List<Curso> getCursosApuntado(Integer idUsuario){
		return  dao.getCursosApuntado(idUsuario);
	}
	public List<Curso> getCursosDisponiblesTema(Integer idTema){
		return dao.getCursosDisponiblesTema(idTema);
	}
	public boolean darDeBaja(Integer idUsuario, Integer idCurso) {
		return dao.darDeBaja(idUsuario, idCurso);
	}
	public List<Tema> getTemas(){
		return dao.getTemas();
	}
	public Usuario login(String usuario, String password) {
		Usuario u = dao.getUsuario(usuario);
		System.out.println(u);
		if (u!=null) {
			if (u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	public List<Curso> getCursos(){
		return dao.getCursos();
	}
	
	public Tema getTema(Integer id) {
		return dao.getTema(id);
	}
}
