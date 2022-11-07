package net.zabalburu.alumnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.zabalburu.alumnos.modelo.Alumno;

@Repository
public interface AlumnosRepositorio extends JpaRepository<Alumno, Integer> {

}
