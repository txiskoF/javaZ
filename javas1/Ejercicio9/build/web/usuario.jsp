<%-- 
    Document   : index
    Created on : 05-nov-2019, 10:23:32
    Author     : ichueca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Login</title>
    </head>
    <body>
        <div class="container mt-5">
            <h1>Sus Libros</h1>
            <c:if test="${empty libros}">
                <div class="alert alert-info mt-5 mb-5">No hay libros seleccionados</div>
            </c:if>
            <form action="Libros">
                <c:if test="${!empty libros}">

                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Título</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${libros}" var="l">
                                <tr>
                                    <th scope="row">${l.id}</th>
                                    <td>${l.titulo}</td>
                                    <td>${l.tipo}</td>
                                    <td><input type="checkbox" name="id" value="${l.id}"></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                    <input class="btn btn-primary" type="submit" name="accion" value="Quitar">

                </c:if>
                <a href="Libros?accion=Recomendaciones" class="btn btn-primary">Ver Recomendaciones</a>
                <a href="Libros?accion=Todos" class="btn btn-primary">Ver Todos</a>
            </form>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>