package net.zabalburu.avisos.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.avisos.dao.AvisoRepositorio;
import net.zabalburu.avisos.dao.EmpleadoRepositorio;
import net.zabalburu.avisos.dao.RespuestaRepositorio;
import net.zabalburu.avisos.modelo.Aviso;
import net.zabalburu.avisos.modelo.Empleado;
import net.zabalburu.avisos.modelo.Respuesta;

@Service
public class AvisosServicio {

	@Autowired
	private AvisoRepositorio avisoDAO;
	
	@Autowired
	private EmpleadoRepositorio empleadoDAO;
	
	@Autowired
	private RespuestaRepositorio respuestaDAO;
	
	public List<Empleado> getEmpleados(){
		return empleadoDAO.getEmpleados();
	}
	
	public Empleado getEmpleado(String id) {
		return empleadoDAO.getEmpleadoById(id);
	}
	
	public List<Aviso> getAvisos(){
		return avisoDAO.getAvisos();
	}
	
	public Aviso getAviso(Integer id) {
		return avisoDAO.findById(id).orElse(null);
	}
	
	public List<Respuesta> getRespuestasAviso(Integer idAviso){
		return respuestaDAO.findByAviso(getAviso(idAviso));
	}
	
	public Aviso nuevoAviso(Aviso a) {
		return avisoDAO.save(a);
	}
	
	public Respuesta nuevaRespuesta(Respuesta r) {
		return respuestaDAO.save(r);
	}

	public void eliminarAviso(Integer idAviso) {
		//eliminar las respuestas
		//@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
		ArrayList<Respuesta> listaRespuestas = (ArrayList<Respuesta>)respuestaDAO.findByAviso(getAviso(idAviso));
		//eliminar cada respuesta
		for(Respuesta res : listaRespuestas) {
			respuestaDAO.deleteById(res.getId());
		}
		
		//eliminar el aviso
		avisoDAO.deleteById(idAviso);
	}
	
	
}
