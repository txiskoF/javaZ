package net.zabalburu.discos.servicio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.zabalburu.discos.modelo.Album;
import net.zabalburu.discos.modelo.Artista;
import net.zabalburu.discos.modelo.Cliente;
import net.zabalburu.discos.modelo.Pedido;

/**
 * Session Bean implementation class ServicioEJB
 */
@Stateless
@LocalBean
public class ServicioEJB {
	
	@PersistenceContext(unitName = "ExPrimera")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ServicioEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Artista> getArtists(){
    	Query q = em.createQuery("Select a From Artista a " +
    			" Order by a.nombre ASC");
    	return q.getResultList();
    }
    
    public Cliente getCliente(Integer id) {
    	Cliente e = em.find(Cliente.class, id);
		return e;
	}
    
    public List<Cliente> getClientes(){
		Query q = em.createQuery("Select c From Cliente c Order by c.apellido, c.nombre");
		return q.getResultList();
	}
    
    public List<Album> getAlbums(Integer idArtista){
    	Query q = em.createQuery("Select a From Album a " +
    			" where a.idartista=:idArtista Order by a.titulo");
    	q.setParameter("idArtista", idArtista);
    	return q.getResultList();
    }
    
    public List<Album> getAlbumes(){
    	Query q = em.createQuery("Select a From Album a " +
    			" Order by a.titulo");
    	return q.getResultList();
    }
    
    
    public Cliente getCustomer(Integer id, String email) {
    	Query q = em.createQuery("Select c From Cliente c where c.id=:id and"
    			+ "c.email=:email");
    	q.setParameter("id", id);
    	q.setParameter("email", email);
    	Cliente c = null;
    	try {             
            c = (Cliente) q.getSingleResult();
        } catch (NoResultException ex){
            return c;
        }
    	//Hibernate.initialize(u.getPedidos());
    	return c;
    }
    
    
    
    public void nuevoPedido(Pedido p) {
    	em.persist(p);
    }
    
    
    public Pedido getPedido(Integer id) {
    	return em.find(Pedido.class, id);
    }
    
    public List<Pedido> getPedidos(Integer customerId){
    	Query q = em.createQuery("Select p From Pedido p " +
    			" where p.cliente.id=:customerId Order by p.album.id");
    	q.setParameter("customerId", customerId);
    	return q.getResultList();
    }
    
    public void eliminarPedido(Integer idPedido) {
    	em.remove(getPedido(idPedido));
    }
    
    public Album getAlbum(Integer id) {
    	return em.find(Album.class, id);
    }
    
    public Cliente login(Integer id, String email){
        Query q = em.createQuery("Select c From Cliente c "+
                "where c.id=:id and c.email=:email");
        q.setParameter("email", email);
        q.setParameter("id", id);
        Cliente c = null;
        try {
            c = (Cliente) q.getSingleResult();
        } catch (NoResultException ex) {}
        if (c !=null){
            
        }
        return c;
    }

}
