package net.zabalburu.modulos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.modulos.dao.ModulosRepositorio;
import net.zabalburu.modulos.modelo.Modulo;

@Service
public class ModulosServicio {
	@Autowired
	private ModulosRepositorio dao;
	
	public List<Modulo> getModulos(){
		return dao.findAll();
	}
	
	public Modulo getModulo(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public Modulo guardarModulo(Modulo m) {
		return dao.save(m);
	}
	
	public void eliminarModulo(Integer id) {
		dao.deleteById(id);
	}
	
	
}
