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
List<Reparacion> reparaciones = (List<Reparacion>) request.getAttribute("reparaciones");
DateFormat df = DateFormat.getDateInstance();
NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<title>Reparaciones de <%=usuario.getUsuario()%></title>
</head>
<body>
	<div class="container">
		<div class="row mt-5">
			<div class="col-1"></div>
			<div class="col-10 text-center">
				<h3>
					Estado de las Reparaciones de
					<%=usuario.getUsuario()%></h3>
			</div>
		</div>
		<%
			if (reparaciones.isEmpty()) {
		%>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<div class="alert alert-info mt-4">No hay reparaciones</div>
			</div>
		</div>
		<%
			} else {
		%>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Elemento</th>
							<th scope="col">#</th>
							<th scope="col">Descripción</th>
							<th scope="col">Fecha Solicitud</th>
							<th scope="col">Fecha Reparación</th>
							<th scope="col">Reaparador</th>
							<th scope="col">Coste</th>
						</tr>
					</thead>
					<tbody>
						<%
							double total = 0;
						for (Reparacion r : reparaciones) {
							if (r.getCoste()!=null){
								total += r.getCoste();
							}
						%>
						<tr>
							<th scope="row"><%=r.getElemento()%></th>
							<td><%=r.getRep_no()%></td>
							<td><%=r.getDescripcion()%></td>
							<td><%=df.format(r.getFechaSolicitud())%></td>
							<% if (r.getFechaReparacion() != null) { %>
								<td><%=df.format(r.getFechaReparacion())%></td>
								<td><%=r.getReparador()%></td>
								<td><%=nf.format(r.getCoste())%></td>
							<% } else {%>
								<td></td>
								<td></td>
								<td></td>
							<% } %>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
			

		</div>
		<%
				if (total != 0) {
			%>
			<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
					<h4>
						Total : <%=nf.format(total)%></h4>
				</div>
			</div>
			<%
				}
			%>
		<%
			}
		%>
		<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
				<a href="reparaciones?accion=Volver" class="btn btn-primary">Volver</a>
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