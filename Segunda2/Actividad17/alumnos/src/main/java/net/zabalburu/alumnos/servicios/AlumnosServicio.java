package net.zabalburu.alumnos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.alumnos.dao.AlumnosRepositorio;
import net.zabalburu.alumnos.modelo.Alumno;

@Service
public class AlumnosServicio {
	@Autowired
	private AlumnosRepositorio dao;
	
	public List<Alumno> getAlumnos(){
		return dao.findAll();
	}
	
	public Alumno getAlumno(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public Alumno guardarAlumno(Alumno a) {
		return dao.save(a);
	}
	
	public void eliminarAlumno(Integer id) {
		dao.deleteById(id);
	}
	
}
