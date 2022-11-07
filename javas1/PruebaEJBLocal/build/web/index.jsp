<%-- 
    Document   : index
    Created on : 29-oct-2019, 11:54:34
    Author     : ichueca
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Satateless</h2>
        <c:forEach items="${nombresStateless}" var="nombre">
        <li>${nombre}</li>
        </c:forEach>
        <h2>Satateful</h2>
        <c:forEach items="${nombresStateful}" var="nombre">
        <li>${nombre}</li>
        </c:forEach>
        <form action="PruebaEJB">
            Nombre : <input type="text" name="nombre">
            <input type="submit" name="accion" value="Nuevo">
        </form>
    </body>
</html>
