<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.zabalburu.ejercicio6.Usuario"%>
<%@page import="net.zabalburu.ejercicio6.service.Servicio"%>
<%! 
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
%>
<%
    List<String> errores = (List<String>) request.getAttribute("errores");
%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<jsp:useBean id="usuario" class="net.zabalburu.ejercicio6.Usuario" scope="session"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Solicitud de Reaparación</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Solicitud de Reparación</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <form action="reparaciones">
                        <div class="form-group">
                            <label for="nombre">Usuario</label>
                            <input type="text" readonly="readonly" class="form-control" id="nombre" 
                                   name ="usuario" value="<%= usuario.getNombre() %>">
                        </div>
                        <div class="form-group">
                            <label for="elemento">Elemento</label>
                            <select class="select custom-select" name="elemento" id="elemento">
                                <option>Ordenador</option>
                                <option>Monitor</option>
                                <option>Teclado</option>
                                <option>Ratón</option>
                                <option>Internet</option>
                                <option>Otros</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="fechaSolicitud">Fecha Solicitud</label>
                            <input type="date" class="form-control" id="fechaSolicitud" 
                                   name ="fecha"
                                   value = "<%= df.format(new java.util.Date())%>">
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Descripción</label>
                            <textarea class="form-control" id="descripcion" 
                                      name ="descripcion"></textarea>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Enviar Datos" name="accion">
                    </form>
                </div>
            </div>
            <% 
                if (errores != null) {
            %>
            <div class="row mt-3">
                <div class="col-3"></div>
                <div class="col-6">
                    <% for(String error : errores) {
                    %>
                    <div class="alert alert-danger"><%= error %></div>
                    <%
                        }
                    %>
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
