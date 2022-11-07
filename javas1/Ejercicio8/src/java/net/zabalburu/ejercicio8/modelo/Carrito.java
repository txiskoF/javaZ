/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio8.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ichueca
 */
public class Carrito {
    private List<Cancion> canciones = new ArrayList<>();
    
     public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    public void añadirCancion(Cancion c){
        this.canciones.add(c);
    }
    
    public void eliminarCancion(Integer id){
        Cancion c = new Cancion();
        c.setId(id);
        this.canciones.remove(c);
    }
    
    public double getTotal(){
        double total = 0;
        for(Cancion c : canciones){
            total += c.getPrecio();
        }
        return total;
    }
    
}
