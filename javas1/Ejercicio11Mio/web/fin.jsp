<%-- 
    Document   : fin
    Created on : 09-nov-2019, 20:25:37
    Author     : Francis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Las notas han sido almacenadas correctamente.</h1>
        <br/>
        <h3>Listado de Notas</h3>
        <br/>
        <table class="table">
            <c:forEach items="${moduloProfe.notaList}" var="nota">
                <tr>
                    <td>${nota.idAlumno.id} - ${nota.idAlumno.nombre}</td>
                    <td>${nota.nota}</td>
                </tr>
            </c:forEach>
        </table>
        <button type="submit" class="btn btn-primary" name="accion" value="Finalizar">Finalizar</button>

    </body>
</html>
