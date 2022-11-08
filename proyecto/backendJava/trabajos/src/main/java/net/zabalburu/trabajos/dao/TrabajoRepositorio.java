package net.zabalburu.trabajos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.zabalburu.trabajos.modelo.Trabajo;

public interface TrabajoRepositorio extends JpaRepository<Trabajo, Integer> {

	@Query("Select t From Trabajo t Order By t.trabajo")
	List<Trabajo> getTrabajos();

	List<Trabajo> findAllByIdCategoria(Integer idProducto);
}
