package net.zabalburu.temas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.temas.dao.TemasRepositorio;
import net.zabalburu.temas.modelo.Tema;

@Service
public class TemasServicio {
	
	@Autowired
	private TemasRepositorio repositorioDAO;
	
	public List<Tema> getTemas(){
        return repositorioDAO.findAll();
	}
	
	public Tema getTema(Integer id) {
		return repositorioDAO.findById(id).orElse(null);
	}
	
	

}
