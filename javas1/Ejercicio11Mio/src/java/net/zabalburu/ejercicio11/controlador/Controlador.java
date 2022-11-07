/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio11.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio11.dao.ColegioFachada;
import net.zabalburu.ejercicio11.modelo.JPAAlumno;
import net.zabalburu.ejercicio11.modelo.Modulo;
import net.zabalburu.ejercicio11.modelo.Nota;
import net.zabalburu.ejercicio11.modelo.Profesor;

/**
 *
 * @author Francis
 */
@WebServlet(name = "Colegio", urlPatterns = {"/Colegio"})
public class Controlador extends HttpServlet {

    @EJB
    private ColegioFachada colegioFachada;

    
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
        String accion = request.getParameter("accion");
        if (accion == null){
            request.setAttribute("profesores", colegioFachada.getProfesores());
            sesion.setAttribute("colegio", colegioFachada);
            request.getRequestDispatcher("seleccionProfesor.jsp").forward(request, response);
        } else if (accion.equals("Entrar")){
            String idProfesor = request.getParameter("profesor");
            Profesor profesor = colegioFachada.buscaProfesor(new Integer(idProfesor));
            Modulo modulo = colegioFachada.getModuloProfesor(profesor);
            sesion.setAttribute("moduloProfe", modulo);
            ArrayList<JPAAlumno> alumnos = colegioFachada.getAlumnos();
            request.setAttribute("listaAlumnos", alumnos);
            request.getRequestDispatcher("notas.jsp").forward(request, response);
        } else if(accion.equals("GuardarNotas")){
            ArrayList<String> parametros = Collections.list(request.getParameterNames());
            for (String parametro : parametros){
                try {
                    JPAAlumno al = colegioFachada.buscaAlumno(new Integer (parametro));
                    if (al != null){
                        Modulo modProfe = (Modulo)sesion.getAttribute("moduloProfe");
                        String nota = request.getParameter(parametro);
                        Nota notaAlumno = new Nota();
                        notaAlumno.setNota(new Integer(nota));
                        notaAlumno.setIdModulo(modProfe);
                        notaAlumno.setIdAlumno(al);
                        colegioFachada.nuevaNota(notaAlumno);
                    }
                    // Para usar con los parametrso que no se pueden convertir a integer
                } catch(NumberFormatException ex){
                    
                }
            }
            request.getRequestDispatcher("fin.jsp").forward(request, response);
        } else if (accion.equals("Finalizar")){
            sesion.invalidate();
            request.getRequestDispatcher("seleccionProfesor.jsp").forward(request, response);
       
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
