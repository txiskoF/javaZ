/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.modelo;

import java.util.Objects;

/**
 *
 * @author ichueca
 */
public class Territorio {
    private Integer territorioId;
    private String descripcion;
    private String region;

    public Territorio() {
    }

    public Integer getTerritorioId() {
        return territorioId;
    }

    public void setTerritorioId(Integer territorioId) {
        this.territorioId = territorioId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
        final Territorio other = (Territorio) obj;
        if (!Objects.equals(this.territorioId, other.territorioId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Territorio{" + "territorioId=" + territorioId + ", descripcion=" + descripcion + ", region=" + region + '}';
    }
    
}
