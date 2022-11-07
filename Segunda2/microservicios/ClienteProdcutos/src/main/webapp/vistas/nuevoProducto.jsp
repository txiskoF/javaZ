<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
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

<title>Productos</title>
</head>
<body>
	<div class="container">
		<jsp:include page="navegacion.jsp"></jsp:include>
		<frm:form modelAttribute="producto" action="/guardar" class="mt-5 mb-4">
			<div class="form-group">
				<label for="nombre">Nombre</label> 
				<frm:input
					type="text" class="form-control" id="nombre"
					path="nombre" placeholder="Nombre Producto"></frm:input>
				
			</div>
			<frm:errors path="nombre" class="text-danger mt-4">
				</frm:errors> 
			<div class="form-group">
				<label for="categoria">Categoria</label> 
				<select name="idCategoria" class="select custom-select">
					<c:forEach var="c" items="${categorias }">
					<option value="${c.id }">${c.descripcion }</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="fecha">Fecha Compra</label> 
				<frm:input
					type="date" class="form-control" id="fecha"
					path="fechaCompra"></frm:input>
				
			</div>
			<frm:errors path="fechaCompra" class="text-danger mt-2">
				</frm:errors>
			<div class="form-group">
				<label for="precio">Precio</label> 
				<frm:input
					type="text" class="form-control" id="precio"
					path="precio"></frm:input>
				
			</div>
			<frm:errors path="precio" class="text-danger mt-2">
				</frm:errors>
			<button type="submit" class="btn btn-primary">Guardar</button>
		</frm:form>
		<c:if test="${! empty error }">
			<div class="alert alert-danger mt-3">${error }</div>
		</c:if>
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