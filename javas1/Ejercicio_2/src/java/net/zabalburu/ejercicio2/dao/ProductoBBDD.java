/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio2.modelo.Producto;
import net.zabalburu.ejercicio2.util.Conexion;

/**
 *
 * @author ichueca
 */
public class ProductoBBDD implements ProductoDAO{

    @Override
    public Producto getProducto(Integer id) {
        PreparedStatement pst;
        ResultSet rst;
        Producto p = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Products "+
                            "where productId=?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            if (rst.next()){
                p = cargarProducto(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public List<Producto> getProductosCategoria(Integer id) {
        List<Producto> productos = new ArrayList<>();
        PreparedStatement pst;
        ResultSet rst;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Products "+
                            "where categoryId=? "+
                            "order by productname");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()){
                productos.add(cargarProducto(rst));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    private Producto cargarProducto(ResultSet rst) {
        Producto p = new Producto();
        try {
            p.setCantidadPorUnidad(rst.getString("quantityperunit"));
            p.setIdCategoria(rst.getInt("categoryid"));
            p.setIdProducto(rst.getInt("productid"));
            p.setIdProveedor(rst.getInt("supplierid"));
            p.setNombre(rst.getString("productname"));
            p.setPrecioUnitario(rst.getDouble("unitprice"));
            p.setUnidadesEnPedido(rst.getInt("unitsonorder"));
            p.setUnidadesEnStock(rst.getInt("unitsinstock"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
    
}
