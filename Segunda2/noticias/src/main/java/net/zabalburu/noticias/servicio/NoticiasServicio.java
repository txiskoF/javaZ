package net.zabalburu.noticias.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import net.zabalburu.noticias.dao.NoticiasRepositorio;
import net.zabalburu.noticias.modelo.Noticia;

@Service
public class NoticiasServicio {
	
	@Autowired
	private NoticiasRepositorio repositorioDAO;
	
	
	
	public List<Noticia> getNoticiasTema(Integer idTema){
		return repositorioDAO.findAllByIdTema(idTema);
	}
	
	public Noticia guardarNoticia(Noticia n) {
		return repositorioDAO.save(n);
	}
}
