/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio4.dao;

import java.util.List;
import net.zabalburu.ejercicio4.modelo.Pedido;

/**
 *
 * @author ichueca
 */
public interface PedidoDAO {
    List<Pedido> getPedidos(Integer idEmpleado);
}
