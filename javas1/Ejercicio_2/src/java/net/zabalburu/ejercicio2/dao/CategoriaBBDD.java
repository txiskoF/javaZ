/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio2.modelo.Categoria;
import net.zabalburu.ejercicio2.util.Conexion;

/**
 *
 * @author ichueca
 */
public class CategoriaBBDD implements CategoriaDAO {

    @Override
    public List<Categoria> getCategorias() {

        List<Categoria> categorias = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion().createStatement()
                    .executeQuery("Select * From Categories "
                            + "Order By categoryname");
            while (rst.next()) {
                categorias.add(cargarCategoria(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;

    }

    private Categoria cargarCategoria(ResultSet rst) {
        Categoria c = new Categoria();
        try {
            c.setIdCategoria(rst.getInt("categoryid"));
            c.setNombre(rst.getString("categoryname"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

}
