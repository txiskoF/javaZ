package net.zabalburu.categorias.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.zabalburu.categorias.dao.CategoriaRepositorio;
import net.zabalburu.categorias.modelo.Categoria;

@Service
public class CategoriasServicio {

	@Autowired
	private CategoriaRepositorio categoriaDAO;

	public List<Categoria> getCategorias() {
		return categoriaDAO.getCategorias();
	}

	public Categoria getCategoria(String categoria) {
		return categoriaDAO.findByCategoria(categoria).orElse(null);
	}

	public Categoria getCategoriaId(Integer id) {
		return categoriaDAO.findById(id).orElse(null);
	}
	
	public Categoria guardarCategoria(Categoria c) {
		return categoriaDAO.save(c);
	}

	public void eliminarCategoria(Integer id) {
		categoriaDAO.deleteById(id);
	}

}
