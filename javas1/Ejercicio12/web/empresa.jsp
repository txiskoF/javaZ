<%-- 
    Document   : seleccionprofesor
    Created on : 11-nov-2019, 10:22:56
    Author     : ichueca
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h2>${empresa.nombre}</h2>
            <h4>${empresa.direccion} - ${empresa.nif}</h4>
            <h5>Cursos reservados actualmente</h5>
            <c:if test="${empty empresa.reservaList}">
                <div class="alert alert-info m-5">No hay reservas</div>
            </c:if>
            <c:if test="${!empty empresa.reservaList}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Descripción</th>
                            <th scope="col">Fecha</th>
                            <th scope="col">Horas</th>
                            <th scope="col">Personas</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${empresa.reservaList}" var="reserva">
                            <tr>
                                <th scope="row">${reserva.idReserva}</th>
                                <td>${reserva.idCurso.descripcion}</td>
                                <td><fmt:formatDate dateStyle="medium" value="${reserva.idCurso.fecha}"></fmt:formatDate></td>
                                <td>${reserva.idCurso.horas}</td>
                                <td>${reserva.reservas}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <h5>Cursos disponibles</h5>
            <c:if test="${empty disponibles}">
                <div class="alert alert-info m-5">No hay cursos disponibles</div>
            </c:if>
            <c:if test="${!empty disponibles}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Descripción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${disponibles}" var="c">
                            <tr>
                                <th scope="row">${c.idCurso}</th>
                                <td><a href="GestionReservas?accion=Reservar&id=${c.idCurso}">${c.descripcion}</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
                <a href="GestionReservas?accion=Salir">Salir</a>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>