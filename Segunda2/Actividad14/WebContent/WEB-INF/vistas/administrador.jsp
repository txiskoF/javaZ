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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Gestión de Cursos</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4 text-center">
				<h1>Bienvenido/a ${usuario.usuario }</h1>
			</div>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Título</th>
						<th scope="col">Tema</th>
						<th scope="col">Fecha Inicio</th>
						<th scope="col">Fecha Fin</th>
						<th scope="col">Precio</th>
						<th scope="col">Asistentes</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="c" items="${cursos }">
					<tr>
						<th scope="row">${c.id }</th>
						<td>${c.titulo }</td>
						<td>${c.tema.descripción }</td>
						<td><fmt:formatDate value="${c.fechaInicio }"/> </td>
						<td><fmt:formatDate value="${c.fechaFin }"/> </td>
						<td><fmt:formatNumber type="currency" value="${c.precio }"/> </td>
						<td>${c.asistentes }</td>
						<td>
						<c:if test="${c.getFechaFin().before(hoy) }">
							<a href="Eliminar?id=${c.id }" class="btn btn-primary">Eliminar</a>
						</c:if>
						<c:if test="${c.getFechaInicio().after(hoy) }">
							<a href="Modificar?id=${c.id }" class="btn btn-primary">Modificar</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<a href="Nuevo" class="btn btn-primary">Añadir Nuevo Curso</a>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>