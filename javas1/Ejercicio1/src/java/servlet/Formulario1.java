/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daw2
 */
@WebServlet(name = "Formulario1", urlPatterns = {"/Formulario1"})
public class Formulario1 extends HttpServlet {

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
        if (request.getParameter("enviar") == null){
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Formulario1</title>");            
                out.println("</head>");
                out.println("<body>");

                out.println("<form action='Formulario'>");
                out.println("<fieldset><legend>Datos personales</legend>");
                out.println("<div>");
                out.println("<label for='nombre'>Nombre :</label>");
                out.println("<input type='text' name='nombre' id='nombre' size='30'><br>");
                out.println("<label for='email'>Email : </label>");
                out.println("<input type='password' id='email' name='email' size='15'>");
                out.println("</div>");
                out.println(" </fieldset>");
                out.println("<fieldset><legend>Sexo</legend>");
                out.println("<div>");
                //out.println("<input type="radio" name="sexo" value="V" checked="checked">VarÃ³n");
               // out.println("<input type="radio" name="sexo" value="M">Mujer<br>");
                out.println("</div>");
                out.println("</fieldset>");
                out.println("<fieldset><legend>Seleccione idioma</legend>");
                out.println("<div>");
                out.println("<input type='checkbox' name='idioma' id='ingles' value='InglÃ©s'/>InglÃ©s");
                out.println("<input type='checkbox' name='idioma' id='aleman' value='AlemÃ¡n'/>AlemÃ¡n");
                out.println("<input type='checkbox' name='idioma' id='euskera' value='Euskera'/>Euskera");
                out.println("</div>");
                out.println("</fieldset>");
                out.println("<fieldset><legend>Estudios</legend>");
                out.println("<div>");
                out.println("<select name='estudios' id='estudios'>");
                out.println("<option value='Primarios'>Primarios</option>");
                out.println("<option value='Bachillerato'>Bachillerato</option>");
                out.println("<option value='Ciclos'>Ciclos</option>");
                out.println("<option value='Licenciatura'>Licenciatura</option>");
                out.println("</select><br>");
                out.println("</div>");
                out.println("</fieldset>");
                out.println("<fieldset><legend>Departamentos en los que le gustarÃ­a trabajar</legend>");
                out.println("<select name='departamentos' id='departamentos' multiple size=5>");
                out.println("<option value='Administracion'>AdministraciÃ³n</option>");
                out.println("<option value='Compras'>Compras</option>");
                out.println("<option value='Ventas'>Ventas</option>");
                out.println("<option value='Marketing'>Marketing</option>");
                out.println("</select><br>");
                out.println("</fieldset>");
                out.println("<fieldset><legend>Comentarios</legend>");
                out.println("<textarea name='comentarios' id='comentarios' rows=5></textarea>");
                out.println("</fieldset>");
                out.println("<input type='submit' name='enviar' id='enviar' value='Enviar'>");
                out.println("<input type='reset' name='reset' id='reset' value='Limpiar'>");
                out.println("</form>");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
                
                  
            
            //out.println("<h1>Servlet Formulario1 at " + request.getContextPath() + "</h1>");
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
