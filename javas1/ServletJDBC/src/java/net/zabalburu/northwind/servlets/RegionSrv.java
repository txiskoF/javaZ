/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.northwind.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zabalburu.northwind.modelo.Empleado;
import net.zabalburu.northwind.modelo.Region;
import net.zabalburu.northwind.servicio.Servicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "RegionSrv", urlPatterns = {"/RegionSrv"})
public class RegionSrv extends HttpServlet {
    private Servicio servicio = new Servicio();
    private List<Region> regiones;
    private int pos;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        regiones = servicio.getRegiones();
    }
    
    
    
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
        // Cada botón se llame distinto
        /*if (request.getParameter("primero")!=null){
            pos = 0;
        }
        if (request.getParameter("anterior")!=null){
            pos--;
        }
        if (request.getParameter("siguiente")!=null &&
                request.getParameter("siguiente").equals("Siguiente")){
            pos++;
        }
        if (request.getParameter("ultimo")!=null){
            pos = regiones.size()-1;
        }*/
        
        String accion = request.getParameter("accion");
        if (accion != null){
            switch (accion) {
                case "Anterior":
                    pos--;
                    break;
                case "Primero":
                    pos = 0;
                    break;
                case "Siguiente":
                    pos++;
                    break;
                case "Ultimo":
                    pos = regiones.size()-1;
                    break;
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegionSrv</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Región : " + regiones.get(pos).getDescripcion()+ "</h1>");
            out.println("<table border=1><tr><th>Id. Empleado</th><th>Empleado</th>" +
                  "<th>Puesto</th></tr>");  
            List<Empleado> empleados = servicio.getEmpleadosRegion(
                regiones.get(pos).getRegionId());
            
            for(Empleado e : empleados){
                out.println("<tr><td>" + e.getEmpId() + "</td>" +
                        "<td>" + e.nombreCompleto() + "</td>" +
                        "<td>" + e.getPuesto() + "</td></tr>");
            }
            out.println("</table><br>");
            
            out.println("<form action='" + request.getRequestURI() + "'>"); 
            /*out.println("<input type='submit' name='primero' value='Primero'>");
            out.println("<input type='submit' name='anterior' value='Anterior'>");
            out.println("<input type='submit' name='siguiente' value='Siguiente'>");
            out.println("<input type='submit' name='ultimo' value='Último'>");*/
            out.println("<input type='submit' name='accion' value='Primero' " + 
                    ((pos==0)?"DISABLED":"") +">");
            out.println("<input type='submit' name='accion' value='Anterior' " + 
                    ((pos==0)?"DISABLED":"") +">");
            out.println((pos+1) + " / " + regiones.size());
            out.println("<input type='submit' name='accion' value='Siguiente' " + 
                    ((pos==regiones.size()-1)?"DISABLED":"") +">");
            out.println("<input type='submit' name='accion' value='Ultimo' " + 
                    ((pos==regiones.size()-1)?"DISABLED":"") +">");
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
