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
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio3.modelo.Libro;
import net.zabalburu.ejercicio3.servicio.Carrito;
import net.zabalburu.ejercicio3.servicio.LibroService;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "GestionCarrito", urlPatterns = {"/GestionCarrito"})
public class GestionCarrito extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        Carrito carrito;
        if (sesion.isNew()) {
            carrito = new Carrito();
        } else {
            carrito = (Carrito) sesion.getAttribute("carrito");
        }
        String accion = request.getParameter("accion");
        if (accion == null) {
            response.sendRedirect("ListaLibros");
            return;
        } else if (accion.equals("Añadir")) {
            carrito.añadirLibro(service.getLibro(request.getParameter("idLibro")));
        } else if (accion.equals("Quitar")) {
            String[] idLibros = request.getParameterValues("idLibro");
            for (String id : idLibros) {
                carrito.eliminarLibro(id);
            }
        }
        sesion.setAttribute("carrito", carrito);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionCarrito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Libros Seleccionados</h1>");

            if (carrito.getLibros().isEmpty()) {
                out.println("<h3>No hay libros seleccionados</h3>"); 
            } else {

                out.println("<form action=GestionCarrito>");
                out.println("<table border=1><tr><th>#</th><th>Título</th>"
                        + "<th>Tipo</th><th>Precio</th><th></th></tr>");
                for (Libro l : carrito.getLibros()) {
                    out.println("<tr><td>" + l.getIdLibro() + "</td><td>"
                            + l.getTitulo() + "</td><td>" + l.getTipo() + "</td><td>"
                            + nf.format(l.getPrecio()) + "</td><td>"
                            + "<input type='checkbox' name='idLibro' value='" + l.getIdLibro() + "'></td></tr>");
                }
                out.println("</table>");
                out.println("<input type='submit' name='accion' value='Quitar'>");
                out.println("</form>");
                out.println("<h3>Importe de la compra : " + nf.format(carrito.getImporteCompra()) + "</h3>");
            }
            out.println("<a href='ListaLibros'>Volver</a> <a href='FinCompra'>Finalizar Compra</a>");
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
