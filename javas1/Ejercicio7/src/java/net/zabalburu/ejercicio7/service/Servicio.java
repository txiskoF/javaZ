/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio7.service;

import java.util.List;
import net.zabalburu.ejercicio7.Pregunta;

import net.zabalburu.ejercicio7.Usuario;
import net.zabalburu.ejercicio7.dao.PreguntaDAO;
import net.zabalburu.ejercicio7.dao.UsuarioDAO;

/**
 *
 * @author ichueca
 */
public class Servicio {
    private UsuarioDAO userDAO = new UsuarioDAO();
    private PreguntaDAO preguntaDAO = new PreguntaDAO();
    public Usuario getUsuario(String nombre){
        return userDAO.getUsuario(nombre);
    }
    
    public List<Usuario> getUsuarios(){
        return userDAO.getUsuarios();
    }
    
    public Usuario login(String nombre, String password){
        Usuario u = userDAO.getUsuario(nombre);
        if (u != null){
            if (!u.getPassword().equals(password)){
                u = null;
            }
        }
        return u;
    }
    
    public List<Pregunta> getPreguntas(){
        return preguntaDAO.getPreguntas();
    }
    
    public void nuevaPregunta(Pregunta p){
        preguntaDAO.nuevaPregunta(p);
    }
    
    public Pregunta getPregunta(Integer id){
        return preguntaDAO.getPregunta(id);
    }
}
