/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.modelo;

import java.util.Objects;

/**
 *
 * @author ichueca
 */
public class Producto {
    private Integer idProducto;
    private String nombre;
    private Integer idProveedor;
    private Double precioUnitario;
    private String cantidadPorUnidad;
    private Integer unidadesEnStock;
    private Integer unidadesEnPedido;
    private Integer idCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    public Integer getUnidadesEnStock() {
        return unidadesEnStock;
    }

    public void setUnidadesEnStock(Integer unidadesEnStock) {
        this.unidadesEnStock = unidadesEnStock;
    }

    public Integer getUnidadesEnPedido() {
        return unidadesEnPedido;
    }

    public void setUnidadesEnPedido(Integer unidadesEnPedido) {
        this.unidadesEnPedido = unidadesEnPedido;
    }
    

    public Producto() {
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", idProveedor=" + idProveedor + ", precioUnitario=" + precioUnitario + ", cantidadPorUnidad=" + cantidadPorUnidad + ", unidadesEnStock=" + unidadesEnStock + ", unidadesEnPedido=" + unidadesEnPedido + ", idCategoria=" + idCategoria + '}';
    }

    
    
}
