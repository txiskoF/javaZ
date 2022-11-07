<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>Gestión de Tareas</title>
</head>
<body>
	<div class="container">
	
			
			<!-- PARA MOSTARAR EL NOMBRE -->
	
		<div class="row mt-5">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h1>Bienvenido/a ${usuario.nombre } ${usuario.apellidos } <a href="Salir" class="btn btn-outline-primary">Salir</a></h1>
			</div>
		</div>
		
		<!-- TAREAS -->
		
		<div class="row mt-3">
		
				<!-- SI NO HAY TAREAS -->
				
			<c:if test="${empty tareas}">
				<div class="col-2"></div>
				<div class="col-10 alert alert-info">No hay tareas</div>
			</c:if>
			
						<!-- SI HAY TAREAS PARA MOSTRAR -->
			
			<c:if test="${!empty tareas}">
			
					<!-- PINTO LA TABLA -->
			
			<div class="col-12">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Título</th>
							<th scope="col">Fecha</th>
							<th scope="col">Descripción</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					
							<!-- COJO LA TAREAS 
							 GUARDO EN T Y MUESTRO CON UN IF -->
					
					<tbody>
					<c:forEach var="t" items="${tareas }">
						<tr>
							<th scope="row">${t.id }</th>
							<td>${t.titulo }</td>
							<td><fmt:formatDate value="${t.fecha }"/></td>
							<td>${t.descripcion }</td>
							
								<!-- SI NO ESTA REALIZADA PINTO EL FINALIZAR -->
							
							<td><c:if test="${!t.realizada }"><a href="Finalizar?idTarea=${t.id}" class="btn btn-outline-primary">Finalizar</a></c:if></td>
							
									<!-- PINTO EL BOTON DE FINALIZAR -->
							
							<td><a href="Eliminar?idTarea=${t.id}" class="btn btn-outline-danger">Eliminar</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			</c:if>
		</div>
		<hr>
		
			<!-- PARA UNA NUEVA TAREA -->
		
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8 text-center"><h3>Nueva Tarea</h3></div>
		</div>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<frm:form action="/nueva" modelAttribute="tarea">
					<div class="form-group">
						<label for="exampleInputEmail1">Título</label> 
						<frm:input type="text"
							class="form-control" id="exampleInputEmail1" path="titulo"
							/>
						
					</div>
					<div class="row">
					<frm:errors path="titulo" cssClass="ml-3 alert alert-danger"></frm:errors>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Fecha</label> 
						<frm:input
							type="date" class="form-control" id="exampleInputPassword1"
							path="fecha"></frm:input>
						
					</div>
					<div class="row">
						<frm:errors path="fecha" cssClass="ml-3 alert alert-danger"></frm:errors>
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">Descripción</label> 
						<frm:textarea
							class="form-control" id="exampleInputPassword1"
							path="descripcion"/>
					</div>
					<button type="submit" class="btn btn-primary">Guardar</button>
				</frm:form>
			</div>
		</div>
		<div class="row mt-3">
			<div class="col-4"></div>
			<div class="col-8">
				<c:forEach var="e" items="${errores }">
					<div class="alert alert-danger">${e}</div>
				</c:forEach>
			</div>
		</div>
	</div>

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