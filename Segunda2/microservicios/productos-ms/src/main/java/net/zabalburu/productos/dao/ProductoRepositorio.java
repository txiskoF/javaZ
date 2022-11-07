package net.zabalburu.productos.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import net.zabalburu.productos.modelo.Producto;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
	Optional<Producto> findByNombre(String nombre);
}
