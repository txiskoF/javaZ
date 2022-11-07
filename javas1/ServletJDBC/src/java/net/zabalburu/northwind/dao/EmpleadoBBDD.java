/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.northwind.modelo.Empleado;
import net.zabalburu.nortwind.util.Conexion;

/**
 *
 * @author ichueca
 */
public class EmpleadoBBDD implements EmpleadoDAO{

    @Override
    public Empleado getEmpleado(Integer id) {
        PreparedStatement pst = null;
        ResultSet rst = null;
        Empleado e = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Employees " +
                            "where employeeId=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            if (rst.next()){
                e = cargarEmpleado(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion
                    .getConexion()
                    .createStatement()
                    .executeQuery("Select * From Employees Order by lastname");
            while (rst.next()){
                empleados.add(cargarEmpleado(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    @Override
    public List<Empleado> getEmpleadosRegion(Integer regionId) {
        List<Empleado> empleados = new ArrayList<Empleado>();
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement(
                    "Select distinct e.EmployeeId, lastname, firstname, title "
                    + "From Employees e , EmployeeTerritories et, Territories t, Region r "
                    + "where e.employeeid = et.employeeid and et.territoryid = t.territoryid "
                    + "and t.regionid = r.regionid and r.regionid = ?");
            pst.setInt(1, regionId);
            rst = pst.executeQuery();
            while (rst.next()){
                empleados.add(cargarEmpleado(rst));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    
    private Empleado cargarEmpleado(ResultSet rst){
        Empleado e = new Empleado();
        try {
            e.setEmpId(rst.getInt("employeeid"));
            e.setApellido(rst.getString("lastname"));
            e.setNombre(rst.getString("firstname"));
            e.setPuesto(rst.getString("title"));
            e.setExtension(rst.getString("extension"));
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoBBDD();
        /*System.out.println(dao.getEmpleado(4));
        System.out.println(dao.getEmpleado(-1));
        for(Empleado e : dao.getEmpleados()){
            System.out.println(e);
        }*/
        System.out.println(dao.getEmpleadosRegion(1));
        System.out.println(dao.getEmpleadosRegion(-1));
    }
    
}
