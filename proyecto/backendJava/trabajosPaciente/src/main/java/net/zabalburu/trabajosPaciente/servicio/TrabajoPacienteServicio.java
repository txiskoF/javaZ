package net.zabalburu.trabajosPaciente.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.trabajosPaciente.dao.TrabajoPacienteRepositorio;
import net.zabalburu.trabajosPaciente.modelo.TrabajoPaciente;


@Service
public class TrabajoPacienteServicio {
	
	@Autowired
	private TrabajoPacienteRepositorio servicioDAO;
	
	@Autowired
	private RestTemplate template;

	public List<TrabajoPaciente> getTrabajosPacientePorIdPaciente(Integer idPaciente) {
		return servicioDAO.findAllByIdPaciente(idPaciente);
	}
	
	public TrabajoPaciente crearTrabajoPaciente(TrabajoPaciente trabPac) {
		return servicioDAO.save(trabPac);
	}
	
	public void eliminarTrabajoPaciente(Integer id) {
		servicioDAO.deleteById(id);
	}
	
	public void eliminarTrabajoPacientePorIdTrabajoIdPaciente(Integer idTrabajo, Integer idPaciente) {
		servicioDAO.deleteByIdTrabajoAndIdPaciente(idTrabajo, idPaciente);
	}

}
