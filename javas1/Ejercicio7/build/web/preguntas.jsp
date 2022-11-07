<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@page import="net.zabalburu.ejercicio7.Pregunta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" class="net.zabalburu.ejercicio7.Usuario"
             scope="session"/>
<%
    List<Pregunta> preguntas = (List) request.getAttribute("preguntas");
%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Preguntas</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Listado de Preguntas</h2>                    
                </div>
                <div class="col-3">
                    <a href="preguntas?accion=Salir"><img class="rounded-circle" style="width: 25%" src="<%= usuario.getUrlFoto()%>"></a>
                </div>
            </div>
                <div class="mb-3">
                <a href="preguntas?accion=Nueva">Nueva Pregunta</a>
                </div>
            <%
                if (preguntas != null && !preguntas.isEmpty()) {
            %>
            <%
                for (Pregunta p : preguntas) {
            %>
            <div class="row">
                <div class="col-2">
                    <img class="rounded-circle" style="width: 40%" src="<%= p.getUsuario().getUrlFoto()%>">
                    <div><%= p.getUsuario().getNombre()%></div>
                </div>
                <div>
                    <div><%= p.getFecha()%></div>
                    <div><%= p.getTexto()%></div>
                    <a href="preguntas?accion=Respuesta&id=<%=p.getId()%>">Responder</a>
                </div>
            </div>
            <%
                if (!p.getRespuestas().isEmpty()) {
                    for (Pregunta r : p.getRespuestas()) {
            %>
            <div class="row">
                <div class="col-2"></div>
                <div class="col-2">
                    <img class="rounded-circle" style="width: 40%" src="<%= r.getUsuario().getUrlFoto()%>">
                    <div><%= r.getUsuario().getNombre()%></div>
                </div>
                <div>
                    <div><%= r.getFecha()%></div>
                    <div><%= r.getTexto()%></div>
                </div>
            </div>
            <%
                    }
                }
            %>

            <%
                }
            %>

            <%
            } else {
            %>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6 alert alert-info">No hay preguntas. Añada una!</div>
            </div>
            <%
                }
            %>
        </div> 
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
