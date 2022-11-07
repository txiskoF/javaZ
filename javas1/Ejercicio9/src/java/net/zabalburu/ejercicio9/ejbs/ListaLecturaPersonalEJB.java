/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio9.ejbs;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import net.zabalburu.ejercicio9.modelo.Libro;

/**
 *
 * @author ichueca
 */
@Stateful
public class ListaLecturaPersonalEJB {
    private List<Libro> libros = new ArrayList<>();
 
    public List<Libro> getLibros() {
        return libros;
    }
    
    public void añadirLibro(Libro l){
        if (libros.indexOf(l)==-1){
            libros.add(l);
        }
    }
    
    public void eliminarLibro(Libro l){
        libros.remove(l);
    }
    
}
