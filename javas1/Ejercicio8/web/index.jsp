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
                <h1>Selección de Artistas</h1>
            </div>
            <div class="row">
                <c:forEach var="letra" items="${iniciales}">
                    <a class=" ml-4" href="Chinook?accion=CambiarInicial&letra=${letra}">${letra}</a>
                </c:forEach>
            </div>
            <div class="row mt-3">
                <h1>${artistas[0].nombre.charAt(0)}</h1>
                <hr>
            </div>
            <div class="row">
                <ul>
                    <c:forEach items="${artistas}" var="a" begin="${(pagina-1)*5}" end="${pagina*5-1}">
                        <li><a href="Chinook?accion=cambioArtista&id=${a.id}">${a.nombre}</a></li>
                        </c:forEach>
                </ul>
            </div>
            <div class="row">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <c:if test="${pagina != 1}">
                            <li class="page-item"><a class="page-link" href="Chinook?accion=IrAPag&pagina=1">Anterior</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${totalPaginas}" varStatus="vs">
                            <li class="page-item ${pagina==vs.count?'active':''}"><a class="page-link" href="Chinook?accion=IrAPag&pagina=${vs.count}">${vs.count}</a></li>
                            </c:forEach>
                            <c:if test="${pagina != totalPaginas}">
                            <li class="page-item"><a class="page-link" href="Chinook?accion=IrAPag&pagina=${totalPaginas}">Último</a></li>
                            </c:if>
                    </ul>
                </nav>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>