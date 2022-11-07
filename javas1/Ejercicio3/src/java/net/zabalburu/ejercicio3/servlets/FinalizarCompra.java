/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "FinCompra", urlPatterns = {"/FinCompra"})
public class FinalizarCompra extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        String visa = request.getParameter("visa");
        String accion = request.getParameter("accion");
        if (accion != null){
            if (!nombre.isEmpty() && !direccion.isEmpty() && 
                    !visa.isEmpty()){
                // Todo OK
                request.getSession().invalidate();
                response.sendRedirect("gracias.html");
                return;
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinalizarCompra</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Por favor, complete la siguiente información</h1>");
            out.println("<form action='" + request.getRequestURI() + "'>");
            out.println("<table border=1><tr><td>Nombre : </td>" +
                    "<td><input type=text name=nombre value=" + ((accion!=null)?nombre:"") + ">" +
                    
                    ((accion!=null && nombre.isEmpty())?"Nombre no puede estar vacío":"") +
                    "</td></tr>" +
                    "<tr><td>Dirección de Entrega : </td>" +
                    "<td><input type=text name=direccion value=" + ((accion!=null)?direccion:"") + 
                            ((accion!=null && direccion.isEmpty())?"Dirección no puede estar vacía":"") +
                    "</td></tr>" +
                    "<tr><td>Nº VISA : </td>" +
                    "<td><input type=text name=visa value=" + ((accion!=null)?visa:"") + 
                            ((accion!=null && visa.isEmpty())?"VISA no puede estar vacío":"") +
                    "</td></tr>" +
                    "</table><br>");
            out.println("<input type=submit name=accion value='Enviar Datos'>");
            out.println("</form>");
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
