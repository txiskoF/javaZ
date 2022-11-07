<%-- 
    Document   : libros
    Created on : 26-sep-2019, 13:27:04
    Author     : ichueca
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="net.zabalburu.ejercicio3.modelo.Libro"%>
<%@page import="net.zabalburu.ejercicio3.dao.LibroBBDD"%>
<%@page import="net.zabalburu.ejercicio3.dao.LibroDAO"%>
<%!
    private LibroDAO dao = new LibroBBDD();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Libros</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Título</th>
                    <th>Tipo</th>
                    <th>Precio</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for(Libro l : dao.getLibros()){
                %>
                <tr>
                    <td><a href="detalle.jsp?id=<%= l.getIdLibro() %>"><%= l.getIdLibro() %></a></td>
                    <td><%= l.getTitulo() %></td>
                    <td><%= l.getTipo() %></td>
                    <td><%= nf.format(l.getPrecio()) %></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>

            
        
    </body>
</html>
