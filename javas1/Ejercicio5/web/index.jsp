<%-- 
    Document   : index
    Created on : 03-oct-2019, 12:09:39
    Author     : ichueca
--%>
<jsp:useBean id="sugerencia" class="modelo.Sugerencia" scope="request"/>
<jsp:setProperty name="sugerencia" property="*"/>

<%
    // Si hemos recibido el formulario
    //if (request.getParameter("nombre")!=null)
    if (sugerencia.getNombre() != null
            && sugerencia.getSugerencia() != null) {
        if (!sugerencia.getNombre().isEmpty()
                && !sugerencia.getSugerencia().isEmpty()) {
%>
<jsp:forward page="sugerencias.jsp"></jsp:forward>
<%
        }
    }
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

        <title>Hello, world!</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5 mb-3">
                <div class="col-lg-3 col-0"></div>
                <div class="col-lg-6 col-11"><h3>Introduzca los datos del formulario</h3></div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-0"></div>
                <div class="col-lg-6 col-11">
                    <form action="index.jsp">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre"
                                   value="<%= (sugerencia.getNombre() != null) ? sugerencia.getNombre() : ""%>">
                        </div>
                        <div class="form-group">
                            <label for="email">Nombre</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Correo Electrónico">
                        </div>
                        <div>Destinatario</div>
                        <input type="checkbox" id="destinatario" name="destinatario" value="Administración"><label>Administración</label>
                        <input type="checkbox" id="destinatario" name="destinatario" value="Mantenimiento">Mantenimiento

                        <input type="checkbox" id="destinatario" name="destinatario" value="Dirección">Dirección
                        <input type="checkbox" id="destinatario" name="destinatario" value="Otros">Otros

                        <div class="form-group">
                            <label for="sugerencia">Sugerencia</label>
                            <textarea class="form-control" id="sugerencia" name="sugerencia"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar Datos</button>
                        <button type="reset" class="btn btn-secondary">Limpiar Formulario</button>
                    </form>
                    <%
                        if (request.getParameter("nombre") != null) {
                    %>
                    <div class="alert alert-danger mt-3" role="alert">
                        Debe especificar al menos el nombre y la sugerencia
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
