/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.eje4rcicio8.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.zabalburu.ejercicio8.modelo.Artista;
import net.zabalburu.ejercicio8.modelo.Carrito;
import net.zabalburu.ejercicio8.modelo.Usuario;
import net.zabalburu.ejercicio8.service.Servicio;

/**
 *
 * @author ichueca
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Chinook"})
public class Controlador extends HttpServlet {
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
        String accion = request.getParameter("accion");
        String pagina = "index.jsp";
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        Carrito carrito = (Carrito) sesion.getAttribute("carrito");
        Integer actual;
        Integer totalPaginas;
        actual = (Integer) sesion.getAttribute("pagina");
        totalPaginas = (Integer) sesion.getAttribute("totalPaginas");
        accion = request.getParameter("accion");
        if (accion == null){
            List<String> iniciales = servicio.getIniciales();
            List<Artista> artistas = servicio.getArtistasInicial(iniciales.get(0));
            sesion.setAttribute("iniciales", iniciales);
            request.setAttribute("artistas", artistas);
            sesion.setAttribute("pagina", 1);
            sesion.setAttribute("totalPaginas", artistas.size() / 5 + ((artistas.size()%5>0)?1:0));
            sesion.setAttribute("letra", iniciales.get(0));
            sesion.setAttribute("carrito", new Carrito());
        } else if (accion.equals("IrAPag")){
            int pg = Integer.parseInt(request.getParameter("pagina"));
            sesion.setAttribute("pagina", pg);
            List<Artista> artistas = servicio.getArtistasInicial((String)sesion.getAttribute("letra"));
            request.setAttribute("artistas", artistas);
        } else if (accion.equals("CambiarInicial")){
            String letra = request.getParameter("letra");
            List<Artista> artistas = servicio.getArtistasInicial(letra);
            sesion.setAttribute("letra", letra);
            sesion.setAttribute("pagina", 1);
            sesion.setAttribute("totalPaginas", artistas.size() / 5 + ((artistas.size()%5>0)?1:0));
            request.setAttribute("artistas", artistas);
        } else if (accion.equals("Identificarse")){
            pagina = "login.jsp";
        } else if (accion.equals("Entrar")) {
            pagina = entrar(request,sesion);
        } else if (accion.equals("Salir")){
            sesion.removeAttribute("usuario");
            carrito.setCanciones(new ArrayList<>());
            List<String> iniciales = servicio.getIniciales();
            List<Artista> artistas = servicio.getArtistasInicial(iniciales.get(0));
            sesion.setAttribute("iniciales", iniciales);
            request.setAttribute("artistas", artistas);
            sesion.setAttribute("pagina", 1);
            sesion.setAttribute("carrito", carrito);
        } else if (accion.equals("cambioArtista")){
            sesion.setAttribute("artista", servicio.getArtista(
                Integer.parseInt(request.getParameter("id"))));
            pagina = "artista.jsp";
        } else if (accion.equals("Añadir al Carrito")){
            String[] ids = request.getParameterValues("id");
            if (ids != null){
                for(String id : ids){
                    carrito.añadirCancion(servicio.getCancion(Integer.parseInt(id)));
                }
            }
            sesion.setAttribute("carrito", carrito);
            pagina = "artista.jsp";
        } else if (accion.equals("Volver")){
            String letra = (String) sesion.getAttribute("letra");
            List<Artista> artistas = servicio.getArtistasInicial(letra);
            request.setAttribute("artistas", artistas);
            pagina = "index.jsp";
        } else if (accion.equals("Comprar")){
            if (usuario == null){
                pagina = "login.jsp";
            } else {
                pagina = "comprar.jsp";
            }
        } else if (accion.equals("Finalizar")){
            carrito.setCanciones(new ArrayList<>());
            sesion.setAttribute("carrito", carrito);
            pagina = "fin.jsp";
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
        List<String> errores = new ArrayList<>();
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        if (nombre.isEmpty()){
            errores.add("Debe especificarse el nombre");
        }        
        if (password.isEmpty()){
            errores.add("Debe especificarse la contraseña");
        }
        if (errores.isEmpty()){
            Usuario usuario = servicio.login(nombre, password);
            if (usuario != null){
                sesion.setAttribute("usuario", usuario);
                String letra = (String) sesion.getAttribute("letra");
                List<Artista> artistas = servicio.getArtistasInicial(letra);
                request.setAttribute("artistas", artistas);
                return "index.jsp";
            } else {
                errores.add("Usuario / contraseña erróneos");
            }
        }
        request.setAttribute("errores", errores);
        return "login.jsp";
    }

}
