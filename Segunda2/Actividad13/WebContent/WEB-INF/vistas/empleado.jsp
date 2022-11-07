<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>Gestión de Reuniones</title>
</head>
<body>
	<div class="container m-5">
		<div class="row">
			<h3 class="col-12">Reuniones de ${empleado.apellidos },
				${empleado.nombre }</h3>
		</div>
		<div class="row">
			<c:if test="${empty convoca }">
				<div class="alert alert-info mt-3 mb-3">No hay reuniones</div>
			</c:if>
			<c:if test="${!empty convoca }">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Reunión</th>
							<th scope="col">Fecha</th>
							<th scope="col">Hora</th>
							<th scope="col">Lugar</th>
							<th scope="col">Observaciones</th>
							<th scope="col">Asistentes</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="r" items="${convoca }">
						<tr>
							<th scope="row">${r.nombre }</th>
							<td><fmt:formatDate value="${r.fecha }"/> </td>
							<td>${r.hora }</td>
							<td>${r.lugar }</td>
							<td>${r.observaciones }</td>
							<td><c:forEach var="e" items="${r.asistentes }"><li>${e.apellidos }, ${e.nombre }</li></c:forEach> </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
			</c:if>
			<a href="ConvocarReunion" class="btn btn-primary">Convocar Nueva Reunión</a>
		</div>
		
		<div class="row mt-5">
			<h3 class="col-12">Reuniones en las que participa ${empleado.apellidos },
				${empleado.nombre }</h3>
		</div>
		<div class="row">
			<c:if test="${empty participa }">
				<div class="alert alert-info mt-3 mb-3">No hay reuniones</div>
			</c:if>
			<c:if test="${!empty participa }">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Reunión</th>
							<th scope="col">Fecha</th>
							<th scope="col">Hora</th>
							<th scope="col">Lugar</th>
							<th scope="col">Observaciones</th>
							<th scope="col">Convocada Por</th>
							<th scope="col">Asistentes</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="r" items="${convoca }">
						<tr>
							<th scope="row">${r.nombre }</th>
							<td><fmt:formatDate value="${r.fecha }"/> </td>
							<td>${r.hora }</td>
							<td>${r.lugar }</td>
							<td>${r.observaciones }</td>
							<td>${r.convoca.apellidos }, ${r.convoca.nombre }</td>
							<td><c:forEach var="e" items="${r.asistentes }"><li>${e.apellidos }, ${e.nombre }</li></c:forEach> </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:if>
			<a href="Finalizar" class="btn btn-primary">Finalizar Sesión</a>
		</div>
		
	</div>
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>

	<!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
</body>
</html>