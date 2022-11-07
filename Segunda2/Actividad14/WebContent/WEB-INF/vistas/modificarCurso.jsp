<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>Gestión de Cursos</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-12 text-center">
				<h1>Especifique los datos del curso</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<frm:form action="Guardar" modelAttribute="curso">
					<c:if test="${! empty curso.id }">
						<div class="form-group">
						<label for="id">Id</label> 
						<input type="text"
							name="id"
							class="form-control" id="id"
							value="${curso.id }"
							readonly>
					    
					</div>
					</c:if>
					<div class="form-group">
						<label for="titulo">Título</label> 
						<frm:input type="text"
							path="titulo"
							class="form-control" id="titulo"/>
						<frm:errors class="text-danger" path="titulo"></frm:errors>
					</div>
					<div class="form-group">
						<label for="tema">Tema</label> 
						<select class="select custom-select" name="idTema">
							<c:forEach var="t" items="${temas }">
							<option value="${t.id }" ${t.id==curso.tema.id?"SELECTED":"" }>${t.descripción }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<label for="fechaInicio">Fecha Inicio</label> 
						<frm:input type="date"
							path="fechaInicio"
							class="form-control" id="fechaInicio"/>
						<frm:errors class="text-danger" path="fechaInicio"></frm:errors>
					</div>
					<div class="form-group">
						<label for="fechaFin">Fecha Fin</label> 
						<frm:input type="date"
							path="fechaFin"
							class="form-control" id="fechaFin"/>
					    <frm:errors class="text-danger" path="fechaFin"></frm:errors>
					</div>
					<div class="form-group">
						<label for="precio">Precio</label> 
						<frm:input type="text"
							path="precio"
							class="form-control" id="precio"/>
						<frm:errors class="text-danger" path="precio"></frm:errors>
					</div>
					<div class="form-group">
						<label for="titulo">Asistentes</label> 
						<frm:input type="text"
							path="asistentes"
							class="form-control" id="asistentes"/>
					</div>
					
					<div class="mt-4"></div>
					<button type="submit" class="btn btn-primary">Guardar</button>
					<a href="Cancelar" class="btn btn-primary">Cancelar</a>
				</frm:form>
				<c:if test="${!empty error}">
					<div class="alert alert-danger mt-3">${error }</div>
				</c:if>
			</div>
		</div>
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