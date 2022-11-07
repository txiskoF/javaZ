<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@page import="net.zabalburu.ejercicio6.Usuario"%>
<%@page import="net.zabalburu.ejercicio6.service.Servicio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 <!-- ES EL MISMO USEBEAN QUE EN LA PAGINA ANTERIOR Y BUSCA SI EN LA SESSION UN OBJETO USUARO --> 
<jsp:useBean id="usuario" class="net.zabalburu.ejercicio6.Usuario" 
             scope="session"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Opciones</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <div class="col-3"></div>
                <div class="col-6">
                            <!-- //DEL USEBEAN USUARIO SE COGE SU NOMBRE -->
                    <h2>Bienvenido <%= usuario.getNombre()%></h2>
                            <!-- DEL USEBEAN SE COGE EL ROL --> 
                    <h5>Usted es <%= usuario.getRol()%></h5>
                    <h6 class="mt-3">Seleccione una de las opciones</h6>
                    <ul class="mt-3">
                        <li><a href="solicitud.jsp">Solicitar Reparaciones</a></li>
                        <li><a href="comprobar.jsp">Comprobar Reparaciones</a></li>
                            <%
                                if (usuario.getRol().toLowerCase().equals("reparador/a")) {
                            %>
                        <li><a href="reparar.jsp">Reparar</a></li>
                            <%
                                }
                            %>
                        <li><a href="login.jsp">Salir</a></li>
                    </ul>
                </div>
            </div>
            <% if (request.getParameter("info") != null) {

            %>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <div class="alert alert-success"><%= request.getParameter("info")%></div>
                </div>
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
