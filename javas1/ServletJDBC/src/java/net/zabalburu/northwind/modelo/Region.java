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
public class Region {
    private Integer regionId;
    private String descripcion;
    

    public Region() {
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        final Region other = (Region) obj;
        if (!Objects.equals(this.regionId, other.regionId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Region{" + "regionId=" + regionId + ", descripcion=" + descripcion + '}';
    }

    
    
}
