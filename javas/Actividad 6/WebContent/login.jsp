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

<title>Gestión de Reparaciones</title>
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
				<form action="reparaciones">
					<div class="form-group">
						<label for="exampleInputEmail1">Usuario</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="usuario"
							placeholder="Introduzca su usuario"
							value='<%= (request.getParameter("usuario")!=null)?request.getParameter("usuario"):"" %>'>
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
		<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
		%>
		<div class="row m-2">
			<div class="col-2"></div>
			<div class="cal-8 alert alert-info"><%=error%></div>
		</div>
		<%
			}
		%>
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