<%-- 
    Document   : index
    Created on : 25-oct-2019, 11:01:30
    Author     : ichueca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Bienvenido a Chinook</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-2 mb-2">
                <div class="col-7"></div>
                <div class="col-5">
                    <c:choose>
                        <c:when test="${usuario != null}">
                            <a href="Chinook?accion=Salir"><img class="rounded-circle" width="10%" src="${usuario.foto}"></a>
                            </c:when>
                            <c:otherwise>
                            <a href="Chinook?accion=Identificarse">Identifíquese</a>
                        </c:otherwise>
                    </c:choose>
                    <a href="Chinook?accion=Comprar"><span class="mt-2"><i class="material-icons">shopping_cart</i></span></a>
                    <span class="badge badge-pill badge-primary">${carrito.canciones.size()}</span>
                </div>
            </div>
            <div class="row">
                <h1>Contenido de su carrito de la compra</h1>
            </div>
            <div class="row">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Artista</th>
                            <th scope="col">Album</th>
                            <th scope="col">Canción</th>
                            <th scope="col">Género</th>
                            <th scope="col">Duración</th>
                            <th scope="col">Bytes</th>
                            <th scope="col">Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${carrito.canciones}" var="c">
                            <tr>
                                <td>${c.album.artista.nombre}</td>
                                <td>${c.album.titulo}</td>
                                <td>${c.nombre}</td>
                                <td>${c.genero}</td>
                                <td>${c.duracion}</td>
                                <td>${c.bytes}</td>
                                <td><fmt:formatNumber value="${c.precio}" type="currency"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
                <div class="row">
                    <h4>Total de la Compra : <fmt:formatNumber value="${carrito.total}" type="currency"/></h4>
                </div>
                <div class="row mt-2">
                    <a href="Chinook?accion=Finalizar" class="btn btn-primary mr-3">Finalizar Compra</a>
                    <a href="Chinook?accion=Volver" class="btn btn-primary">Volver</a>
                </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>