/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.servicio;

import java.util.ArrayList;
import java.util.List;
import net.zabalburu.ejercicio3.modelo.Libro;

/**
 *
 * @author ichueca
 */
public class Carrito {
    private List<Libro> libros = new ArrayList<>();
    
    public List<Libro> getLibros(){
        return this.libros;
    }
    
    public void añadirLibro(Libro l){
        this.libros.add(l);
    }
    
    public void eliminarLibro(Libro l){
        this.libros.remove(l); // En base al idLibro (equals)
    }

    public void eliminarLibro(String idLibro){
        Libro l = new Libro();
        l.setIdLibro(idLibro);
        this.libros.remove(l); // En base al idLibro (equals=
    }

    
    public double getImporteCompra(){
        double importe = 0;
        for(Libro l : this.libros){
            importe += l.getPrecio();
        }
        return importe;
    }
}
