/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio9.ejbs;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import net.zabalburu.ejercicio9.modelo.Libro;

/**
 *
 * @author ichueca
 */
@Singleton
public class RecomedacionEmpresaEJB {
    private List<Libro> recomendados = new ArrayList<>();
 
    public List<Libro> getRecomendados() {
        return recomendados;
    }
    
    public void añadirLibro(Libro l){
        if (recomendados.indexOf(l)==-1){
            recomendados.add(l);
        }
    }
}
