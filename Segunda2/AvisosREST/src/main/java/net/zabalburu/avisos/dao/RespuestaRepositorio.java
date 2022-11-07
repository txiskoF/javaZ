package net.zabalburu.avisos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.zabalburu.avisos.modelo.Aviso;
import net.zabalburu.avisos.modelo.Respuesta;

@Repository
public interface RespuestaRepositorio extends JpaRepository<Respuesta, Integer> {

	List<Respuesta> findByAviso(Aviso aviso);

}
