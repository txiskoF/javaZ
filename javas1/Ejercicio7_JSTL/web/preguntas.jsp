<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a href="preguntas?accion=Salir"><img class="rounded-circle" style="width: 25%" src="${usuario.urlFoto}"></a>
                </div>
            </div>
            <div class="mb-3">
                <a href="preguntas?accion=Nueva">Nueva Pregunta</a>
            </div>
            <c:if test="${!empty preguntas}">
                <c:forEach items="${preguntas}" var="p">
                    <div class="row">
                        <div class="col-2">
                            <img class="rounded-circle" style="width: 40%" src="${p.usuario.urlFoto}">
                            <div>${p.usuario.nombre}</div>
                        </div>
                        <div>
                            <div><fmt:formatDate value="${p.fecha}" type="both" 
                                            dateStyle="medium" timeStyle="short"></fmt:formatDate></div>
                            <div>${p.texto}</div>
                            <a href="preguntas?accion=Respuesta&id=${p.id}">Responder</a>
                        </div>
                    </div>
                    <c:if test="${!empty p.respuestas}">
                        <c:forEach items="${p.respuestas}" var="r">
                            
                            <div class="row">
                                <div class="col-2"></div>
                                <div class="col-2">
                                    <img class="rounded-circle" style="width: 40%" src="${r.usuario.urlFoto}">
                                    <div>${r.usuario.nombre}</div>
                                </div>
                                <div>
                                    <div><fmt:formatDate value="${r.fecha}" type="both" 
                                            dateStyle="medium" timeStyle="short"></fmt:formatDate></div>
                                    <div>${r.texto}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </c:if>

            <c:if test="${empty preguntas}">
                <div class="row">
                    <div class="col-3"></div>
                    <div class="col-6 alert alert-info">No hay preguntas. Añada una!</div>
                </div>
            </c:if>
        </div> 
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
