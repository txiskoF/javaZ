/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author ichueca
 */
@Stateful
public class BeanStateful {
    private List<String> nombres = new ArrayList<>();
    
    public BeanStateful(){
        nombres.add("Carlos Stateful");
        nombres.add("Ana Stateful");
        nombres.add("Pedro Stateful");
    }
    
    public List<String> getNombres() {
        return this.nombres;
    }
    
    public void nuevoNombre(String nombre){
        this.nombres.add(nombre);
    }
}
