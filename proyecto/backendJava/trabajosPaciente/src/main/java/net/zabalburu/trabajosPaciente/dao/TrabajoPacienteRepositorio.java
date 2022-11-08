package net.zabalburu.trabajosPaciente.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.zabalburu.trabajosPaciente.modelo.TrabajoPaciente;

public interface TrabajoPacienteRepositorio extends JpaRepository<TrabajoPaciente, Integer> {

	List<TrabajoPaciente> findAllByIdPaciente(Integer idPaciente);
	
	//@Query("Delete From TrabajoPaciente tp where tp.idTrabajo = ?1 and tp.idPaciente = ?2")
	void deleteByIdTrabajoAndIdPaciente(Integer idTrabajo, Integer idPaciente);
	
}
