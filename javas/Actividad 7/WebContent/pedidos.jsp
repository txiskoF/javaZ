<%@page import="net.zabalburu.actividad7.modelo.DetallePedido"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="net.zabalburu.actividad7.modelo.Pedido"%>
<%@page import="net.zabalburu.actividad7.modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  Cliente c = (Cliente) request.getAttribute("cliente");
	DateFormat df = DateFormat.getDateInstance();
	NumberFormat nf = NumberFormat.getCurrencyInstance();
	NumberFormat nfP = NumberFormat.getPercentInstance();
%>
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

<title>Pedidos de <%= c.getEmpresa() %></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10 text-center">
				<h1>Pedidos de <%= c.getEmpresa() %></h1>
			</div>
		</div>
		<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Fecha Pedido</th>
							<th scope="col">Producto</th>
							<th scope="col">Unidades</th>
							<th scope="col">Precio</th>
							<th scope="col">Descuento</th>
							<th scope="col">Importe</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
						 for (Pedido p : c.getPedidos()){
						%>
							<tr>
								<th scope="row"><%= p.getId() %></th>
								<td><%= df.format(p.getFechaPedido()) %></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td> 
								<td></td>
							</tr>
							<% 
								double total = 0;
								for (DetallePedido dp : p.getDetalles()) {
									double importe = dp.getUnidades() * dp.getPrecio() * dp.getDescuento();
								%>
							<tr>
								<th scope="row"></th>
								<td></td>
								<td><%= dp.getProducto().getNombre() %></td>
								<td><%= dp.getUnidades() %></td>
								<td><%= nf.format(dp.getPrecio()) %></td>
								<td><%= nfP.format(dp.getDescuento()) %></td> 
								<td><%= nf.format(importe) %></td>
							</tr>
						<%  total += importe;
							} 
						%>
						<tr>
								<th scope="row" colspan=6></th>
								<th><%= nf.format(total) %></th>
							</tr>
						<%
						 }%>
					</tbody>
				</table>
				<a href="Clientes">Volver</a>
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