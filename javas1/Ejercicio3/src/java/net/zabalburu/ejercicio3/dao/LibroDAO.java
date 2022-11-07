/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.dao;

import java.util.List;
import net.zabalburu.ejercicio3.modelo.Libro;

/**
 *
 * @author ichueca
 */
public interface LibroDAO {
    List<Libro> getLibros();
    Libro getLibro(String idLibro);
}
