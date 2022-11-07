<%@page import="java.text.NumberFormat"%>
<%@page import="net.zabalburu.actividad6.modelo.Reparacion"%>
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
List<Reparacion> reparaciones = (List<Reparacion>) request.getAttribute("pendientes");
DateFormat df = DateFormat.getDateInstance();
NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<title>Reparaciones Pendientes%></title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-1"></div>
			<div class="col-10 text-center">
				<h3>Reparaciones Pendientes</h3>
			</div>
		</div>
		<%
			if (reparaciones.isEmpty()) {
		%>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<div class="alert alert-info mt-4">No hay reparaciones
					pendientes</div>
			</div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<a href="reparaciones?accion=Volver" class="btn btn-primary">Volver</a>
			</div>
		</div>
		<%
			} else {
		%>
		<form action="reparaciones">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Elemento</th>
								<th scope="col">#</th>
								<th scope="col">Descripción</th>
								<th scope="col">Usuario</th>
								<th scope="col">Fecha Solicitud</th>
								<th scope="col">Fecha Reparación</th>
								<th scope="col">Coste</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (Reparacion r : reparaciones) {
							%>
							<tr>
								<th scope="row"><%=r.getElemento()%></th>
								<td><input type="text" size="2" name="repNo" class="form-control"
									value=<%=r.getRep_no()%> readonly></td>
								<td><%=r.getDescripcion()%></td>
								<td><%=r.getUsuario()%></td>
								<td><%=df.format(r.getFechaSolicitud())%></td>
								<td><%=df.format(new Date())%></td>
								<td><input type="text" name="coste" class="form-control"></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				
			</div>
			<div class="row">
					<div class="col-1"></div>
					<div class="col-10">
						<button type="submit" class="btn btn-primary mr-2" name="accion"
							value="Guardar">Guardar Cambios</button>
						<button type="submit" class="btn btn-secondary" name="accion"
							value="Volver">Cancelar</button>
					</div>
				</div>
		</form>

		<%
			}
		%>
		<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
		%>
		<div class="row mt-4 ml-1">
			<div class="col-1"></div>
			<div class="cal-10 alert alert-info"><%=error%></div>
		</div>
		<%
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