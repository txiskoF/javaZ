package net.zabalburu.trabajos.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import net.zabalburu.trabajos.dao.TrabajoRepositorio;
import net.zabalburu.trabajos.modelo.Trabajo;

@Service
public class TrabajosServicio {

	@Autowired
	private TrabajoRepositorio servicioDAO;

	@Autowired
	private RestTemplate template;

	public List<Trabajo> getTrabajos() {
		return servicioDAO.getTrabajos();
	}

	public Trabajo getTrabajo(Integer id) {
		return servicioDAO.findById(id).orElse(null);
	}

	public Trabajo guardarTrabajo(Trabajo t) {
		try {
			//template.getForObject("http://categorias-ms/categorias/{id}", 
			//Object.class, t.getIdCategoria());
			t = servicioDAO.save(t);
			return t;
		} catch (HttpClientErrorException.NotFound ex) {
			return null;
		}
	}

	public List<Trabajo> getTrabajosCategoria(Integer idCategoria) {
		try {
			return servicioDAO.findAllByIdCategoria(idCategoria);
		} catch (HttpClientErrorException.NotFound ex) {
			return null;
		}
	}

	public void eliminarTrabajo(Integer id) {
		servicioDAO.deleteById(id);
	}
	
	public List<Trabajo> getTrabajosPorIds(List<Integer> listaIds){
		ArrayList<Trabajo> listaTrabajos = new ArrayList<Trabajo>();
		for(Integer id : listaIds) {
			Trabajo trabajo = servicioDAO.findById(id).orElse(new Trabajo());
			listaTrabajos.add(trabajo);
		}
		return listaTrabajos;
	}
}
