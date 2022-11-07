package net.zabalburu.notas.servicio;

import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.notas.dao.NotasRepositorio;
import net.zabalburu.notas.modelo.Nota;

@Service
public class NotasServicio {
	@Autowired
	private NotasRepositorio dao;
	
	public List<Nota> getNotas(){
		return dao.findAll();
	}
	
	public Nota getNota(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public List<Nota> getNotasAlumno(Integer idAlumno, Integer idModulo, Integer evaluacion) {
		if (idModulo == null) {
			if (evaluacion == null) {
				return dao.findByIdAlumno(idAlumno);
			} else {
				return dao.findByIdAlumnoAndEvaluacion(idAlumno, evaluacion);
			}
		} else {
			if (evaluacion == null) {
				return dao.findByIdAlumnoAndIdModulo(idAlumno, idModulo);
			} else {
				return dao.findByIdAlumnoAndIdModuloAndEvaluacion(idAlumno, idModulo, evaluacion);
			}
		}
	}
	
	
	public List<Nota> getNotasModulo(Integer idModulo, Integer evaluacion){
		if (evaluacion == null) {
			return dao.findByIdModulo(idModulo);
		}
		return dao.findByIdModuloAndEvaluacion(idModulo, evaluacion);
	}
	
	public Nota guardarNota(Nota n) {
		return dao.save(n);
	}
	
	public void eliminarNota(Integer id) {
		dao.deleteById(id);
	}
	
}
