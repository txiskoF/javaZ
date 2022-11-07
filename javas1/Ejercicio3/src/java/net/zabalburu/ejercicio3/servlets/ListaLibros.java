/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.servicio.LibroService;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "ListaLibros", urlPatterns = {"/ListaLibros"})
public class ListaLibros extends HttpServlet {
    private LibroService service = new LibroService();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaLibros</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Libros</h1>");
            out.println("<table border=1><tr><th>#</th><th>Título</th><th>Tipo</th>"+
                    "<th>Precio</th><th></th></tr>");
            for(Libro l : service.getLibros()){
                out.println("<tr><td>" + l.getIdLibro() + "</td><td>" +
                        l.getTitulo() + "</td><td>" + l.getTipo() + "</td><td>" +
                        nf.format(l.getPrecio()) + "</td><td>" +
                        "<a href='GestionCarrito?idLibro=" + l.getIdLibro() + "&accion=Añadir'>Comprar</a></td></tr>");
            }
            out.println("</table>");
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
