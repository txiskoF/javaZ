<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

<title>Chinook</title>
</head>
<body>
	<div class="container mt-3">
		<jsp:include page="cabecera.jsp"></jsp:include>
		<c:if test="${! empty mensaje }">
			<div class="row">
				<div class="alert alert-info">${mensaje }</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-12 text-center">
				<h1>Selección de Artistas</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<c:forEach var="inicial" items="${iniciales }">
					<a href="Chinook?accion=VerArtistas&inicial=${inicial }"
						style="font-size: 40px"> ${inicial }&nbsp;</a>
				</c:forEach>
			</div>
		</div>
		<div class="row">
			<h1>${inicial }</h1>
		</div>

		<div class="row">
			<ul>
				<c:forEach begin="${(pagina-1)*5 }" end="${pagina*5 -1 }"
					items="${artistas }" var="artista">
					<li><a href="Chinook?accion=VerArtista&id=${artista.id}">${artista.nombre }</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="row">
			<nav>
				<ul class="pagination">
					<li class="page-item  ${pagina==1?"disabled":"" }"><a class="page-link" href="Chinook?accion=irApag&pagina=${pagina-1 }&inicial=${inicial}">Anterior</a></li>
					<c:forEach begin="1" end="${totPag }" varStatus="status">
						<li class='page-item ${(pagina == status.count)?"active":""}' aria-current="page">
						<a	class="page-link" href="Chinook?accion=irApag&pagina=${status.count }&inicial=${inicial}">${status.count } <span class="sr-only">(current)</span></a>
						</li>
					</c:forEach>
					<li class="page-item ${pagina==totPag?"disabled":"" }""><a class="page-link" href="Chinook?accion=irApag&pagina=${pagina+1 }&inicial=${inicial}">Siguiente</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Optional JavaScript; choose one of the two! -->

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