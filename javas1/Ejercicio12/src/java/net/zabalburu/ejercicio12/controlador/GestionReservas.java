/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.ejercicio12.controlador;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio12.modelo.Curso;
import net.zabalburu.ejercicio12.modelo.Empresa;
import net.zabalburu.ejercicio12.modelo.Reserva;
import net.zabalburu.ejercicio12.sesion.ReservasFachada;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "GestionReservas", urlPatterns = {"/GestionReservas"})
public class GestionReservas extends HttpServlet {

    @EJB
    private ReservasFachada fachada;
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
        HttpSession sesion = request.getSession();
        if (accion == null){
            request.setAttribute("empresas", fachada.getEmpresas());
        } else if (accion.equals("Entrar")){
            pagina = entrar(request, sesion, pagina);
        } else if (accion.equals("Reservar")){
            pagina = reservar(request, sesion, pagina);
        } else if (accion.equals("ReservarCurso")){
            pagina = reservarCurso(request, sesion, pagina);
        } else if (accion.equals("Volver")){            
            request.setAttribute("disponibles", fachada.cursosDisponibles((Empresa) sesion.getAttribute("empresa")));
            pagina = "empresa.jsp";
        } else if (accion.equals("Salir")){
            sesion.invalidate();
            request.setAttribute("empresas", fachada.getEmpresas());
        }
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    private String entrar(HttpServletRequest request, HttpSession sesion, String pagina) throws NumberFormatException {
        String clave = request.getParameter("clave");
        if (clave.isEmpty()){
            request.setAttribute("error", "Debe especificarse la clave");
            request.setAttribute("empresas", fachada.getEmpresas());
        } else {
            Empresa e = fachada.buscaEmpresa(Integer.parseInt(request.getParameter("idEmpresa")));
            if (e.getClave().equalsIgnoreCase(clave)){
                sesion.setAttribute("empresa", e);
                request.setAttribute("disponibles", fachada.cursosDisponibles(e));
                pagina = "empresa.jsp";
            } else {
                request.setAttribute("error", "Clave errónea");
                request.setAttribute("empresas", fachada.getEmpresas());
            }
        }
        return pagina;
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

    private String reservar(HttpServletRequest request, HttpSession sesion, String pagina) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("curso", fachada.buscaCurso(id));
        return "alta.jsp";
    }

    private String reservarCurso(HttpServletRequest request, HttpSession sesion, String pagina) {
        Integer reservas = Integer.parseInt(request.getParameter("reservas"));
        Curso c = fachada.buscaCurso(Integer.parseInt(request.getParameter("id")));
        Empresa e = (Empresa) sesion.getAttribute("empresa");
        Reserva r = new Reserva();
        r.setIdCurso(c);
        r.setIdEmpresa(e);
        r.setReservas(reservas);
        fachada.nuevaReserva(r);
        request.setAttribute("disponibles", fachada.cursosDisponibles(e));
        return "empresa.jsp";
    }

}
