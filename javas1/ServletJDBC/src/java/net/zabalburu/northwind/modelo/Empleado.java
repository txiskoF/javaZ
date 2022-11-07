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
public class Empleado {
    private Integer empId;
    private String apellido;
    private String nombre;
    private String puesto;
    private String extension;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.empId, other.empId)) {
            return false;
        }
        return true;
    }

    public Empleado() {
    }

    public Empleado(String apellido, String nombre, String puesto) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String nombreCompleto(){
        return this.apellido + ", " + this.nombre;
    }
    
    @Override
    public String toString() {
        return "Empleado{" + "empId=" + empId + ", apellido=" + apellido + ", nombre=" + nombre + ", puesto=" + puesto + '}';
    }
    
    
}
