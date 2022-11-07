package net.zabalburu.actividad6.dao;

import java.util.ArrayList;

import java.util.List;

import net.zabalburu.actividad6.modelo.Usuario;

public class UsuarioDAO {
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioDAO() {
		usuarios.add(new Usuario(1,"marta","marta","usuario"));
		usuarios.add(new Usuario(2,"javi","marta","usuario"));
		usuarios.add(new Usuario(3,"itziar","itziar","reparador"));
		usuarios.add(new Usuario(4,"argeme","argeme","reparador"));
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public Usuario getUsuario(String nombre) {
		Usuario usuario = null;
		int i;
		for(i=0; i<usuarios.size() && 
			!nombre.equalsIgnoreCase(usuarios.get(i).getUsuario());
			i++);
		if (i < usuarios.size()) {
			usuario = usuarios.get(i);
		}
		return usuario;
	}

	public static void main(String[] args) {
		UsuarioDAO dao = new UsuarioDAO();
		for(Usuario u : dao.getUsuarios()) {
			System.out.println(u);
		}
		System.out.println(dao.getUsuario("marta"));
		System.out.println(dao.getUsuario("iñigo"));
	}
	
}
