/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio6.controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio6.Reparacion;
import net.zabalburu.ejercicio6.Usuario;
import net.zabalburu.ejercicio6.service.Servicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "Controlador", urlPatterns = {"/reparaciones"})
public class Controlador extends HttpServlet {

    private String pagina;
    private List<String> errores;
    private Servicio servicio = new Servicio();
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private HttpSession sesion;
    private Usuario usuario;

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
        pagina = "login.jsp";
        errores = new ArrayList();
        String accion = request.getParameter("accion");
        sesion = request.getSession();
        usuario = (Usuario) sesion.getAttribute("usuario");
        if (accion != null) {
            if (accion.equals("Entrar")) {
                pagina = entrar(request, response);
            } else if (accion.equals("solicitar")) {
                pagina = solicitarReparacion(request, response);
            } else if (accion.equals("Enviar Datos")) {
                pagina = añadirReparacion(request, response);
            } else if (accion.equals("comprobar")) {
                pagina = comprobarReparaciones(request, response);
            } else if (accion.equals("opciones")) {
                pagina = "opciones.jsp";
            } else if (accion.equals("reparar")) {
                pagina = reparar(request, response);
            } else if (accion.equals("Guardar Cambios")){
                pagina = guardarReparacion(request, response);
            } else if (accion.equals("Cancelar")){
                pagina = "opciones.jsp";
            } else if (accion.equals("Salir")){
                sesion.invalidate();
                request.setAttribute("info", "Su sesión ha finalizado");
                pagina = "login.jsp";
            }
        }
        request.setAttribute("errores", errores);
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

    private String entrar(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        if (nombre.isEmpty()) {
            errores.add("El nombre no puede estar vacío");
        }
        if (password.isEmpty()) {
            errores.add("Debe especificarse la contraseña");
        }
        if (errores.isEmpty()) {
            Usuario u = servicio.validar(nombre, password);
            if (u == null) {
                errores.add("Usuario/contraseña erróneos");
            } else {
                sesion.setAttribute("usuario", u);
                return "opciones.jsp";
            }
        }
        
        return "login.jsp";
    }

    private String solicitarReparacion(HttpServletRequest request, HttpServletResponse response) {
        return "solicitud.jsp";
    }

    private String añadirReparacion(HttpServletRequest request, HttpServletResponse response) {
        String elemento = request.getParameter("elemento");
        Date fechaSolicitud = new Date();
        try {
            fechaSolicitud = df.parse(request.getParameter("fecha"));
        } catch (ParseException ex) {
        }
        String descripcion = request.getParameter("descripcion");
        if (descripcion.isEmpty()) {
            errores.add("Debe especificarse la descripción");
            return "solicitud.jsp";
        }
        Reparacion r = new Reparacion();
        r.setDescripcion(descripcion);
        r.setElemento(elemento);
        r.setFechaSolicitud(fechaSolicitud);
        r.setUsuario(usuario.getNombre());
        servicio.añadirReparacion(r);
        request.setAttribute("info", "Solicitud almacenada con éxito");
        return "opciones.jsp";
    }

    private String comprobarReparaciones(HttpServletRequest request, HttpServletResponse response) {
        List<Reparacion> reparaciones = servicio.getReparaciones(
                usuario.getNombre());
        request.setAttribute("reparaciones", reparaciones);
        return "comprobar.jsp";
    }

    private String reparar(HttpServletRequest request, HttpServletResponse response) {
        List<Reparacion> pendientes = servicio.getReparacionesPendientes();
        request.setAttribute("reparaciones", pendientes);
        return "reparar.jsp";
    }

    private String guardarReparacion(HttpServletRequest request, HttpServletResponse response) {
        String[] repNos = request.getParameterValues("repno");
        String[] costes = request.getParameterValues("coste");
        boolean hayReps = false;
        for (int i = 0; i < costes.length; i++) {
            if (!costes[i].isEmpty()){
                hayReps = true;
                servicio.reparar(
                        Integer.parseInt(repNos[i]), 
                        usuario.getNombre(), 
                        Double.parseDouble(costes[i]));
            }
        }
        if (hayReps){
            request.setAttribute("info", "Reparaciones almacenadas con éxito");
        }
        return "opciones.jsp";
    }

}
