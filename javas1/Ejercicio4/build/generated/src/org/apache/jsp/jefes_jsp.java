package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DateFormat;
import java.util.List;
import net.zabalburu.ejercicio4.modelo.Empleado;
import net.zabalburu.ejercicio4.servicio.Servicio;

public final class jefes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    private Servicio servicio = new Servicio();
    private DateFormat df = DateFormat.getDateInstance();

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');

    String accion = request.getParameter("accion");
    Integer idJefe;
    List<Empleado> jefes = servicio.getJefes();
    if (accion != null) {
        idJefe = Integer.parseInt(request.getParameter("idJefe"));
    } else {
        idJefe = jefes.get(0).getEmpId();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Jefes Empresa</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-3\"></div>\n");
      out.write("                <div class=\"col-6 mt-4\">\n");
      out.write("                    <h1>Listado de Empleados</h1>\n");
      out.write("                    <form action=\"jefes.jsp\">\n");
      out.write("                        Seleccione el jefe : <select name=\"idJefe\">\n");
      out.write("                            ");

                                for (Empleado e : jefes) {
                            
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( e.getEmpId());
      out.write('"');
      out.write(' ');
      out.print( (e.getEmpId()) == idJefe ? "SELECTED" : "");
      out.write('>');
      out.print( e.nombreCompleto());
      out.write("</option>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        <input type=\"submit\" name=\"accion\" value=\"Ver Empleados\">\n");
      out.write("                    </form>\n");
      out.write("                    <br>\n");
      out.write("                    <h1 class=\"mt-4\">Empleados</h1>\n");
      out.write("                    <table class=\"table-striped\">\n");
      out.write("                        <tr><th>#</th><th>Nombre</th><th>Fecha nacimiento</th><th></th></tr>\n");
      out.write("                                ");

                                    for (Empleado e : servicio.getEmpleadosJefe(idJefe)) {

                                
      out.write("\n");
      out.write("                        <tr><td>");
      out.print( e.getEmpId());
      out.write("</td><td>");
      out.print( e.nombreCompleto());
      out.write("</td>\n");
      out.write("                            <td>");
      out.print( df.format(e.getFechaNacimiento()));
      out.write("</td>\n");
      out.write("                            <td><a href=\"pedidos.jsp?accion=Ver&id=");
      out.print( e.getEmpId());
      out.write("\">Pedidos</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
