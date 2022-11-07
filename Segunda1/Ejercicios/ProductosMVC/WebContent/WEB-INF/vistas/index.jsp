<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="es">
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

<title>Gestión de Productos</title>
</head>
<body>
	<div class="container m-5">
		<div class="row">
			<h1>Gestión de Productos</h1>
		</div>
		<div class="row">
			<form action="/ProductosMVC/seleccionarCategoria">
				<select class="select custom-select" name="id">
					<c:forEach var="c" items="${categorias}">
						<option value="${c.id}" ${c.id==categoria.id?"SELECTED":"" }>${c.descripcion }</option>
					</c:forEach>
				</select>
				<button type="submit" class="mt-3 btn btn-primary">Ver
					Productos</button>
			</form>
		</div>
		<div class="row mt-2">
		<c:if test="${empty categoria.productos }">
			<div class="alert alert-warning">No hay productos de esa categoria</div>
		</c:if>
		<c:if test="${!empty categoria.productos }">
					<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nombre</th>
						<th scope="col">Precio</th>
						<th scope="col">Fecha Compra</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoria.productos }" var="p">
						<tr>
							<th scope="row">${p.id }</th>
							<td>${p.nombre }</td>
							<td><fmt:formatNumber value="${p.precio }" type="currency" /></td>
							<td><fmt:formatDate value="${p.fechaCompra }"
									dateStyle="medium" /></td>
							<td>
								<!-- <a href="eliminar?id=${p.id }"> --> <a
								href="/ProductosMVC/eliminar/${p.id}">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</c:if>
		</div>
		<div class="row">
			<div>
				<form:form action="/ProductosMVC/nuevo" modelAttribute="producto">
					<form:input type="hidden" path="id"></form:input>
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<form:input type="text" class="form-control" id="nombre"
							path="nombre" aria-describedby="emailHelp"
							placeholder="Nombre del producto"></form:input>

					</div>

					<div class="form-group">
						<label for="precio">Precio</label>
						<form:input type="text" class="form-control" id="precio"
							path="precio" placeholder="Precio del producto" />

					</div>
					<div class="form-group">
						<label for="fecha">Fecha Compra</label>
						<form:input type="date" class="form-control" id="fecha"
							path="fechaCompra" placeholder="Precio del producto" />

					</div>
					<button type="submit" class="btn btn-primary">Añadir</button>

					<div class="row">
						<form:errors path="nombre" cssClass="alert alert-danger mt-3"></form:errors>
					</div>
					<div class="row">
						<form:errors path="precio" cssClass="alert alert-danger mt-3"></form:errors>
					</div>
					<div class="row">
						<form:errors path="fechaCompra" cssClass="alert alert-danger mt-3"></form:errors>
					</div>
				</form:form>
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