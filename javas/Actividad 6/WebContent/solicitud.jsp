<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
%>
<title>Gestión de Reparaciones</title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-2"></div>
			<div class="col-8 text-center">
				<h3>Solicitud de Reparación</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<form action="reparaciones">
					<div class="form-group">
						<label for="exampleInputEmail1">Usuario</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="usuario"
							placeholder="Introduzca su usuario"
							value='<%= usuario.getUsuario() %>' readonly>
					</div>
					<div class="form-group">
						<label for="elemento">Elemento</label> 
						<select class="select custom-select" name="elemento">
							<option>Ordenador</option>
							<option>Monitor</option>
							<option>Internet</option>
							<option>Otros</option>
						</select>
					</div>
					<div class="form-group">
						<label for="fecha">Fecha Solicitud</label> 
						<input type="date"
							class="form-control" id="fecha"
							aria-describedby="emailHelp" name="fechaSolicitud"
							
							value='<%= df.format(new Date()) %>'>
					</div>
					<div class="form-group">
						<label for="descripcion">Descripción</label> 
						<textarea
							class="form-control" id="descripcion"
							name="descripcion"></textarea>
					</div>
					<button type="submit" class="btn btn-primary mb-4" name="accion"
						value="EnviarSolicitud">Enviar</button>
				</form>
			</div>
			
		</div>
		<% 
			List<String> errores = (List<String>) request.getAttribute("errores");
			if (errores != null){
				for(String error : errores) {
				
		%>
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<div class="alert alert-danger"><%= error %></div>
			</div>
		</div>
		<%
				}
			}
		%>
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