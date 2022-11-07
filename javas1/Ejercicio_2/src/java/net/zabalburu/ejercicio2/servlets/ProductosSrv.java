/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zabalburu.ejercicio2.modelo.Categoria;
import net.zabalburu.ejercicio2.modelo.Producto;
import net.zabalburu.ejercicio2.servicio.ProductosServicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "ProductosSrv", urlPatterns = {"/productos"})
public class ProductosSrv extends HttpServlet {
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
        List<Categoria> categorias = servicio.getCategorias();
        Integer idCategoria;
        if (request.getParameter("accion")!=null){
            idCategoria = Integer.parseInt(request.getParameter("categoria"));
        } else {
            idCategoria = categorias.get(0).getIdCategoria();
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductosSrv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Productos</h1>");
            out.println("<form action='" + request.getRequestURI() +"'>");
            out.println("Seleccionar Categoria ");
            out.println("<select name='categoria'>");
            for(Categoria c : categorias){
                out.println("<option value=" + c.getIdCategoria() +
                        ((idCategoria == c.getIdCategoria())?" SELECTED":"")
                        + ">" +
                        c.getNombre() + "</option>");
            }
            out.println("</select><br>");
            out.println("<input type='submit' name='accion' value='Buscar'>");
            out.println("</form>");
            
            out.println("<h2>Productos</h2>");
            out.println("<table border=1><tr><th>#</th><th>Nombre</th>" +
                    "<th>Proveedor</th><th></th></tr>");
            List<Producto> productos = servicio.getProductosCategoria(idCategoria);
            for(Producto p : productos){
                out.println("<tr><td>" + p.getIdProducto() + "</td><td>" +
                        p.getNombre() + "</td><td>" +
                        servicio.getProveedor(p.getIdProveedor()).getNombre() +
                        "</td><td><a href='detalles?id=" + p.getIdProducto() +
                        "'>Detalles</a></td></tr>");
            }
            out.println("</table><br>");
            out.println("Se han encontrado " + productos.size() + 
                    " productos");
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
