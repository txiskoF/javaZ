<%@page import="net.zabalburu.actividad6.modelo.Usuario"%>
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
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<title>Gestión de Reparaciones</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5 mb-2">
			<div class="col-2"></div>
			<div class="col-4 text-center">
				<h3>
					Bienvenida <%=usuario.getUsuario()%>
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-4">
				<ul>
					<li><h4><a href="reparaciones?accion=Solicitud">Solicitud de
							Reparación</a></h4></li>
					<li><h4><a href="reparaciones?accion=Comprobar">Comprobar
							Reparaciones</a></h4></li>
					<%
						if (usuario.getRol().equalsIgnoreCase("Reparador")) {
					%>
					<li><h4><a href="reparaciones?accion=Reparar">Reparar</a></h4></li>
					<%
						}
					%>
					<li><h4><a href="reparaciones?accion=Salir">Salir</a></h4></li>
				</ul>
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