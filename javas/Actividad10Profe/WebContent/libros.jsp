<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Chinook</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h3>Sus libros</h3>
			</div>
		</div>
		<form action="Recomendaciones">
		<c:if test="${empty empleado.listaLectura }">
			<div class="row m-5">
				<div class="col-2"></div>
				<div class="col-8"><h3>No hay libros en su Lista de Lectura</h3></div>
			</div>
		</c:if>
		<c:if test="${!empty empleado.listaLectura }">
			<div class="row m-5">
				<div class="col-12">
				
					<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Título</th>
								<th scope="col">Tipo</th>
								<th scope="col">Seleccionar</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="l" items="${empleado.listaLectura }">
							<tr>
								<th scope="row">${l.id }</th>
								<td>${l.titulo }</td>
								<td>${l.tipo }</td>
								<td><input type="checkbox" name="id" value="${l.id }"></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<button class="btn btn-primary" name="accion" value="Quitar">Quitar</button>
				</div>
			</div>
		</c:if>
		<div class="row">
			<button class="btn btn-primary m-2" name="accion" value="VerRecomendaciones">Ver Recomendaciones</button>
			<button class="btn btn-primary m-2" name="accion" value="VerTodos">Ver Todos</button>
			<button class="btn btn-primary m-2" name="accion" value="Salir">Salir</button>
		</div>
		</form>
		
		<div class="row m-2">
			<div class="col-2"></div>
			<c:if test="${! empty error }">
				<div class="cal-8 alert alert-info">${error }</div>
			</c:if>
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
