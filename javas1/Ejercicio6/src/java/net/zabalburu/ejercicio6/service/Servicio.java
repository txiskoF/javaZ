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
        //Busco la reparacion
        Reparacion r = reparDAO.getReparacion(repNo);
        //cambio los datos
        r.setCoste(coste);
        r.setReparador(nombre);
        r.setFechaReparacion(new Date());
        //llamo al DAO a reparar
        reparDAO.reparar(r);
    }
    
    public List<Reparacion> getReparaciones(String usuario){
        //Obtengo la lista de reparaciones
        List<Reparacion> reparaciones = new ArrayList<>();
        //recorro todas las reparaciones si la reparaciones coincide con el usario
        //que se pasa
        for(Reparacion r : this.getReparaciones()){
            if (r.getUsuario().equalsIgnoreCase(usuario)){
                //añado las que son del usario
                reparaciones.add(r);
            }
        }
        //devuelvo als reparaciones
        return reparaciones;
    }
    
    public List<Reparacion> getReparacionesPendientes(){
        List<Reparacion> reparaciones = new ArrayList<>();
        for(Reparacion r : this.getReparaciones()){
                    //SI NO TIENE FECHA REPARACION NULL ES QUE ESTA PENDIENTE
            if (r.getFechaReparacion() == null){
                reparaciones.add(r);
            }
        }
        return reparaciones;
    }
    
    public Usuario validar(String nombre, String password){
        //OBTENGO EL USUARIO CON EL NOMBRE QUE SE PASA
        Usuario u = userDAO.getUsuario(nombre);
        if (u != null){
            //SI LO HE ENCONTRADO COMRPUEBO SI CONTRSEÑA ES IGUAL A LA PASWWORD
            if (!u.getPassword().equals(password)){
                u = null;
            }
        }
        return u;
    }
}
