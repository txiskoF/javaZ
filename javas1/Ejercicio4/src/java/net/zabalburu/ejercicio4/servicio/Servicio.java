/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio4.servicio;

import java.util.List;
import net.zabalburu.ejercicio4.dao.EmpleadoBBDD;
import net.zabalburu.ejercicio4.dao.EmpleadoDAO;
import net.zabalburu.ejercicio4.dao.PedidoBBDD;
import net.zabalburu.ejercicio4.dao.PedidoDAO;
import net.zabalburu.ejercicio4.modelo.Empleado;
import net.zabalburu.ejercicio4.modelo.Pedido;

/**
 *
 * @author ichueca
 */
public class Servicio {
    private EmpleadoDAO empDao = new EmpleadoBBDD();
    private PedidoDAO pedDao = new PedidoBBDD();
    
    public Empleado getEmpleado(Integer id){
        return empDao.getEmpleado(id);
    }
    public List<Empleado> getEmpleados(){
        return empDao.getEmpleados();
    }
    
    public List<Empleado> getJefes(){
        return empDao.getJefes();
    }
    
    public List<Empleado> getEmpleadosJefe(Integer idJefe){
        return empDao.getEmpleadosJefe(idJefe);
    }
   
    public Empleado login(Integer idEmpleado, String extension){
        Empleado e = null;
        e = this.getEmpleado(idEmpleado);
        if (e != null && !extension.equals(e.getExtension())){
            e = null;
        }
        return e;
    }
    
    public List<Pedido> getPedidos(Integer empId){
        return pedDao.getPedidos(empId);
    }
    
}
