package net.zabalburu.pacientes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.pacientes.dao.TrabajoPacienteRepositorio;
import net.zabalburu.pacientes.modelo.TrabajoPaciente;

@Service
public class TrabajoPacienteServicio {

	@Autowired
	private TrabajoPacienteRepositorio trabajoPacienteDAO;
	
	public List<TrabajoPaciente> getTrabajoPacientesIdPaciente(Integer idPaciente){
		return trabajoPacienteDAO.getTrabajoPacientesByIdPaciente(idPaciente);
	}
	
	public void eliminarTrabajoPacientesIdPaciente(Integer idPaciente) {
		trabajoPacienteDAO.deleteTrabajoPacienteByIdPaciente(idPaciente);
	}

}
