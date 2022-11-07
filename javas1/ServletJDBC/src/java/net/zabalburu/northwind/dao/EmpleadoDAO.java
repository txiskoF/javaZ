/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.dao;

import java.util.List;
import net.zabalburu.northwind.modelo.Empleado;

/**
 *
 * @author ichueca
 */
public interface EmpleadoDAO {
    Empleado getEmpleado(Integer id);
    List<Empleado> getEmpleados();
    List<Empleado> getEmpleadosRegion(Integer regionId);
}
