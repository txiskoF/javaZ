package net.zabalburu.modulos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.zabalburu.modulos.modelo.Modulo;

@Repository
public interface ModulosRepositorio extends JpaRepository<Modulo, Integer>{

}
