package net.zabalburu.productos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.zabalburu.productos.modelo.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {

}
