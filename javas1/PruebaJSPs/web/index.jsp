<%-- 
    Document   : prueba
    Created on : 26-sep-2019, 12:43:44
    Author     : ichueca
--%>
<%!
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String nombre = "";
    String password = "";
    String accion = request.getParameter("accion");
    if (accion!=null){
        nombre = request.getParameter("nombre");
        password = request.getParameter("password");
        if (nombre.equalsIgnoreCase("admin") && password.equals("admin")){
            response.sendRedirect("libros.jsp");
            return;
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="index.jsp">
            Nombre : <input type="text" name="nombre" value="<%= nombre %>"><br>
            Password : <input type="password" name="password"><br>
            <input type="submit" name="accion" value="Login">
        </form>
        <% 
            if (accion != null) {
        %>
        <div style="color: red">Nombre / password erróneos</div> 
        <% 
            }
        %>
    </body>
</html>
