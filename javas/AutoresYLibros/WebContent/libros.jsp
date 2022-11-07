<%@page import="net.zabalburu.jpa.modelo.Titulo"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DateFormat"%>
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
<% 	Autor autor = (Autor) request.getAttribute("autor");
	DateFormat df = DateFormat.getDateInstance();
	NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<title>Libros de <%= autor.getApellidos() %>, <%= autor.getNombre() %></title>
</head>
<body>
	<div class="container">
		<div class="row mt-3">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h1>Libros de <%= autor.getApellidos() %>, <%= autor.getNombre() %></h1>
			</div>
		</div>
		
		<% if (autor.getTitulos().isEmpty()) { %>
		<div class="row mt-2">
			<div class="col-1"></div>
			<div class="col-10">
				<div class="alert alert-info">No hay libros de este autor</div>
			</div>
		</div>
		<% } else { %>
		<div class="row mt-2">
			<div class="col-1"></div>
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Título</th>
							<th scope="col">Fecha Pub.</th>
							<th scope="col">Tipo</th>
							<th scope="col">Precio</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(Titulo t : autor.getTitulos()){
					%>
						<tr>
							<th scope="row"><%= t.getId() %></th>
							<td><%= t.getTitulo() %></td>
							<td><%= df.format(t.getFechaPublicacion()) %></td>
							<td><%= t.getTipo() %></td>
							<td><%= nf.format(t.getPrecio()) %></td>
						</tr>
					<% } %>
					</tbody>
				</table>
			</div>
		</div>
		<% } %>
		<div class="row mt-2">
			<div class="col-1"></div>
			<div class="col-10">
			<a href="Autores?accion=Volver" class="btn btn-primary mt-2">Volver</a>
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