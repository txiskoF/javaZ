package net.zabalburu.pacientes.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.zabalburu.pacientes.modelo.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {

	@Query("Select p From Paciente p Order By p.primerApellido, p.nombre")
	List<Paciente> getPacientes();

	Optional<Paciente> findBySsn(Long ssn);

	Optional<Paciente> findByNif(String nif);

	Optional<Paciente> findByNombreAndPrimerApellido(String nombre, String primerApellido);

}
