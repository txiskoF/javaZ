/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio7;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ichueca
 */
public class Pregunta {
    private Integer id;
    private Usuario usuario;
    private Date fecha;
    private String texto;
    private Integer respuestaA;
    private List<Pregunta> respuestas;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Pregunta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Pregunta> respuestas) {
        this.respuestas = respuestas;
    }
    
    public Pregunta(){
        
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", texto=" + texto + ", respuestaA=" + respuestaA + ", respuestas=" + respuestas + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pregunta other = (Pregunta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getRespuestaA() {
        return respuestaA;
    }

    public void setRespuestaA(Integer respuestaA) {
        this.respuestaA = respuestaA;
    }
}
