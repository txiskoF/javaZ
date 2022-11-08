package net.zabalburu.pacientes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.zabalburu.pacientes.modelo.TrabajoPaciente;

public interface TrabajoPacienteRepositorio extends JpaRepository<TrabajoPaciente, Integer> {
	
	List<TrabajoPaciente> getTrabajoPacientesByIdPaciente(Integer idPaciente);
	
	void deleteTrabajoPacienteByIdPaciente(Integer idPaciente);

}
