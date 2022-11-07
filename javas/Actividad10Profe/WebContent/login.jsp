<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>Recomendaciones</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h3>Identifíquese</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<form action="Controlador">
					<div class="form-group">
						<label for="cliente">Seleccione su nombre</label>
						<select class="select custom-select" name="id">
						<c:forEach var="e" items="${empleados }">
							<option value="${e.id }">${e.apellidos }, ${e.nombre } ${e.incial }</option> ${e.id }
						</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name="password">
					</div>
					<button type="submit" class="btn btn-primary" name="accion"
						value="Entrar">Entrar</button>
				</form>
			</div>

		</div>

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
</html>