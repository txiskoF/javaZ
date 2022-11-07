<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
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
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Gestión de Cuentas</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="mt-5">Bienvenido ${cliente.nombre }</h1>
		</div>
		<div class="row">
			<h3>Listado de Operaciones</h3>
		</div>
		<div class="row">
			<c:if test="${empty cliente.operaciones }">
				<div class="alert alert-info">No hay operaciones del cliente</div>
			</c:if>
			<c:if test="${!empty cliente.operaciones }">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Fecha</th>
							<th scope="col">Concepto</th>
							<th scope="col">Tipo</th>
							<th scope="col">Importe</th>
							<th scope="col">Comentarios</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="o" items="${cliente.operaciones }">
							<tr>
								<td><fmt:formatDate value="${o.fecha }"/></td>
								<td>${o.concepto.descripcion }</td>
								<td>${o.concepto.tipo }</td>
								<td><fmt:formatNumber value="${o.importe }" type="currency"></fmt:formatNumber></td>
								<td>${o.comentarios }</td>
								<td><a href="eliminar?id=${o.id }">Eliminar</a></td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="5">Total</td>
							<td><fmt:formatNumber value="${cliente.total}" type="currency"/></td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
		<hr>
		<div class="row">
		<h3>Nueva operación</h3>
		</div>
		<div class="row">
			<frm:form modelAttribute="operacion" action="guardarOperacion">
				<div class="form-group">
				<label for="idConcepto">Concepto</label>
				<!-- Lista desplagable -->
					<select class="select custom-select" name="idConcepto">
						<c:forEach var="c" items="${conceptos }">
							<option value="${c.id}">${c.tipo} - ${c.descripcion }</option>
						</c:forEach>
					</select>
					<a href="nuevoConcepto" class="btn btn-primary">Nuevo Concepto</a>
				</div>
				<div class="form-group">
					<label for="fecha">Fecha</label> 
					<frm:input path="fecha"
						type="date" class="form-control" id="fecha"></frm:input>
				</div>
				<div class="form-group">
					<label for="importe">Importe</label> 
					<frm:input path="importe"
						class="form-control" id="importe"></frm:input>
				</div>
				<div class="form-group">
					<label for="comentarios">Comentarios</label> 
					<frm:textarea path="comentarios" 
						class="form-control" id="comentarios"></frm:textarea>
				</div>
				<button type="submit" class="btn btn-primary">Guardar</button>
				<a href="volver" class="btn btn-secondary">Salir</a>
			</frm:form>
		</div>
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