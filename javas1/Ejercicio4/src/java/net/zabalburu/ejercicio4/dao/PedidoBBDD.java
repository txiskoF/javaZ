/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio4.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zabalburu.ejercicio4.modelo.Pedido;
import net.zabalburu.ejercicio4.util.Conexion;

/**
 *
 * @author ichueca
 */
public class PedidoBBDD implements PedidoDAO{
    
    @Override
    public List<Pedido> getPedidos(Integer idEmpleado) {
        PreparedStatement pst;
        ResultSet rst;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            pst = Conexion.getConexion()
                    .prepareStatement(
                        "Select o.orderId, companyName, orderDate " +
                        "From Orders o, Customers c " +
                        "where o.customerId = c.customerId " +
                        "and employeeId = ?"
                    );
            pst.setInt(1, idEmpleado);
            rst = pst.executeQuery();
            while (rst.next()) {
                pedidos.add(nuevoPedido(rst));
            }
            rst.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    private Pedido nuevoPedido(ResultSet rst) {
        Pedido p = new Pedido();
        try {
            p.setCliente(rst.getString("companyName"));
            p.setFecha(rst.getDate("orderDate"));
            p.setIdPedido(rst.getInt("orderId"));
        } catch (SQLException ex) {
            Logger.getLogger(PedidoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public static void main(String[] args) {
        PedidoDAO dao = new PedidoBBDD();
        for(Pedido p : dao.getPedidos(1)){
            System.out.println(p);
        }
    }
    
}
