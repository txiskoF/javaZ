/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.servicio;

import java.util.List;
import net.zabalburu.ejercicio3.dao.LibroBBDD;
import net.zabalburu.ejercicio3.dao.LibroDAO;
import net.zabalburu.ejercicio3.modelo.Libro;

/**
 *
 * @author ichueca
 */
public class LibroService {
    private LibroDAO dao = new LibroBBDD();
    public List<Libro> getLibros(){
        return dao.getLibros();
    }
    public Libro getLibro(String idLibro){
        return dao.getLibro(idLibro);
    }
}
