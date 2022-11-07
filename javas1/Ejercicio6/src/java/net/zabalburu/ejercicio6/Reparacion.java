/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio6;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ichueca
 */
public class Reparacion {
    private Integer repNo;
    private String usuario;
    private String elemento;
    private Date fechaSolicitud;
    private String descripcion;
    private Date fechaReparacion;
    private Double coste;
    private String reparador;

    public Reparacion() {
    }

    public Integer getRepNo() {
        return repNo;
    }

    public void setRepNo(Integer repNo) {
        this.repNo = repNo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(Date fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public String getReparador() {
        return reparador;
    }

    public void setReparador(String reparador) {
        this.reparador = reparador;
    }

    @Override
    public String toString() {
        return "Reparacion{" + "repNo=" + repNo + ", usuario=" + usuario + ", elemento=" + elemento + ", fechaSolicitud=" + fechaSolicitud + ", descripcion=" + descripcion + ", fechaReparacion=" + fechaReparacion + ", coste=" + coste + ", reparador=" + reparador + '}';
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
        final Reparacion other = (Reparacion) obj;
        if (!Objects.equals(this.repNo, other.repNo)) {
            return false;
        }
        return true;
    }
    
    
}
