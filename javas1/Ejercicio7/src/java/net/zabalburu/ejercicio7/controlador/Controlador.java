/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio7.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio7.Pregunta;
import net.zabalburu.ejercicio7.Usuario;
import net.zabalburu.ejercicio7.service.Servicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "Controlador", urlPatterns = {"/preguntas"})
public class Controlador extends HttpServlet {
    private List<String> errores;
    private Servicio servicio = new Servicio();
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
        String pagina = "login.jsp";
        String accion = request.getParameter("accion");
        errores = new ArrayList<>();
        HttpSession sesion = request.getSession();
        if (accion != null){
            if (accion.equals("Entrar")){
                pagina = login(request,response, sesion);
            } else if (accion.equals("Nueva")){
                pagina = "nuevaPregunta.jsp";
            } else if (accion.equals("Guardar")){
                pagina = guardar(request,response,sesion);
            } else if (accion.equals("Respuesta")){
                pagina = respuesta(request,response,sesion);
            } else if (accion.equals("Responder")){
                pagina = responder(request, response, sesion);
            } else if (accion.equals("Salir")){
                sesion.invalidate();
                pagina = "login.jsp";
            }
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

    private String login(HttpServletRequest request, HttpServletResponse response, HttpSession sesion) {
        String usuario = request.getParameter("nombre");
        String password = request.getParameter("password");
        if (usuario.isEmpty()){
            errores.add("El nombre es obligatorio");
        }
        if (password.isEmpty()){
            errores.add("Debe especificarse la contraseña");
        }
        if (errores.isEmpty()){
            Usuario u = servicio.login(usuario, password);
            if (u == null){
                errores.add("Usuario / contraseña erróneos");
            } else {
                sesion.setAttribute("usuario", u);
                request.setAttribute("preguntas",servicio.getPreguntas());
                return "preguntas.jsp";
            }
        }
        request.setAttribute("errores", errores);
        return "login.jsp";
    }

    private String guardar(HttpServletRequest request, HttpServletResponse response, HttpSession sesion) {
        String texto = request.getParameter("texto");
        if (texto.isEmpty()){
            return "nuevaPregunta.jsp";
        }
        Pregunta p = new Pregunta();
        p.setFecha(new Date());
        p.setRespuestaA(0);
        p.setTexto(texto);
        p.setUsuario((Usuario)sesion.getAttribute("usuario"));
        servicio.nuevaPregunta(p);
        request.setAttribute("preguntas",servicio.getPreguntas());
        return "preguntas.jsp";
    }

    private String respuesta(HttpServletRequest request, HttpServletResponse response, HttpSession sesion) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Pregunta p = servicio.getPregunta(id);
        request.setAttribute("pregunta", p);
        return "responder.jsp";
    }

    private String responder(HttpServletRequest request, HttpServletResponse response, HttpSession sesion) {
        String texto = request.getParameter("texto");
        if (texto.isEmpty()){
            return "response.jsp";
        }
        Pregunta p = new Pregunta();
        p.setFecha(new Date());
        p.setRespuestaA(Integer.parseInt(request.getParameter("id")));
        p.setTexto(texto);
        p.setUsuario((Usuario)sesion.getAttribute("usuario"));
        servicio.nuevaPregunta(p);
        request.setAttribute("preguntas",servicio.getPreguntas());
        return "preguntas.jsp";
    }

}
