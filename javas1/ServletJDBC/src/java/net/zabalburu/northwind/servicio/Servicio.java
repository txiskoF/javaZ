/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.servicio;

import java.util.List;
import net.zabalburu.northwind.dao.EmpleadoBBDD;
import net.zabalburu.northwind.dao.EmpleadoDAO;
import net.zabalburu.northwind.dao.RegionBBDD;
import net.zabalburu.northwind.dao.RegionDAO;
import net.zabalburu.northwind.modelo.Empleado;
import net.zabalburu.northwind.modelo.Region;

/**
 *
 * @author ichueca
 */
public class Servicio {
    private EmpleadoDAO empDao = new EmpleadoBBDD();
    private RegionDAO regionDao = new RegionBBDD();
    
    public Empleado getEmpleado(Integer id){
        return empDao.getEmpleado(id);
    }
    public List<Empleado> getEmpleados(){
        return empDao.getEmpleados();
    }
    
    public List<Empleado> getEmpleadosRegion(Integer regionId){
        return empDao.getEmpleadosRegion(regionId);
    }
    
    public Region getRegion(Integer id){
        return regionDao.getRegion(id);
    }
    
    public List<Region> getRegiones(){
        return regionDao.getRegiones();
    }
    
    public Empleado login(Integer idEmpleado, String extension){
        Empleado e = null;
        e = this.getEmpleado(idEmpleado);
        if (e != null && !extension.equals(e.getExtension())){
            e = null;
        }
        return e;
    }
    
}
