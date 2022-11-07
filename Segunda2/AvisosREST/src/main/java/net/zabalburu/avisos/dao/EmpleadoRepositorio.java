package net.zabalburu.avisos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.zabalburu.avisos.modelo.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

	@Query("Select e From Empleado e Order By e.apellido ")
	List<Empleado> getEmpleados ();

	
	Empleado getEmpleadoById(String id);

}
