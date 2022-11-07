/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio12.sesion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.zabalburu.ejercicio12.modelo.Curso;
import net.zabalburu.ejercicio12.modelo.Empresa;
import net.zabalburu.ejercicio12.modelo.Reserva;

/**
 *
 * @author ichueca
 */
@Stateless
public class ReservasFachada {

    @PersistenceContext(unitName = "Ejercicio12PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public List<Curso> getCursos(){
        Query q = em.createNamedQuery("Curso.findAll");
        return q.getResultList();
    }
    
    public Curso buscaCurso(Integer id){
        return em.find(Curso.class, id);
    }
    
    public List<Empresa> getEmpresas(){
        Query q = em.createNamedQuery("Empresa.findAll");
        return q.getResultList();
    }
    
    public Empresa buscaEmpresa(Integer id){
        return em.find(Empresa.class, id);
    }
    
    public Reserva BuscaReserva(Empresa empresa, Curso curso){
        Query q = em.createQuery("Select r From Reserva r where r.idCurso=:curso and " +
                "r.idEmpresa=:empresa");
        q.setParameter("curso", curso);
        q.setParameter("empresa", empresa);
        try {
            return (Reserva) q.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }
    
    public List<Curso> cursosDisponibles(Empresa empresa){
        Query q = em.createQuery(
            "Select c from Curso c where c.idCurso " + 
            "NOT IN (Select r.idCurso.idCurso from " +
            "Empresa e JOIN e.reservaList r where e=:empresa)");
        q.setParameter("empresa", empresa);
        return q.getResultList();
    }
    
    public Integer ultimaReserva(){
        Query q = em.createQuery("Select max(r.idReserva) From Reserva r");
        return (Integer) q.getSingleResult();
    }
    
    public void nuevaReserva(Reserva r){
        em.persist(r);
        r.getIdCurso().getReservaList().add(r);
        r.getIdEmpresa().getReservaList().add(r);
    }
    
}
