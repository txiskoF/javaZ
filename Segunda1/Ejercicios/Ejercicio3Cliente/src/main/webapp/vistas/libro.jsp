<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- METER PARA FORMATO PRECIO  -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Gestión de Compras</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/">${usuario }</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/miscompras">Mis
						Compras</a></li>

			</ul>
			<form class="form-inline my-2 my-lg-0" action="buscarLibros">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="busqueda">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar
					Libros</button>
			</form>
		</div>
	</nav>
	<div class="container m-4">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6 text-center">
				<h1>Gestión de Compras</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<table class="table">
					<tbody>
						<tr>
						<!-- TABALA PARA MOSTAR LA INFORMACIONDE CADA LIBRO  -->
							<th scope="row">Id:
							<td>${libro.id }</td>
						</tr>
						<tr>
							<th scope="row">Título:
							<td>${libro.titulo }</td>
						</tr>
						<tr>
							<th scope="row">Editorial:
							<td>${libro.editorial.nombre }</td>
						</tr>
						<tr>
							<th scope="row">Tipo:
							<td>${libro.tipo }</td>
						</tr>
						<tr>
							<th scope="row">Precio:</th>
							<td><fmt:formatNumber type="currency">${libro.precio }</fmt:formatNumber></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!-- AÑADIR CUANTS UNIDADES A VENDER  -->
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action="comprarLibro">
					<div class="form-group">
						<label for="unidades">Unidades</label> <input
							type="number" value="1" class="form-control" id="unidades"
							name="unidades"
							placeholder="Unidades a comprar del libro">
					</div>
					<!-- ENVIO EL ID DEL LIBRO  -->
					<input type="text" hidden="hidden" name="id" value="${libro.id }">
					<button type="submit" action="comprar" class="btn btn-primary">Comprar</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>