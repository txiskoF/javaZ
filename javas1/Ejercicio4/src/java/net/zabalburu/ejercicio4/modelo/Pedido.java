/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio4.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ichueca
 */
public class Pedido {
    private Integer idPedido;
    private String cliente;
    private Date fecha;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", cliente=" + cliente + ", fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.idPedido, other.idPedido)) {
            return false;
        }
        return true;
    }
}
