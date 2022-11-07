<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Gestión de Cuentas</title>
</head>
<body>
	<div class="container">
		<h1 class="mt-5">Introduzca sus datos</h1>
		<frm:form modelAttribute="cliente" action="login" method="POST">
			<div class="row">
				<div class="form-group">
					<label for="nombre">Introduzca su nombre</label>
					<frm:input path="nombre" type="text" class="form-control"
						id="nombre"></frm:input>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="password">Contraseña</label>
					<frm:input path="password" type="password" class="form-control"
						id="password" />
				</div>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-primary">Entrar</button>
			</div>

			<div class="row mt-3">
				<frm:errors path="nombre" class="alert alert-danger">
				</frm:errors>
			</div>
			<div class="row mt-3">
				<frm:errors path="password" class="alert alert-danger">

				</frm:errors>
			</div>
		</frm:form>

	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>