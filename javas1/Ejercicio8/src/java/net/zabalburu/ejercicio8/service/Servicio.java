/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio8.service;

import java.util.List;
import net.zabalburu.ejercicio8.dao.ChinookDAO;
import net.zabalburu.ejercicio8.modelo.Artista;
import net.zabalburu.ejercicio8.modelo.Cancion;
import net.zabalburu.ejercicio8.modelo.Usuario;
import net.zabalburu.ejercicio8.util.SHA;

/**
 *
 * @author ichueca
 */
public class Servicio {
    private ChinookDAO dao = new ChinookDAO();
    
    public List<String> getIniciales(){
        return dao.getInicialesArtistas();
    }
    
    public List<Artista> getArtistasInicial(String letra){
        return dao.getArtistasInicial(letra);
    }
    
    public Usuario login(String usuario, String password){
        Usuario u = dao.getUsuario(usuario);
        if (u!=null){
            String hash = SHA.getHash(password, u.getSalto());
            if (!hash.equals(u.getHash())){
                u = null;
            }
        }
        return u;
    }
    
    public Artista getArtista(Integer id){
        return dao.getArtista(id);
    }
    
    public static void main(String[] args) {
        Servicio s = new Servicio();
        System.out.println(s.login("marta", "marta"));
    }
    
    public Cancion getCancion(Integer id){
        return dao.getCancion(id);
    }
    
}
