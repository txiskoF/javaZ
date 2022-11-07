/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.util.Conexion;

/**
 *
 * @author ichueca
 */
public class LibroBBDD implements LibroDAO{

    @Override
    public List<Libro> getLibros() {
        ResultSet rst;
        List<Libro> libros = new ArrayList<>();
        try {
            rst = Conexion.
                    getConexion().
                    createStatement().
                    executeQuery("Select * From Titles Order By title");
            while (rst.next()){
                libros.add(cargarLibro(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    @Override
    public Libro getLibro(String idLibro) {
        PreparedStatement pst;
        ResultSet rst;
        Libro l = null;
        try {
            pst = Conexion.
                    getConexion()
                    .prepareStatement("Select * From Titles where title_id=?");
            pst.setString(1, idLibro);
            rst = pst.executeQuery();
            if (rst.next()){
                l = cargarLibro(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    private Libro cargarLibro(ResultSet rst) {
        Libro l = new Libro();
        try {
            l.setIdLibro(rst.getString("title_id"));
            l.setPrecio(rst.getDouble("price"));
            l.setTipo(rst.getString("type"));
            l.setTitulo(rst.getString("title"));
        } catch (SQLException ex) {
            Logger.getLogger(LibroBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
}
