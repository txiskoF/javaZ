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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio6.Usuario;
import net.zabalburu.ejercicio6.util.Conexion;

/**
 *
 * @author ichueca
 */
public class UsuarioDAO {
    public Usuario getUsuario(String nombre){
        PreparedStatement pst = null;
        ResultSet rst = null;
        Usuario u = null;
        try {
            pst = Conexion.getConexion()
                    .prepareStatement("Select * From Usuarios Where nombre=?");
            pst.setString(1, nombre);
            rst = pst.executeQuery();
            if (rst.next()){
                u = crearUsuario(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        ResultSet rst = null;
        
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * From Usuarios Order by nombre");
            while (rst.next()){
                usuarios.add(crearUsuario(rst));
            }
            rst .close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }

    private Usuario crearUsuario(ResultSet rst) {
        Usuario u = new Usuario();
        try {
            u.setNombre(rst.getString("nombre"));
            u.setPassword(rst.getString("contraseña"));
            u.setRol(rst.getString("rol"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        for(Usuario u : dao.getUsuarios()){
            System.out.println(u);
        }
        System.out.println(dao.getUsuario("marta"));
        System.out.println(dao.getUsuario("iñigo"));
    }
}
