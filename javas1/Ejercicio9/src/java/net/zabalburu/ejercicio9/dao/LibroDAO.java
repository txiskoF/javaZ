/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio9.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio8.util.Conexion;
import net.zabalburu.ejercicio9.modelo.Empleado;
import net.zabalburu.ejercicio9.modelo.Libro;

/**
 *
 * @author ichueca
 */
public class LibroDAO {
    public Empleado getEmpleado(String nombre, String apellidos){
        Empleado e = null;
        try {
            PreparedStatement pst = Conexion.getConexion()
                    .prepareStatement("Select * From Employee "+
                    "where fname=? and lname=?");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            ResultSet rst = pst.executeQuery();
            if (rst.next()){
                e = cargarEmpleado(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public List<Empleado> getEmpleados(){
        List<Empleado> empleados = new ArrayList<>();
        try {
            ResultSet rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * From Employee Order by lname,fname");
            while (rst.next()){
                empleados.add(cargarEmpleado(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    
    public Libro getLibro(String id){
        Libro l = null;
        try {
            PreparedStatement pst = Conexion.getConexion()
                    .prepareStatement("Select * From Titles "+
                    "where title_id=?");
            pst.setString(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()){
                l = cargarLibro(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Libro> getLibros(){
        List<Libro> libros = new ArrayList<>();
        try {
            ResultSet rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * From Titles Order by title");
            while (rst.next()){
                libros.add(cargarLibro(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }
    
    private Libro cargarLibro(ResultSet rst){
        Libro l = new Libro();
        try {
            l.setId(rst.getString("title_id"));
            l.setTitulo(rst.getString("title"));
            l.setTipo(rst.getString("type"));
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    private Empleado cargarEmpleado(ResultSet rst) {
        Empleado e = new Empleado();
        try {
            e.setApellidos(rst.getString("lname"));
            e.setId(rst.getString("emp_id"));
            e.setInicial(rst.getString("minit"));
            e.setNombre(rst.getString("fname"));
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();
        /*for (Empleado e : dao.getEmpleados()){
            System.out.println(e);
        }
        System.out.println(dao.getEmpleado("Paolo", "Accorti"));*/
        for(Libro l : dao.getLibros()){
            System.out.println(l);
        }
        System.out.println("--------");
        System.out.println(dao.getLibro("PC1035"));
    }
    
}
