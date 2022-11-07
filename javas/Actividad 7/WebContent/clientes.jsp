<%@page import="net.zabalburu.actividad7.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%! final static int NUM_CLIEN = 10; %>
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

<title>Clientes de Northwind</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10 text-center">
				<h1>Clientes de Northwind</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Empresa</th>
							<th scope="col">Dirección</th>
							<th scope="col">Localidad</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
						int totPaginas = clientes.size() / NUM_CLIEN + ((clientes.size()%NUM_CLIEN!=0)?1:0);
						int pag = (int) request.getAttribute("pagina");
						for (int i=(pag-1)*NUM_CLIEN; i<clientes.size() &&
								i<pag*NUM_CLIEN;i++) {
						%>
						<tr>
							<th scope="row"><%=clientes.get(i).getId()%></th>
							<td><%=clientes.get(i).getEmpresa()%></td>
							<td><%=clientes.get(i).getDireccion()%></td>
							<td><%=clientes.get(i).getLocalidad()%></td>
							<td><a href="Clientes?accion=VerPedidos&id=<%=clientes.get(i).getId()%>">Ver
									Pedidos</a></td>
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
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<% if (pag != 1) { %>
						<li class="page-item"><a class="page-link" href="Clientes?accion=IrA&pag=<%=pag-1%>">Anterior</a></li>
						<% } %>
						<% for(int i=0;i<totPaginas;i++){ %>
							<li class="page-item <%= (pag==i+1)?"active":""%>"><a class="page-link" href="Clientes?accion=IrA&pag=<%=i+1%>"><%= i+1 %></a></li>
						<% } %>
						<% if (pag < totPaginas) { %>
						<li class="page-item"><a class="page-link" href="Clientes?accion=IrA&pag=<%=pag+1%>">Siguiente</a></li>
						<% } %>
					</ul>
				</nav>
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