package net.zabalburu.categorias.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.zabalburu.categorias.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

	@Query("Select c From Categoria c Order By c.categoria")
	List<Categoria> getCategorias();

	Optional<Categoria> findByCategoria(String categoria);

	Optional<Categoria> findById(Integer id);

}
