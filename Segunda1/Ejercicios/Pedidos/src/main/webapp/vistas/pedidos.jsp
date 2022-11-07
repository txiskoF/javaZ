<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="en">
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

<title>Gestión de Pedidos</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>Pedidos de ${empleado.nombre} ${empleado.apellidos }</h1>
		</div>
		<div class="row">
			<c:forEach items="${empleado.pedidos }" var="p">
				<div class="accordion" id="accordionExample">
					<div class="card">
						<div class="card-header" id="heading${p.id }">
							<h2 class="mb-0">
								<button class="btn btn-link" type="button"
									data-toggle="collapse" data-target="#collapse${p.id }"
									aria-expanded="true" aria-controls="collapse${p.id }">Pedido
									: #${p.id} [ ${p.cliente.empresa } ]</button>
							</h2>
						</div>
						<div id="collapse${p.id }" class="collapse"
							aria-labelledby="heading${p.id }" data-parent="#accordionExample">
							<div class="card-body">
								<h5>Fecha Pedido : <fmt:formatDate value="${p.fechaPedido }"/></h5>
								<h5>Fecha Envío : <fmt:formatDate value="${p.fechaEnvio }"/></h5>
								<table class="table table-striped">
									<thead>
										<tr>
											<th scope="col">Unidades</th>
											<th scope="col">Producto</th>
											<th scope="col">Precio</th>
											<th scope="col">Descuento</th>
											<th scope="col">Importe</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${p.detalles }" var="d">
											<tr>
												<th scope="row">${d.unidades }</th>
												<td>${d.producto.nombre }</td>
												<td><fmt:formatNumber type="currency" value="${d.precio }"></fmt:formatNumber></td>
												<td><fmt:formatNumber type="percent" value="${d.descuento }"></fmt:formatNumber> </td>
												<td><fmt:formatNumber type="currency" value="${d.importe }"></fmt:formatNumber></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<h5>Importe Total : <fmt:formatNumber type="currency" value="${p.importe }"/></h5>
							</div>
						</div>
					</div>
			</c:forEach>
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