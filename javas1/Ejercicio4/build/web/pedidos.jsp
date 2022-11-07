<%-- 
    Document   : jefes
    Created on : 30-sep-2019, 12:20:59
    Author     : ichueca
--%>
<%@page import="net.zabalburu.ejercicio4.modelo.Pedido"%>
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
    Empleado e = null;
    List<Pedido> pedidos = null;
    Integer pag = (Integer) session.getAttribute("pagina");
    if (pag == null) {
        pag = 0;
    }
    int numPaginas;
    if (accion.equals("Ver")) {
        Integer idEmp = Integer.parseInt(request.getParameter("id"));
        e = servicio.getEmpleado(idEmp);
        pedidos = servicio.getPedidos(idEmp);
        session.setAttribute("empleado", e);
        session.setAttribute("pedidos", pedidos);
    } else {
        e = (Empleado) session.getAttribute("empleado");
        pedidos = (List<Pedido>) session.getAttribute("pedidos");
        numPaginas = pedidos.size() / 10;
        if (pedidos.size() % 10 > 0) {
            numPaginas++;
        }
        if (accion.equals("anterior")) {
            pag = 0;
        } else if (accion.equals("siguiente")) {
            pag = numPaginas - 1;
        } else {
            pag = Integer.parseInt(request.getParameter("accion")) - 1;
        }
        session.setAttribute("pagina", pag);
    }
    numPaginas = pedidos.size() / 10;
    if (pedidos.size() % 10 > 0) {
        numPaginas++;
    }

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos Empleados</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-2"></div>
                <div class="col-8 mt-4">
                    <h2>Listado de Pedidos de <%= e.nombreCompleto()%></h2>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Fecha</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (int i = pag * 10; i < (pag + 1) * 10
                                        && i < pedidos.size(); i++) {
                            %>
                            <tr>
                                <th scope="row"><%= pedidos.get(i).getIdPedido()%></th>
                                <td><%= pedidos.get(i).getCliente()%></td>
                                <td><%= df.format(pedidos.get(i).getFecha())%></td>
                            </tr>                            
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="pedidos.jsp?accion=anterior&id=<%= e.getEmpId()%>" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <%

                                for (int i = 0; i < numPaginas; i++) {
                            %>
                            <li class="page-item"><a class="page-link" href="pedidos.jsp?accion=<%= i + 1%>"><%= i + 1%></a></li>
                                <%
                                    }
                                %>
                            <li class="page-item">
                                <a class="page-link" href="pedidos.jsp?accion=siguiente" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
