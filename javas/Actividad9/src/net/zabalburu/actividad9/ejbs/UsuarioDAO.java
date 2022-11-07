package net.zabalburu.actividad9.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


import net.zabalburu.actividad9.modelo.Usuario;

/**
 * Session Bean implementation class UsuarioDAO
 */
@Stateless
@LocalBean
public class UsuarioDAO {
	private List<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * Default constructor. 
     */
    public UsuarioDAO() {
    	usuarios.add(new Usuario(0,"Marta", "marta"));
    	usuarios.add(new Usuario(1,"Javi", "javi"));
    }
    
    public Usuario getUsuario(Integer id){
    	Usuario usuario = null;
		int i;
    	for(i=0; i<usuarios.size(); i++) {
    		usuario = usuarios.get(i);
    	}
    	return usuario;
    }
    
    public Usuario login(String nombre, String pwd) {
    	Usuario u = null;
    	int i;
    	for (i=0; i<usuarios.size() && !nombre.equalsIgnoreCase((usuarios.get(i).getNombre())); i++);
    	if (i < usuarios.size()) {
    		if (pwd.equals(usuarios.get(i).getPassword())) {
    			u = usuarios.get(i);
    		}
    	}
    	return u;
    }

    
}
