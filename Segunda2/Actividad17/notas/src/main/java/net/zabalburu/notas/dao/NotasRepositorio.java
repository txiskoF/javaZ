package net.zabalburu.notas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import net.zabalburu.notas.modelo.Nota;

@Repository
public interface NotasRepositorio extends JpaRepository<Nota, Integer> {

	List<Nota> findByIdAlumnoAndIdModuloAndEvaluacion(Integer idAlumno, Integer idModulo, int evaluacion);
	
	List<Nota> findByIdAlumno(Integer idAlumno);
	
	List<Nota> findByIdAlumnoAndEvaluacion(Integer idAlumno, Integer evaluacion);
	
	List<Nota> findByIdAlumnoAndIdModulo(Integer idAlumno, Integer idModulo);
	
	List<Nota> findByIdModulo(Integer idModulo);
	
	List<Nota> findByIdModuloAndEvaluacion(Integer idModulo, Integer evaluacion);
	
}
