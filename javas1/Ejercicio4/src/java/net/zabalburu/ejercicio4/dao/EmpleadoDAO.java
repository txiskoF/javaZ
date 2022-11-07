/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio4.dao;

import java.util.List;
import net.zabalburu.ejercicio4.modelo.Empleado;

/**
 *
 * @author ichueca
 */
public interface EmpleadoDAO {
    Empleado getEmpleado(Integer id);
    List<Empleado> getEmpleados();
    List<Empleado> getEmpleadosJefe(Integer idJefe);
    List<Empleado> getJefes();
}
