/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio8.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio8.modelo.Album;
import net.zabalburu.ejercicio8.modelo.Artista;
import net.zabalburu.ejercicio8.modelo.Cancion;
import net.zabalburu.ejercicio8.modelo.Usuario;
import net.zabalburu.ejercicio8.util.Conexion;

/**
 *
 * @author ichueca
 */
public class ChinookDAO {

    public Usuario getUsuario(String nombre){
        Usuario u = null;
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select * From Usuarios where nombre=?");
            pst.setString(1, nombre);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                u = cargarUsuario(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public List<String> getInicialesArtistas() {
        List<String> iniciales = new ArrayList<>();
        ResultSet rst;
        try {
            rst = Conexion.getConexion()
                    .createStatement()
                    .executeQuery("select distinct left(name,1) inicial from artist Order By left(name,1)");
            while (rst.next()) {
                iniciales.add(rst.getString("inicial"));
            }
            rst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iniciales;
    }

    public List<Artista> getArtistasInicial(String letra) {
        List<Artista> artistas = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select * From Artist where left(upper(name),1)=upper(?)");
            pst.setString(1, letra);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                artistas.add(cargarArtista(rst));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artistas;
    }
    
    public Artista getArtista(Integer id) {
        Artista artista = null;
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select * From Artist where artistId=?");
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                artista = cargarArtista(rst);
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return artista;
    }

    public Album getAlbum(Integer id) {
        Album album = null;
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select * from Album where albumId=?");
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                album = cargarAlbum(rst, this.getArtista(rst.getInt("artistId")));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return album;
    }
    
    public Cancion getCancion(Integer id) {
        Cancion cancion = null;
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select trackId, t.name, g.name genero, albumId, milliseconds, bytes, unitPrice "+
                            "From Track t, Genre g " +
                            "where trackId=? and t.genreId = g.genreId ");
            pst.setInt(1, id);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                cancion = cargarCancion(rst, this.getAlbum(rst.getInt("albumId")) );
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cancion;
    }
    
    public List<Album> getAlbumesArtista(Artista artista) {
        List<Album> albumes = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select * From Album where artistid=? Order By title");
            pst.setInt(1, artista.getId());
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                albumes.add(cargarAlbum(rst,artista));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albumes;
    }

    public List<Cancion> getCancionesAlbum(Album album) {
        List<Cancion> canciones = new ArrayList<>();
        try {
            PreparedStatement pst = Conexion.getConexion().
                    prepareStatement(
                            "Select trackId, t.name, g.name genero, albumId, milliseconds, bytes, unitPrice "+
                            "From Track t, Genre g " +
                            "where albumid=? and t.genreId = g.genreId Order By trackid");
            pst.setInt(1, album.getId());
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                canciones.add(cargarCancion(rst, album));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return canciones;
    }

    private Artista cargarArtista(ResultSet rst) {
        Artista a = new Artista();
        try {
            a.setId(rst.getInt("artistId"));
            a.setNombre(rst.getString("name"));
            a.setAlbumes(this.getAlbumesArtista(a));
        } catch (SQLException ex){
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    private Album cargarAlbum(ResultSet rst, Artista artista) {
        Album a = new Album();
        try {
            a.setId(rst.getInt("albumId"));
            a.setTitulo(rst.getString("title"));
            a.setIdArtista(rst.getInt("artistId"));
            a.setCanciones(this.getCancionesAlbum(a));
            a.setArtista(artista);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    
    
    private Cancion cargarCancion(ResultSet rst, Album album) {
        Cancion a = new Cancion();
        try {
            a.setId(rst.getInt("trackId"));
            a.setBytes(rst.getInt("bytes"));
            a.setDuracion(rst.getInt("milliseconds"));
            a.setGenero(rst.getString("genero"));
            a.setIdAlbum(rst.getInt("albumId"));
            a.setNombre(rst.getString("name"));
            a.setPrecio(rst.getDouble("unitPrice"));
            a.setAlbum(album);
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    private Usuario cargarUsuario(ResultSet rst) {
        Usuario u = new Usuario();
        try {
            u.setId(rst.getInt("id"));
            u.setNombre(rst.getString("nombre"));
            u.setHash(rst.getString("hash"));
            u.setSalto(rst.getString("salt"));
            u.setSexo(rst.getString("sexo"));
        } catch (SQLException ex) {
            Logger.getLogger(ChinookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    
    public static void main(String[] args) {
        ChinookDAO dao = new ChinookDAO();
        /*System.out.println(dao.getUsuario("marta"));
        System.out.println(dao.getInicialesArtistas());
        List<Artista> artistas = dao.getArtistasInicial("a");
        for(Artista a : artistas){
            System.out.println(a.getNombre());
            for(Album al : a.getAlbumes()){
                System.out.println("\t"+al.getTitulo());
                for(Cancion c : al.getCanciones()){
                    System.out.println("\t\t" + c.getNombre());
                }
            }
        }*/
        System.out.println(dao.getCancion(1).getAlbum().getArtista());
    }
}
