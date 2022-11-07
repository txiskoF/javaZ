<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
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

<title>Gestión</title>
</head>
<body>
	<div class="container m-5">
		<div class="row">
			<h1 class="col-12 text-center">Bienvenido/a ${usuario.nombre }
				${usuario.apellidos }</h1>
		</div>
		<div class="row">
			<c:if test="${empty usuario.operaciones }">
				<div class="alert alert-info mt-3">No hay operaciones</div>
			</c:if>
			<c:if test="${!empty usuario.operaciones }">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Descripción</th>
							<th scope="col">Importe</th>
							<th scope="col">Fecha</th>
							<th scope="col">Comentarios</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${usuario.operaciones }">
							<tr>
								<th scope="row">${o.id }</th>
								<td>${o.concepto.descripcion }</td>
								<td><fmt:formatNumber type="currency" value="${o.importe }"></fmt:formatNumber> </td>
								<td><fmt:formatDate value="${o.fecha }"></fmt:formatDate> </td>
								<td>${o.comentarios }</td>
							</tr>
						</c:forEach>
						<tr>
								<th scope="row"></th>
								<td></td>
								<td></td>
								<td></td>
								<td>Total : <fmt:formatNumber type="currency" value="${usuario.total }"></fmt:formatNumber> </td>
							</tr>
					</tbody>
				</table>
			</c:if>
		</div>
		<div class="row">
			<h3>Nueva Operación</h3>
		</div>
		<div class="row">
		<div class="col-12">
		<form action="Gestion">
			<div class="form-group">
				<label for="exampleInputEmail1">Concepto <button type="submit" class="btn btn-primary" name="accion" value="Nuevo Concepto">Nuevo Concepto</button></label> 
				<select name="concepto" class="select custom-select">
					<c:forEach var="c" items="${conceptos }">
					<option value="${c.id }">${c.tipo }:${c.descripcion }</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Fecha</label> 
				<input
					type="date" name="fecha" class="form-control" id="exampleInputPassword1" value="${hoy }">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Importe</label> 
				<input
					type="text" name="importe" value="0,0" class="form-control" id="exampleInputPassword1">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Comentarios</label> 
				<textarea name="comentarios" class="form-control"></textarea>
			</div>
			<button type="submit" class="btn btn-primary" name="accion" value="Guardar">Guardar</button>
			<button type="submit" class="btn btn-primary" name="accion" value="Volver">Volver</button>
		</form>
		</div>
		</div>
		<c:if test="${!empty error }">
			<div class="alert alert-info mt-3">${error }</div>
		</c:if>
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