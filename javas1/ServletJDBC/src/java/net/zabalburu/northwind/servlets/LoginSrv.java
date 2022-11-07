/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zabalburu.northwind.modelo.Empleado;
import net.zabalburu.northwind.servicio.Servicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "LoginSrv", urlPatterns = {"/LoginSrv"})
public class LoginSrv extends HttpServlet {
    private Servicio servicio = new Servicio();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String strId = request.getParameter("id");
        String extension = request.getParameter("extension");
        Empleado emp;
        if (accion != null){
            emp = servicio.login(Integer.parseInt(strId), extension);
            if (emp != null){
                response.sendRedirect("RegionSrv");
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginSrv</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido</h1>");
            out.println("<form action='" + request.getRequestURI() +"'>");
            out.println("<table><tr><td>Empleado</td><td>" +
                    "<select name='id'>");
            for(Empleado e : servicio.getEmpleados()){
                out.println("<option value='" + e.getEmpId() +"' " +
                        ((strId!=null && strId.equals(""+e.getEmpId())?"SELECTED":"")) +
                        ">" +
                        e.nombreCompleto() + "</option>");
            }
            out.println("</select></td></tr>");
            out.println("<tr><td>Clave</td><td><input type='password' " +
                    "name='extension'></td></tr>");
            out.println("</table>");
            out.println("<input type='submit' name='accion' value='Entrar'>");
            out.println("</form>");
            
            // Escribir el posible error
            if (accion != null){
                out.println("<h3>Clave errónea</h3>");
            }
            
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
