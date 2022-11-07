/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio9.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import net.zabalburu.ejercicio9.dao.LibroDAO;
import net.zabalburu.ejercicio9.modelo.Empleado;
import net.zabalburu.ejercicio9.modelo.Libro;

/**
 *
 * @author ichueca
 */
@Stateless
public class ServicioEJB {
    private LibroDAO dao = new LibroDAO();
    
    public Empleado validar(String nombre, String apellido, String id){
        Empleado e = null;
        e = dao.getEmpleado(nombre, apellido);
        if (!e.getId().equals(id)){
            e = null;
        }
        return e;
    }
    
    public List<Empleado> getEmpleados(){
        return dao.getEmpleados();
    }
    
    public Libro getLibro(String id){
        return dao.getLibro(id);
    }
    
    public List<Libro> getLibros(){
        return dao.getLibros();
    }
    
}
