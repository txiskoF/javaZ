package net.zabalburu.empleados.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.zabalburu.empleados.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

	@Query("Select e From Empleado e Order By e.primerApellido, e.nombre")
	List<Empleado> getEmpleados();

	Empleado findByEmailAndPassword(String email, String password);
	
	Optional<Empleado> findByNombreAndPrimerApellido(String nombre, String primerApellido);

}
