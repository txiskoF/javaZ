<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Chinook</title>
</head>
<body>
	<div class="container mt-3">
		<jsp:include page="cabecera.jsp"></jsp:include>
		<div class="row">
			<div class="col-12 text-center">
				<h1>Sus compras</h1>
			</div>
		</div>
		<c:choose>
			<c:when test="${empty carrito }">
				<div class="row">
				 <div class="alert alert-info">Su carrito está vacío</div>
				 
				 </div>
				 <div class="row">
				 <a href="Chinook?accion=volver" class="btn btn-primary mt-2 mb-2">Volver</a>
				 </div>
			</c:when>
			<c:otherwise>
				<div class="row">
					<form acion="Chinook">
						<table class="table">
							<thead>
								<tr>
									<th></th>
									<th scope="col">#</th>
									<th scope="col">Nombre</th>
									<th scope="col">Género</th>
									<th scope="col">Duración</th>
									<th scope="col">Bytes</th>
									<th scope="col">Precio</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="carrito" items="${carrito }">
									<tr>
										<td><input type="checkbox" name="id"
											value="${carrito.id }"></td>
										<th scope="row">${ carrito.id}</th>
										<td>${carrito.pista.nombre }</td>
										<td>${carrito.pista.genero.nombre }</td>
										<td>${carrito.pista.duracionTexto }</td>
										<td><fmt:formatNumber value="${carrito.pista.bytes }"
												type="number" /></td>
										<td><fmt:formatNumber value="${carrito.pista.precio }"
												type="currency" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
				</div>
				<button class="btn btn-primary mt-2 mb-2" type="submit" name="accion"
			value="quitar">Quitar del Carrito</button>
		<button class="btn btn-primary mt-2 mb-2" type="submit" name="accion"
			value="finCompra">Finalizar Compra</button>
		<button class="btn btn-primary mt-2 mb-2" type="submit" name="accion"
			value="volver">Volver</button>
			</c:otherwise>
		</c:choose>
		
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