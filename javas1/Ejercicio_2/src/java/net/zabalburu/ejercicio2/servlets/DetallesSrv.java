/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zabalburu.ejercicio2.modelo.Producto;
import net.zabalburu.ejercicio2.modelo.Proveedor;
import net.zabalburu.ejercicio2.servicio.ProductosServicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "DetallesSrv", urlPatterns = {"/detalles"})
public class DetallesSrv extends HttpServlet {
    private ProductosServicio servicio = new ProductosServicio();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Producto p = servicio.getProducto(id);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetallesSrv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Detalles del Producto</h1>");
            out.println("<table border=1>"); 
            out.println("<tr><td>Id:</td><td>"+p.getIdProducto() +"</td></tr>");
            out.println("<tr><td>Nombre:</td><td>"+p.getNombre()+"</td></tr>");
            Proveedor pr = servicio.getProveedor(p.getIdProveedor());
            out.println("<tr><td>Proveedor:</td><td>" +
                    pr.getNombre() + "<br>" +
                    "Contacto : " + pr.getContacto() + "<br>" +
                    pr.getDireccion() + "<br>" +
                    pr.getCodPostal() + " - " + pr.getCiudad() + "(" +
                    pr.getPais() + ")<br>" +
                    "Teléfono : " + pr.getTelefono() + "</td></tr>");
            out.println("<tr><td>Precio Unitario : " +
                    NumberFormat.getCurrencyInstance().format(p.getPrecioUnitario()) +
                    "</td></tr>");
            out.println("<tr><td>Cantidad Por unidad</td><td>" + 
                    p.getCantidadPorUnidad() + "</td></tr>");
            out.println("<tr><td>Unidades En Stock</td><td>" +
                    p.getUnidadesEnStock() + "</td></tr>");
            out.println("<tr><td>Unidades En Pedido</td><td>" +
                    p.getUnidadesEnPedido()+ "</td></tr>");        
            out.println("</table>");
            out.println("<a href='productos'>Volver</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
