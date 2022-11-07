<%-- 
    Document   : index
    Created on : 25-oct-2019, 11:01:30
    Author     : ichueca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <div class="col-8"></div>
                <div>
                    <c:choose>
                        <c:when test="${usuario != null}">
                            <a href="Chinook?accion=Salir"><img class="rounded-circle" width="20%" src="${usuario.foto}"></a>
                            </c:when>
                            <c:otherwise>
                            <div class="col">
                                <a href="Chinook?accion=Identificarse">Identifíquese</a>
                            </div>
                        </c:otherwise>
                    </c:choose>
                            <a href="Chinook?accion=Comprar"><span class="mt-2"><i class="material-icons">shopping_cart</i></span></a>
                    <span class="badge badge-pill badge-primary">${carrito.canciones.size()}</span>
                </div>
            </div>
            <div class="row">
                <h1>Albumes de ${artista.nombre}</h1>
            </div>

            <div class="row">

                <div id="accordion">
                    <c:forEach items="${artista.albumes}" var="album" varStatus="vs">
                        <div class="card">
                            <div class="card-header" id="heading${album.id}">
                                <h5 class="mb-0">
                                    <button class="btn btn-link" data-toggle="collapse" data-target="#collapse${album.id}" aria-expanded="true" aria-controls="collapseOne">
                                        ${album.titulo}
                                    </button>
                                </h5>
                            </div>

                            <div id="collapse${album.id}" class="collapse ${vs.count == 1?'show':''}" aria-labelledby="heading${album.id}" data-parent="#accordion">
                                <div class="card-body">
                                    <form action="Chinook">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th scope="col">#</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Género</th>
                                                <th scope="col">Duración</th>
                                                <th scope="col">Bytes</th>
                                                <th scope="col">Precio</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${album.canciones}" var="cancion" varStatus="vs">
                                                <tr>
                                                    <td><input type="checkbox" name="id" value="${cancion.id}" </td>
                                                    <th scope="row">${vs.count}</th>
                                                    <td>${cancion.genero}</td>
                                                    <td>${cancion.duracion}</td>
                                                    <td>${cancion.bytes}</td>
                                                    <td>${cancion.precio}</td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>
                                        <input type="submit" class="btn btn-primary" name="accion" value="Añadir al Carrito">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                

            </div>
            <a href="Chinook?accion=Volver" class="btn btn-primary mt-4 ">Volver</a>

        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>