package net.zabalburu.pacientes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.pacientes.dao.PacienteRepositorio;
import net.zabalburu.pacientes.modelo.Paciente;

@Service
public class PacientesServicio {

	@Autowired
	private PacienteRepositorio pacienteDAO;

	public List<Paciente> getPacientes() {
		return pacienteDAO.getPacientes();
	}

	public Paciente getPaciente(Integer id) {
		return pacienteDAO.findById(id).orElse(null);
	}

	public Paciente guardarPaciente(Paciente p) {
		return pacienteDAO.save(p);
	}

	public void eliminarPaciente(Integer id) {
		pacienteDAO.deleteById(id);
	}

	public Paciente getPacienteNombre(String nombre, String primerApellido) {
		return pacienteDAO.findByNombreAndPrimerApellido(nombre, primerApellido).orElse(null);
	}

	public Paciente getPacienteSsn(Long ssn) {
		return pacienteDAO.findBySsn(ssn).orElse(null);
	}

	public Paciente getPacienteNif(String nif) {
		return pacienteDAO.findByNif(nif).orElse(null);
	}
	
	

}
