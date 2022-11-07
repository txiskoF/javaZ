/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio11.dao;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.zabalburu.ejercicio11.modelo.JPAAlumno;
import net.zabalburu.ejercicio11.modelo.Modulo;
import net.zabalburu.ejercicio11.modelo.Nota;
import net.zabalburu.ejercicio11.modelo.Profesor;

/**
 *
 * @author Francis
 */
@Stateless
public class ColegioFachada {

    @PersistenceContext(unitName = "Ejercicio11PU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public JPAAlumno buscaAlumno(Integer id){
        Query q = em.createNamedQuery("JPAAlumno.findById");
        q.setParameter("id", id);
        ArrayList alumnos = (ArrayList) q.getResultList();
        if (alumnos.isEmpty()){
            return null;
        } else {
            return (JPAAlumno)alumnos.get(0);
        }
    }
    
    public ArrayList<JPAAlumno> getAlumnos(){
        Query q = em.createNamedQuery("JPAAlumno.findAll");
        ArrayList alumnos = new ArrayList(q.getResultList());
        return alumnos;
    }
    
    public Profesor buscaProfesor(Integer id){
        Query q = em.createNamedQuery("Profesor.findById");
        q.setParameter("id", id);
        return (Profesor)q.getSingleResult();
    }
    
    public ArrayList<Profesor> getProfesores(){
        Query q = em.createNamedQuery("Profesor.findAll");
        ArrayList profesores = new ArrayList( q.getResultList());
        return profesores;
    }
    
    public Modulo buscaModulo(Integer id){
        Query q = em.createNamedQuery("Modulo.findById");
        q.setParameter("id", id);
        return (Modulo)q.getSingleResult();
    }
    
    public ArrayList<Modulo> getModulos(){
        Query q = em.createNamedQuery("Modulo.findAll");
        ArrayList modulos = new ArrayList(q.getResultList());
        return modulos;
    }
    
    public void nuevaNota(Nota nota){
        //Exception Description: Cannot use an EntityTransaction while using JTA.
        //em.getTransaction().begin();
        em.persist(nota);
        //em.getTransaction().commit();
    }
    
    public void cambiaNota(Nota nota){
        //em.getTransaction().begin();
        em.merge(nota);
        //em.getTransaction().commit();
    }
    
    public void borraNota(Nota nota){
        //em.getTransaction().begin();
        em.remove(nota);
        //em.getTransaction().commit();
    }
    
    
    
    public Modulo getModuloProfesor(Profesor profesor){
        
        Query q = em.createQuery("select m from Modulo m " +
                                    "where m.idProfesor = :idProfesor");
        q.setParameter("idProfesor", profesor);
        return (Modulo)q.getSingleResult();
    }
            
    
    
    
}
