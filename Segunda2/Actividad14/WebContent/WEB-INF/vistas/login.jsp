<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="container m-3">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4 text-center">
				<h1>Identifíquese </h1>
			</div>
		</div>
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<frm:form action="login" modelAttribute="usuario">
					<div class="form-group">
						<label for="usuario">Usuario</label> 
						<frm:input type="text"
							path="usuario"
							class="form-control" id="usuario"
							placeholder="Introduzca su usuario"/>
					    <div class="mt-4"></div>
					    <frm:errors class="alert alert-danger mt-3"  path="usuario"></frm:errors>
					</div>
					<div class="form-group">
						<label for="password">Password</label> 
						<frm:input type="password"
							path="password"
							class="form-control" id="password" placeholder="Password"/>
						<div class="mt-4"></div>
						<frm:errors class="alert alert-danger mt-3" path="password"></frm:errors>
					</div>
					<button type="submit" class="btn btn-primary">Entrar</button>
				</frm:form>
				<c:if test="${!empty error}">
					<div class="alert alert-danger mt-3">${error }</div>
				</c:if>
			</div>
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