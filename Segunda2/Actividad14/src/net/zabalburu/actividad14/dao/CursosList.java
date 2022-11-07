package net.zabalburu.actividad14.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import net.zabalburu.actividad14.modelo.Curso;
import net.zabalburu.actividad14.modelo.Tema;
import net.zabalburu.actividad14.modelo.Usuario;
import net.zabalburu.actividad14.modelo.UsuarioCurso;

@Repository
public class CursosList implements CursosDAO {
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Tema> temas = new ArrayList<Tema>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<UsuarioCurso> usuariosCursos = new ArrayList<UsuarioCurso>();
	
	public CursosList() {
		usuarios.add(new Usuario("marta","mtorre",true,1));
		usuarios.add(new Usuario("javi","jrico",false,1));
		usuarios.add(new Usuario("itziar","ibilbao",false,1));
		temas.add(new Tema(1,"Sistemas Operativos"));
		temas.add(new Tema(2,"Redes Informáticas"));
		temas.add(new Tema(3,"Programación"));
		cursos.add(new Curso(1,"Redes con Windows NT",temas.get(1),20,new GregorianCalendar(2020,10,01).getTime(),new GregorianCalendar(2020,11,01).getTime(),200.50));
		cursos.add(new Curso(2,"Programación JAVA",temas.get(2),20,new GregorianCalendar(2020,11,10).getTime(),new GregorianCalendar(2021,02,01).getTime(),125.78));
		cursos.add(new Curso(3,"Firewalls en Linux",temas.get(1),20,new GregorianCalendar(2020,11,15).getTime(),new GregorianCalendar(2021,03,01).getTime(),275));
		cursos.add(new Curso(4,"Directorio Activo",temas.get(0),20,new GregorianCalendar(2020,11,20).getTime(),new GregorianCalendar(2021,02,01).getTime(),200.50));
		cursos.add(new Curso(5,"Gestión de Usuarios en Linux",temas.get(0),20,new GregorianCalendar(2021,0,05).getTime(),new GregorianCalendar(2021,01,01).getTime(),350.50));
		cursos.add(new Curso(6,"J2EE",temas.get(2),20,new GregorianCalendar(2021,1,1).getTime(),new GregorianCalendar(2021,02,15).getTime(),125.50));
		cursos.add(new Curso(7,"Angular",temas.get(2),20,new GregorianCalendar(2021,1,1).getTime(),new GregorianCalendar(2021,02,15).getTime(),200.50));
		usuariosCursos.add(new UsuarioCurso(1, usuarios.get(0),cursos.get(1)));
		usuariosCursos.add(new UsuarioCurso(2, usuarios.get(2),cursos.get(0)));
		usuariosCursos.add(new UsuarioCurso(3, usuarios.get(0),cursos.get(2)));
		usuariosCursos.add(new UsuarioCurso(4, usuarios.get(1),cursos.get(1)));
		usuariosCursos.add(new UsuarioCurso(5, usuarios.get(1),cursos.get(4)));
		usuariosCursos.add(new UsuarioCurso(6, usuarios.get(2),cursos.get(3)));
		usuariosCursos.add(new UsuarioCurso(7, usuarios.get(2),cursos.get(2)));
		usuariosCursos.add(new UsuarioCurso(8, usuarios.get(0),cursos.get(5)));
		usuariosCursos.add(new UsuarioCurso(9, usuarios.get(0),cursos.get(1)));
	}
	
	@Override
	public void nuevoCurso(Curso curso) {
		Integer id = (cursos.isEmpty())?1:cursos.get(cursos.size()-1).getId()+1;
		curso.setId(id);
		cursos.add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		Integer pos = cursos.indexOf(curso);
		cursos.set(pos, curso);
	}

	@Override
	public void eliminarCurso(Integer id) {
		Curso eliminar = new Curso();
		eliminar.setId(id);
		cursos.remove(eliminar);
	}

	@Override
	public List<Curso> getProximosCursos() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.clear(GregorianCalendar.HOUR);
		gc.clear(GregorianCalendar.HOUR_OF_DAY);
		gc.clear(GregorianCalendar.MINUTE);
		gc.clear(GregorianCalendar.SECOND);
		gc.clear(GregorianCalendar.MILLISECOND);
		
		return cursos
				.stream()
				.filter(curso -> curso.getFechaInicio().compareTo(gc.getTime())>=0)
				.collect(Collectors.toList());
	}

	@Override
	public Curso getCurso(Integer id) {
		Curso c = new Curso();
		c.setId(id);
		return cursos.get(cursos.indexOf(c));
	}

	@Override
	public List<Curso> getCursosApuntado(Integer idUsuario) {
		Set<Curso> cursos = new HashSet<Curso>();
		for(UsuarioCurso uc : usuariosCursos) {
			if (uc.getUsuario().getId() == idUsuario) {
				cursos.add(uc.getCurso());
			}
		}
		return new ArrayList<Curso>(cursos);
	}

	@Override
	public List<Curso> getCursosDisponiblesTema(Integer idTema) {
		return cursos.stream()
				.filter(curso -> curso.getTema().getId() == idTema)
				.collect(Collectors.toList());
	}

	@Override
	public boolean darDeBaja(Integer idUsuario, Integer idCurso) {
		int i;
		for(i=0; i<usuariosCursos.size() && 
			(usuariosCursos.get(i).getCurso().getId()!=idCurso
			|| usuariosCursos.get(i).getUsuario().getId()!=idUsuario);
			i++);
		if (i<usuariosCursos.size()) {
			usuariosCursos.remove(i);
			return true;
		}
		return false;
	}

	@Override
	public List<Tema> getTemas() {
		return temas;
	}

	@Override
	public Usuario getUsuario(String usuario) {
		int i;
		for(i=0;i<usuarios.size() && 
			!usuario.equalsIgnoreCase(usuarios.get(i).getUsuario());
			i++);
		return (i==usuarios.size())?null:usuarios.get(i);
	}

	@Override
	public List<Curso> getCursos() {
		// TODO Auto-generated method stub
		return this.cursos;
	}

	@Override
	public Tema getTema(Integer id) {
		Tema t = new Tema();
		t.setId(id);
		int pos = temas.indexOf(t);
		return (pos==-1)?null:temas.get(pos);
	}

}
