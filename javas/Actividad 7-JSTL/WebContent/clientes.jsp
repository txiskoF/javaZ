<%@page import="net.zabalburu.actividad7.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					
								<!-- PRA MOSTRAR PAGINAS DE 10 EN 10 -->
								<!-- CALCULAR EL TOTAL DE PAGINAS -->
						<c:set var="totPaginas" value="${clientes.size() / 10 }"></c:set>
						<c:forEach var="c" items="${clientes}" 
							begin="${(pagina-1)*10 }"
							end="${pagina *10}">
						<tr>
							<th scope="row">${c.id}</th>
							<td>${c.empresa }</td>
							<td>${c.direccion }</td>
							<td>${c.localidad }</td>
							<td><a href="Clientes?accion=VerPedidos&id=${c.id }">Ver Pedidos</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
			
					<!-- PARA MOSTAR LA PAGINACION -->
				<nav aria-label="Page navigation example">
					<ul class="pagination">
					<c:if test="${pagina != 1 }">
						<li class="page-item"><a class="page-link" href="Clientes?accion=IrA&pag=${pagina -1 }">Anterior</a></li>
					</c:if>
						<c:forEach begin="1" end="${totPaginas+1 }" varStatus="estado">
							<li class="page-item ${estado.count == pagina?"active":""}">
								<a	class="page-link"	href="Clientes?accion=IrA&pag=${estado.count }">${estado.count }</a>
							</li>
						</c:forEach>
						<c:if test="${pagina < totPaginas }">
							<li class="page-item"><a class="page-link" href="Clientes?accion=IrA&pag=${pagina+1 }">Siguiente</a></li>
						</c:if>
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