/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio6.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.zabalburu.ejercicio6.Reparacion;
import net.zabalburu.ejercicio6.Usuario;
import net.zabalburu.ejercicio6.dao.ReparacionDAO;
import net.zabalburu.ejercicio6.dao.UsuarioDAO;

/**
 *
 * @author ichueca
 */
public class Servicio {
    private UsuarioDAO userDAO = new UsuarioDAO();
    private ReparacionDAO reparDAO = new ReparacionDAO();
    
    public Usuario getUsuario(String nombre){
        return userDAO.getUsuario(nombre);
    }
    
    public List<Usuario> getUsuarios(){
        return userDAO.getUsuarios();
    }
    
    public Reparacion getReparacion(Integer repNo){
        return reparDAO.getReparacion(repNo);
    }
    
    public List<Reparacion> getReparaciones(){
        return reparDAO.getReparaciones();
    }
    
    public void añadirReparacion(Reparacion r){
        reparDAO.añadirReparacion(r);
    }
    
    public void eliminarReparacion(Integer repNo){
        reparDAO.eliminarReparacion(repNo);
    }
    
    public void reparar(Integer repNo, String nombre, Double coste){
        Reparacion r = reparDAO.getReparacion(repNo);
        r.setCoste(coste);
        r.setReparador(nombre);
        r.setFechaReparacion(new Date());
        reparDAO.reparar(r);
    }
    
    public List<Reparacion> getReparaciones(String usuario){
        List<Reparacion> reparaciones = new ArrayList<>();
        for(Reparacion r : this.getReparaciones()){
            if (r.getUsuario().equalsIgnoreCase(usuario)){
                reparaciones.add(r);
            }
        }
        return reparaciones;
    }
    
    public List<Reparacion> getReparacionesPendientes(){
        List<Reparacion> reparaciones = new ArrayList<>();
        for(Reparacion r : this.getReparaciones()){
            if (r.getFechaReparacion() == null){
                reparaciones.add(r);
            }
        }
        return reparaciones;
    }
    
    public Usuario validar(String nombre, String password){
        Usuario u = userDAO.getUsuario(nombre);
        if (u != null){
            if (!u.getPassword().equals(password)){
                u = null;
            }
        }
        return u;
    }
}
