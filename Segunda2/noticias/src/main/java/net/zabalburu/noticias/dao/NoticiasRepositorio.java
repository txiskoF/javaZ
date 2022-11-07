package net.zabalburu.noticias.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zabalburu.noticias.modelo.Noticia;

public interface NoticiasRepositorio extends JpaRepository<Noticia, Integer> {

	List<Noticia> findAllByIdTema(Integer idProducto);
}
