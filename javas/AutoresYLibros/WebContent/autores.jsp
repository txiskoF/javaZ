<%@page import="net.zabalburu.jpa.modelo.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<% List<Autor> autores = (List<Autor>) request.getAttribute("autores"); %>
<title>Listado de Autores</title>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h1>Listado de Autores</h1>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col-1"></div>
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Apellidos</th>
							<th scope="col">Nombre</th>
							<th scope="col">Dirección</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<%
						for(Autor a : autores){
					%>
						<tr>
							<th scope="row"><%= a.getId() %></th>
							<td><%= a.getApellidos() %></td>
							<td><%= a.getNombre() %></td>
							<td><%= a.getDireccion() %> - <%= a.getCiudad() %>
							( <%= a.getTelefono() %> )</td>
							<td><a href="Autores?accion=VerLibros&id=<%= a.getId() %>">Ver Libros</a></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>