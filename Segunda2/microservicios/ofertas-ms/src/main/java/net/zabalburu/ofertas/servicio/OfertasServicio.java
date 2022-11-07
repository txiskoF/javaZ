package net.zabalburu.ofertas.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.ofertas.dao.OfertasRepositorio;
import net.zabalburu.ofertas.modelo.Oferta;

@Service
public class OfertasServicio {
	@Autowired
	private OfertasRepositorio dao;
	
	public List<Oferta> getOfertasVigentes(){
		return dao.getOfertasVigentes();
	}
	
	public Oferta getOferta(Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	public Oferta guardarOferta(Oferta o) {
		return dao.save(o);
	}
	
	public void eliminarOferta(Integer id) {
		dao.deleteById(id);
	}
	
}
