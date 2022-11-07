/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio9.controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio9.ejbs.ListaLecturaPersonalEJB;
import net.zabalburu.ejercicio9.ejbs.RecomedacionEmpresaEJB;
import net.zabalburu.ejercicio9.ejbs.ServicioEJB;
import net.zabalburu.ejercicio9.modelo.Empleado;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "Libros", urlPatterns = {"/Libros"})
public class Libros extends HttpServlet {

    @EJB
    ListaLecturaPersonalEJB listaLecturaPersonalEJB;
    
    @EJB
    ServicioEJB servicioEJB;
    
    @EJB
    RecomedacionEmpresaEJB recomendacionEmpresaEJB;
    
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
        String pagina = "index.jsp";
        String accion = request.getParameter("accion");
        if (accion != null){
            switch (accion) {
                case "Entrar":
                    pagina = entrar(request,sesion);
                    break;
                case "Todos":
                    request.setAttribute("libros", servicioEJB.getLibros());
                    pagina = "todos.jsp";
                    break;
                case "Añadir":
                    pagina = añadir(request,sesion);
                    break;
                case "Quitar":
                    pagina = quitar(request,sesion);
                    break;
                case "Recomendaciones":
                    request.setAttribute("libros", this.recomendacionEmpresaEJB.getRecomendados());
                    pagina = "recomendaciones.jsp";
                    break;
                case "Recomendar":
                    pagina = recomendar(request,sesion);
                    break;
                case "Volver":
                    listaLecturaPersonalEJB = (ListaLecturaPersonalEJB) sesion.getAttribute("lista");
                    request.setAttribute("libros", listaLecturaPersonalEJB.getLibros());
                    pagina = "usuario.jsp";
            }
        } else {
            request.setAttribute("empleados", servicioEJB.getEmpleados());
        }
        request.getRequestDispatcher(pagina).forward(request, response);
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

    private String entrar(HttpServletRequest request, HttpSession sesion) {
        String nomApe = request.getParameter("nombre");
        String id = request.getParameter("id");
        int pos = nomApe.indexOf(":");
        String nombre = nomApe.substring(0,pos);
        String apellido = nomApe.substring(pos+1);
        /*StringTokenizer strT = new StringTokenizer(nomApe, ":");
        String nom = strT.nextToken();
        String ape = strT.nextToken();*/
        Empleado e = servicioEJB.validar(nombre, apellido, id);
        if (e == null){
            request.setAttribute("error", "Usuario no válido");
            request.setAttribute("empleados", servicioEJB.getEmpleados());
            return "index.jsp";
        } else {
            sesion.setAttribute("empleado", e);
            request.setAttribute("libros", listaLecturaPersonalEJB.getLibros());
            return "usuario.jsp";    
        }
        
    }

    private String añadir(HttpServletRequest request, HttpSession sesion) {
        String[] ids = request.getParameterValues("id");
        if (ids != null){
            for(String id : ids){
                listaLecturaPersonalEJB.añadirLibro(servicioEJB.getLibro(id));
            }
        }
        sesion.setAttribute("lista", listaLecturaPersonalEJB);
        request.setAttribute("libros", listaLecturaPersonalEJB.getLibros());
        return "usuario.jsp";    
    }

    private String quitar(HttpServletRequest request, HttpSession sesion) {
        String[] ids = request.getParameterValues("id");
        listaLecturaPersonalEJB = (ListaLecturaPersonalEJB) sesion.getAttribute("lista");
        if (ids != null){
            for(String id : ids){
                listaLecturaPersonalEJB.eliminarLibro(servicioEJB.getLibro(id));
            }
        }
        sesion.setAttribute("lista", listaLecturaPersonalEJB);
        request.setAttribute("libros", listaLecturaPersonalEJB.getLibros());
        return "usuario.jsp";    
    }

    private String recomendar(HttpServletRequest request, HttpSession sesion) {
        String[] ids = request.getParameterValues("id");
        if (ids != null){
            for(String id : ids){
                this.recomendacionEmpresaEJB.añadirLibro(servicioEJB.getLibro(id));
            }
        }
        listaLecturaPersonalEJB = (ListaLecturaPersonalEJB) sesion.getAttribute("lista");
        request.setAttribute("libros", listaLecturaPersonalEJB.getLibros());
        return "usuario.jsp";
    }

    

}
