<%-- 
    Document   : sugerencias
    Created on : 03-oct-2019, 12:24:16
    Author     : ichueca
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.Sugerencia"%>
<%@page import="java.util.ArrayList"%>
<%! private List<Sugerencia> sugerencias = new ArrayList(); %>
<jsp:useBean id="sugerencia" class="modelo.Sugerencia" scope="request"/>

<%-- <%
    Sugerencia sugerencia = (Sugerencia) request.getAttribute("sugerencia");
    if (sugerencia == null){
        sugerencia = new Sugerencia();
    }
    
%> --%>

<jsp:setProperty name="sugerencia" property="*"/>
<%-- <%
    sugerencia.setNombre(request.getParameter("nombre"));
    //...
    request.setAttribute("sugerencia", sugerencia);
%> --%>

<%
    sugerencias.add(sugerencia);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Listado de Sugerencias</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Email</th>
                        <th scope="col">Detinatarios</th>
                        <th scope="col">Comentarios</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(Sugerencia s : sugerencias){
                    %>
                    <tr>
                        <th scope="row"><%= s.getNombre() %></th>
                        <td><%= s.getEmail() %></td>
                        <td><% 
                            if (s.getDestinatario() == null){
                                s.setDestinatario(new String[0]);
                            }
                            for(String d : s.getDestinatario()) {%>
                            <%= d %>
                            <% } %>
                        </td>
                        <td><%= s.getSugerencia() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
                <a href="index.jsp">Volver al formulario</a>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
