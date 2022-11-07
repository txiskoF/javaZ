/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ichueca
 */
@Stateless
public class BeanStateless {
    private List<String> nombres = new ArrayList<>();
    
    public BeanStateless(){
        nombres.add("Juan Stateless");
        nombres.add("Ana Stateless");
        nombres.add("Carlos Stateless");
    }
    
    public List<String> getNombres() {
        return this.nombres;
    }
    
    public void nuevoNombre(String nombre){
        this.nombres.add(nombre);
    }
}
