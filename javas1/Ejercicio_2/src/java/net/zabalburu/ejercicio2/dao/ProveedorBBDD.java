/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio2.modelo.Producto;
import net.zabalburu.ejercicio2.modelo.Proveedor;
import net.zabalburu.ejercicio2.util.Conexion;

/**
 *
 * @author ichueca
 */
public class ProveedorBBDD implements ProveedorDAO{

    @Override
    public Proveedor getProveedor(Integer id) {
        PreparedStatement pst;
        ResultSet rst;
        Proveedor p = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Suppliers "+
                            "where supplierId=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            if (rst.next()){
                p = cargarProveedor(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    private Proveedor cargarProveedor(ResultSet rst) {
        Proveedor p = new Proveedor();
        try {
            p.setCiudad(rst.getString("city"));
            p.setCodPostal(rst.getString("postalcode"));
            p.setContacto(rst.getString("contactname"));
            p.setDireccion(rst.getString("address"));
            p.setIdProveedor(rst.getInt("supplierid"));
            p.setNombre(rst.getString("companyname"));
            p.setPais(rst.getString("country"));
            p.setRegion(rst.getString("region"));
            p.setTelefono(rst.getString("phone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
}
