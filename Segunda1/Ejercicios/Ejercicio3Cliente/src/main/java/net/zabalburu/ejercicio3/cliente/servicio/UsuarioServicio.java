package net.zabalburu.ejercicio3.cliente.servicio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.zabalburu.ejercicio3.cliente.modelo.Usuario;

@Service
public class UsuarioServicio implements UserDetailsService {
	@Autowired
	private EntityManager em;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Buscar usuario 
		Query q = em.createQuery("Select u From Usuario u where lower(u.nombre)=:nombre");
		q.setParameter("nombre", username.toLowerCase());
		Usuario u;
		try {
			u = (Usuario) q.getSingleResult();
		} catch (NoResultException ex) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return u;
	}

}
