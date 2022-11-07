package net.zabalburu.empleados.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zabalburu.empleados.modelo.Empleado;

public interface EmpleadosRepositorio extends JpaRepository<Empleado, Integer> {

	Empleado findByIdAndExtension(Integer id, String password);
}
