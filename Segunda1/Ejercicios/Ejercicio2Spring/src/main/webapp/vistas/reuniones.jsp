<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>

<html lang="es">

<head>
<title>Gestión de Reuniones</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>
	<div class="container ">
		<div class="row">
			<h1 class="col-12 text-center">Reuniones de ${empleado.nombre}
				${empleado.apellidos}</h1>
		</div>
		<div class="row">
			<div class="col-12">
				<c:if test="${empty empleado.reunionesConvocadas}">
					<div class="alert alert-info">No hay reuniones convocadas</div>
				</c:if>
				<c:if test="${!empty empleado.reunionesConvocadas}">
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
							<c:forEach var="r" items="${empleado.reunionesConvocadas }">
								<tr>
									<td>${r.nombre }</td>
									<td><fmt:formatDate value="${r.fecha }"/></td>
									<td>${r.hora }</td>
									<td>${r.lugar }</td>
									<td>${r.observaciones }</td>
									<td>
									<ul>
										<c:forEach var="re" items="${r.participantes }">
											<li>${re.empleado.apellidos} ${re.empleado.nombre}</li>
										</c:forEach>
									</ul>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<a href="nueva" class="btn btn-primary">Convocar Nueva Reunión</a>
			</div>
		</div>
		<hr>
		<div class="row">
			<h1 class="col-12 text-center">Invitaciones a reuniones</h1>
		</div>
		<div class="row">
			<div class="col-12">
				<c:if test="${empty empleado.reunionesParticipa}">
					<div class="alert alert-info">No hay invitaciones a reuniones</div>
				</c:if>
				<c:if test="${!empty empleado.reunionesParticipa}">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Reunión</th>
								<th scope="col">Fecha</th>
								<th scope="col">Hora</th>
								<th scope="col">Lugar</th>
								<th scope="col">Observaciones</th>
								<th scope="col">Convocada por</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="r" items="${empleado.reunionesParticipa }">
								<tr>
									<td>${r.reunion.nombre }</td>
									<td><fmt:formatDate value="${r.reunion.fecha }"/></td>
									<td>${r.reunion.hora }</td>
									<td>${r.reunion.lugar }</td>
									<td>${r.reunion.observaciones }</td>
									<td>
									${r.reunion.empleado.apellidos } ${r.reunion.empleado.nombre }
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<a href="finalizar" class="btn btn-primary">Finalizar sesión</a>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>
</body>
</html>