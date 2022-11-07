<%-- 
    Document   : seleccionprofesor
    Created on : 11-nov-2019, 10:22:56
    Author     : ichueca
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Gestión de Reservas</title>
    </head>
    <body>
        <div class="container m-5">
            <h3>Identifíquese</h3>
            <form action="GestionReservas">
                <div class="form-group">
                    <label for="empresa">Seleccione su empresa</label>
                    <select name="idEmpresa" id="empresa" class="custom-select">
                        <c:forEach items="${empresas}" var="e">
                            <option value="${e.idEmpresa}" ${e.idEmpresa == param.idEmpresa ? "SELECTED":""}>${e.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="clave">Especifique su clave</label>
                    <input type="password" name="clave" id="clave" class="control form-control">
                </div>
                <button type="submit" class="btn btn-primary" name="accion" value="Entrar">Entrar</button>
            </form>
            <c:if  test="${!empty error}">
                <div class="alert alert-warning mt-5">${error}</div>
            </c:if>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>