package net.zabalburu.temas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zabalburu.temas.modelo.Tema;

public interface TemasRepositorio extends JpaRepository<Tema, Integer> {
	

}
