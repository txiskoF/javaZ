<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<title>ProductosMVC</title>
</head>
<body>
	<div class="container m-5">
		<div class="row">
			<h1 class="col-12 text-center">
				ProductosMVC <img src="recursos/logo.jpg" width="100px"> ${empleado }
			</h1>
		</div>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Categoría</th>
						<th scope="col">Precio</th>
						<th scope="col">Fecha Compra</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${productos }">
					<tr>
						<th scope="row">${p.id }</th>
						<td>${p.nombre }</td>
						<td>${p.categoria.descripcion }</td>
						<td><fmt:formatNumber type="currency" value="${p.precio }"></fmt:formatNumber> </td>
						<td><fmt:formatDate value="${p.fechaCompra }"></fmt:formatDate> </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<div class="col-12">
				<form:form action="nuevo" modelAttribute="producto">
					<div class="form-group">
						<label for="nombre">Nombre</label> 
						<form:input type="text"
							path="nombre"
							class="form-control" id="nombre" name="nombre"
							placeholder="Nombre Producto"></form:input>
						<form:errors path="nombre" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="nombre">Categoría</label> 
						<select name="idCategoria"
							class="select custom-select">
							<c:forEach var="c" items="${categorias }">
								<option value="${c.id }">${c.descripcion }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="precio">Precio</label> 
						<form:input type="text"
							path="precio"
							class="form-control" id="precio" name="precio"
							placeholder="Nombre Producto"></form:input>
						<form:errors path="precio" class="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="fechaCompra">Fecha Compra</label> 
						<form:input type="date"
							path="fechaCompra"
							class="form-control" id="fechaCompra"></form:input>
						<form:errors path="fechaCompra" class="text-danger"></form:errors>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
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