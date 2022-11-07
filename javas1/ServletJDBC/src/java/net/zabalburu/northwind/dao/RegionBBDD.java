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
import net.zabalburu.northwind.modelo.Region;
import net.zabalburu.nortwind.util.Conexion;

/**
 *
 * @author ichueca
 */
public class RegionBBDD implements RegionDAO{

    @Override
    public Region getRegion(Integer id) {
        PreparedStatement pst = null;
        ResultSet rst = null;
        Region r = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Region " +
                        "where regionId=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            if (rst.next()){
                r = cargarRegion(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public List<Region> getRegiones() {
        List<Region> regiones = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion
                    .getConexion()
                    .createStatement()
                    .executeQuery("Select * From Region");
            while (rst.next()){
                regiones.add(cargarRegion(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(RegionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return regiones;
    }
    
    private Region cargarRegion(ResultSet rst){
        Region r = new Region();
        try {
            r.setRegionId(rst.getInt("regionId"));
            r.setDescripcion(rst.getString("regiondescription"));
        } catch (SQLException ex) {
            Logger.getLogger(RegionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public static void main(String[] args) {
        RegionDAO dao = new RegionBBDD();
        EmpleadoDAO daoEmp = new EmpleadoBBDD();
        for(Region r : dao.getRegiones()){
            System.out.println(r);
            for(Empleado e : daoEmp.getEmpleadosRegion(r.getRegionId())) {
                System.out.println("\t" + e);
            }
            System.out.println("================================");
        }
    }
    
}
