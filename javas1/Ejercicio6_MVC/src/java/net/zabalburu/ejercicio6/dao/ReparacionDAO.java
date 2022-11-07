/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio6.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio6.Reparacion;
import net.zabalburu.ejercicio6.util.Conexion;

/**
 *
 * @author ichueca
 */
public class ReparacionDAO {
    public Reparacion getReparacion(Integer repNo){
        PreparedStatement pst = null;
        ResultSet rst = null;
        Reparacion r = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Reparaciones Where rep_no=?");
            pst.setInt(1, repNo);
            rst = pst.executeQuery();
            if (rst.next()){
                r = crearReparacion(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List<Reparacion> getReparaciones(){
        List<Reparacion> reparaciones = new ArrayList<>();
        ResultSet rst = null;
        
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * From Reparaciones Order by rep_no");
            while (rst.next()){
                reparaciones.add(crearReparacion(rst));
            }
            rst .close();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reparaciones;
    }
    
    public void añadirReparacion(Reparacion r){
        PreparedStatement pst = null;
        try {
            pst = Conexion.getConexion()
                .prepareStatement(
                    "Insert Into Reparaciones(usuario,elemento,fechaSolicitud,descripcion) " +
                    "values(?,?,?,?)");
            pst.setString(1, r.getUsuario());
            pst.setString(2, r.getElemento());
            Date fecha = (r.getFechaSolicitud()==null)?new Date():r.getFechaSolicitud();
            pst.setDate(3, new java.sql.Date(fecha.getTime()));
            pst.setString(4, r.getDescripcion());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarReparacion(Integer repNo){
        PreparedStatement pst = null;
        try {
            pst = Conexion.getConexion()
                .prepareStatement(
                    "Delete Reparaciones where rep_no=?");
            pst.setInt(1, repNo);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reparar(Reparacion r){
        PreparedStatement pst = null;
        try {
            pst = Conexion.getConexion()
                .prepareStatement(
                    "Update Reparaciones set fechaReparacion=?,reparador=?,coste=? " +
                    "where rep_no=?");
            pst.setDate(1, new java.sql.Date(r.getFechaReparacion().getTime()));
            pst.setString(2, r.getReparador());
            pst.setDouble(3, r.getCoste());
            pst.setInt(4, r.getRepNo());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Reparacion crearReparacion(ResultSet rst) {
        Reparacion r = new Reparacion();
        try {
            r.setCoste(rst.getDouble("coste"));
            r.setDescripcion(rst.getString("descripcion"));
            r.setElemento(rst.getString("elemento"));
            r.setFechaReparacion(rst.getDate("fechaReparacion"));
            r.setFechaSolicitud(rst.getDate("fechaSolicitud"));
            r.setRepNo(rst.getInt("rep_no"));
            r.setReparador(rst.getString("reparador"));
            r.setUsuario(rst.getString("usuario"));
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public static void main(String[] args) {
        ReparacionDAO dao = new ReparacionDAO();
        for(Reparacion r : dao.getReparaciones()){
            System.out.println(r);
        }
        
        Reparacion r = new Reparacion();
        r.setUsuario("marta");
        r.setElemento("Internet");
        r.setDescripcion("No me funciona!!");
        
        r.setRepNo(6);
        r.setCoste(0.0);
        r.setReparador("javi");
        r.setFechaReparacion(new Date());
        //dao.reparar(r);
        dao.añadirReparacion(r);
        System.out.println(dao.getReparacion(7));
        dao.eliminarReparacion(7);
        System.out.println(dao.getReparacion(7));
        
    }
    
}
