package net.zabalburu.compras.dao;

import java.util.ArrayList;
import java.util.List;

import net.zabalburu.compras.modelo.Usuario;
		//Lista de usuarios
public class UsuarioDAO {
	List<Usuario> usuarios = new ArrayList<Usuario>();
	public UsuarioDAO() {
		usuarios.add(new Usuario(1,"Juan","Lopez","jlopez","12345"));
		usuarios.add(new Usuario(2,"Ana","Lopez","alopez","12345"));
		usuarios.add(new Usuario(3,"Carlos","Lopez","clopez","12345"));
	}
	
	//Obtener el usuario que llega por parametro
	public Usuario getUsuario(String usuario) {
		//Creo una variable usu que devolver el usuario encontrado si es igual al que me pasan
		Usuario usu = null;
		int i;
		for(i=0; i<usuarios.size() && 
			!usuario.equals(usuarios.get(i).getUsuario());i++);
		if (i<usuarios.size()) {
			usu = usuarios.get(i);
		}
		return usu;
	}
	
	// Métodos añadir / eliminar / modificar...

}
