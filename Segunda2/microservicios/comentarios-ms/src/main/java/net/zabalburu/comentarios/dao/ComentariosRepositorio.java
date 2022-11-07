package net.zabalburu.comentarios.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.zabalburu.comentarios.modelo.Comentario;

@Repository
public interface ComentariosRepositorio extends JpaRepository<Comentario, Integer> {
	List<Comentario> findAllByIdProducto(Integer idProducto);
}
