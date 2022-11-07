/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio7.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio7.Pregunta;
import net.zabalburu.ejercicio7.util.Conexion;

/**
 *
 * @author ichueca
 */
public class PreguntaDAO {
    private UsuarioDAO userDAO = new UsuarioDAO();
    public List<Pregunta> getPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion()
                    .createStatement()
                    .executeQuery(
                            "Select * From Pregunta "
                            + "where respuestaA = 0");
            while (rst.next()) {
                preguntas.add(crearPregunta(rst));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preguntas;
    }

    private List<Pregunta> getRespuestas(Integer idPregunta) {
        List<Pregunta> respuestas = new ArrayList<>();
        ResultSet rst;
        try {
            PreparedStatement pst = Conexion.getConexion()
                    .prepareStatement(
                            "Select * From Pregunta "
                            + "where respuestaA =?");
            pst.setInt(1, idPregunta);
            rst = pst.executeQuery();
            while (rst.next()) {
                respuestas.add(crearPregunta(rst));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuestas;
    }

    public Pregunta getPregunta(Integer idPregunta) {
        Pregunta p = null;
        ResultSet rst;
        try {
            PreparedStatement pst = Conexion.getConexion()
                    .prepareStatement(
                            "Select * From Pregunta "
                            + "where id =?");
            pst.setInt(1, idPregunta);
            rst = pst.executeQuery();
            if (rst.next()) {
                p = crearPregunta(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public void nuevaPregunta(Pregunta p) {
        PreparedStatement pst;
        try {
            pst = Conexion.getConexion()
                .prepareStatement(
                "Insert into pregunta(usuario,fecha,texto,respuestaA) "
                + "values(?,?,?,?)");
            pst.setString(1, p.getUsuario().getNombre());
            pst.setDate(2, new java.sql.Date(p.getFecha().getTime()));
            pst.setString(3, p.getTexto());
            pst.setInt(4, p.getRespuestaA());
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Pregunta crearPregunta(ResultSet rst) {
        Pregunta p = new Pregunta();
        try {
            p.setFecha(rst.getDate("fecha"));
            p.setId(rst.getInt("id"));
            p.setRespuestaA(rst.getInt("respuestaA"));
            p.setTexto(rst.getString("texto"));
            p.setUsuario(userDAO.getUsuario(rst.getString("usuario")));
            List<Pregunta> resps = getRespuestas(p.getId());
            p.setRespuestas(resps);
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static void main(String[] args) {
        PreguntaDAO dao = new PreguntaDAO();
        /*Pregunta p = new Pregunta();
        p.setUsuario("ana");
        GregorianCalendar gc = new GregorianCalendar(2019,9,15);
        p.setFecha(gc.getTime());
        p.setTexto("Cómo se puede mostrar un campo de un objeto en JSP");
        p.setRespuestaA(0);
        dao.nuevaPregunta(p);
        p = new Pregunta();
        p.setUsuario("argeme");
        p.setFecha(new Date());
        p.setTexto("Puedes emplear EL ( ${objeto.campo} )");
        p.setRespuestaA(1);
        dao.nuevaPregunta(p);*/
        /*for(Pregunta pr : dao.getPreguntas()){
            System.out.println(pr);
            
        }*/
        System.out.println(dao.getPregunta(2));
    }
    
}
