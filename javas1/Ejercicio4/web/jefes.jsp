<%-- 
    Document   : jefes
    Created on : 30-sep-2019, 12:20:59
    Author     : ichueca
--%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="net.zabalburu.ejercicio4.modelo.Empleado"%>
<%@page import="net.zabalburu.ejercicio4.servicio.Servicio"%>
<%!
    private Servicio servicio = new Servicio();
    private DateFormat df = DateFormat.getDateInstance();
%>
<%
    String accion = request.getParameter("accion");
    Integer idJefe;
    List<Empleado> jefes = servicio.getJefes();
    if (accion != null) {
        idJefe = Integer.parseInt(request.getParameter("idJefe"));
    } else {
        idJefe = jefes.get(0).getEmpId();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jefes Empresa</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6 mt-4">
                    <h1>Listado de Empleados</h1>
                    <form action="jefes.jsp">
                        Seleccione el jefe : <select name="idJefe">
                            <%
                                for (Empleado e : jefes) {
                            %>
                            <option value="<%= e.getEmpId()%>" <%= (e.getEmpId()) == idJefe ? "SELECTED" : ""%>><%= e.nombreCompleto()%></option>
                            <%
                                }
                            %>
                        </select>
                        <input type="submit" name="accion" value="Ver Empleados">
                    </form>
                    <br>
                    <h1 class="mt-4">Empleados</h1>
                    <table class="table-striped">
                        <tr><th>#</th><th>Nombre</th><th>Fecha nacimiento</th><th></th></tr>
                                <%
                                    for (Empleado e : servicio.getEmpleadosJefe(idJefe)) {

                                %>
                        <tr><td><%= e.getEmpId()%></td><td><%= e.nombreCompleto()%></td>
                            <td><%= df.format(e.getFechaNacimiento())%></td>
                            <td><a href="pedidos.jsp?accion=Ver&id=<%= e.getEmpId()%>">Pedidos</a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
