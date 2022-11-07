package net.zabalburu.actividad8.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.zabalburu.actividad8.modelo.Pista;
import net.zabalburu.actividad8.modelo.Usuario;
import net.zabalburu.actividad8.modelo.UsuarioPista;
import net.zabalburu.actividad8.util.Encriptar;

public class UsuarioDAO {

	private EntityManager em;
	
	public UsuarioDAO() {
		this.em = Persistence.createEntityManagerFactory("Actividad8").createEntityManager();
	}

	
	public List<Usuario> getUsuarios(){
		Query q = em.createNamedQuery("Select u From Usuario u");
		return q.getResultList();
	}
	
	public Usuario getUsuario(Integer id) {
		return em.find(Usuario.class, id);
	}
	
	public Usuario getUsuario(String usuario) {
		Query q = em.createQuery("Select u From Usuario u Where u.usuario = :usuario");
		q.setParameter("usuario", usuario);
		try {
			return (Usuario) q.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public void añadirUsuario(String nombre, String apellidos, String usu, String password,
			Usuario.Sexo sexo) {
		Usuario usuario = new Usuario();
		usuario.setApellidos(apellidos);
		usuario.setNombre(nombre);
		usuario.setSexo(sexo);
		usuario.setUsuario(usu);
		String salto = Encriptar.getSalto(10);
		String hash = Encriptar.getHash(password, salto);
		usuario.setHash(hash);
		usuario.setSalto(salto);
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}
	
	
	public List<UsuarioPista> getPendientes(Integer id){
		Query q = em.createQuery("Select u From UsuarioPista u " +
				"Where u.usuario.id = :id and u.pendiente=True");
		q.setParameter("id", id);
		return q.getResultList();
	}
	
	public void añadirPista(Integer idUsuario, Integer idPista) {
		UsuarioPista u = new UsuarioPista();
		Pista p =em.find(Pista.class, idPista);
		u.setPista(p);
		u.setUsuario(getUsuario(idUsuario));
		u.setPendiente(true);
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}
	
	public void quitarPista(Integer id) {
		em.getTransaction().begin();
		UsuarioPista u = em.find(UsuarioPista.class, id);
		em.remove(u);
		em.getTransaction().commit();
	}
	
	public void finalizarCompra(Integer idUsuario) {
		em.getTransaction().begin();
		List<UsuarioPista> uPistas = getPendientes(idUsuario);
		for(UsuarioPista up : uPistas) {
			up.setPendiente(false);
		}
		em.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		/*UsuarioDAO dao = new UsuarioDAO();
		dao.añadirUsuario("Juan", "Lopez", "jlopez","jlopez", Usuario.Sexo.VARON);
		dao.añadirUsuario("Ana", "Lopez", "alopez", "alopez", Usuario.Sexo.MUJER);
		dao.añadirUsuario("Carlos", "Lopez", "clopez", "clopez", Usuario.Sexo.VARON);
		dao.añadirUsuario("Julia", "Lopez", "mlopez", "jlopez", Usuario.Sexo.MUJER);
		 */	
		UsuarioDAO dao = new UsuarioDAO();
		/*dao.añadirPista(1, 1);
		dao.añadirPista(1, 2);*/
		/*for(UsuarioPista up : dao.getPendientes(1)) {
			System.out.println(up);
		}*/
		//dao.finalizarCompra(1);
		dao.quitarPista(16);
	}
	
}
