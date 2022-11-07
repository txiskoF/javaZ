package net.zabalburu.actividad8.servicio;

import java.util.List;

import net.zabalburu.actividad8.dao.ArtistaDAO;
import net.zabalburu.actividad8.dao.UsuarioDAO;
import net.zabalburu.actividad8.modelo.Artista;
import net.zabalburu.actividad8.modelo.Usuario;
import net.zabalburu.actividad8.modelo.UsuarioPista;
import net.zabalburu.actividad8.util.Encriptar;

public class ChinookServicio {
	private ArtistaDAO artistaDAO = new ArtistaDAO();
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public ChinookServicio() {
		// TODO Auto-generated constructor stub
	}

	
	public Usuario login(String usuario, String password) {
		Usuario user = usuarioDAO.getUsuario(usuario);
		if (user != null) {
			String hash = Encriptar.getHash(password, user.getSalto());
			if (!hash.equals(user.getHash())) {
				user = null;
			}
		}
		return user;
	}
	
	public List<String> getInicialesArtistas(){
		return artistaDAO.getInicialesArtistas();
	}
	
	public List<Artista> getArtistas(String inicial){
		return artistaDAO.getArtistas(inicial);
	}
	
	public Artista getArtista(Integer id) {
		return artistaDAO.getArtista(id);
	}
	
	public List<UsuarioPista> getPendientes(Integer id){
		return usuarioDAO.getPendientes(id);
	}
	
	public void añadirPista(Integer idUsuario, Integer idPista) {
		usuarioDAO.añadirPista(idUsuario, idPista);
	}
	
	public void quitarPista(Integer id) {
		usuarioDAO.quitarPista(id);
	}
	
	public void finalizarCompra(Integer idUsuario) {
		usuarioDAO.finalizarCompra(idUsuario);
	}
	
	public static void main(String[] args) {
		ChinookServicio s = new ChinookServicio();
		System.out.println(s.login("jlopez", "jlopez"));
		System.out.println(s.login("jlopez", "jlopez2"));
		System.out.println(s.login("jlopez2", "jlopez"));
	}
	
}
