<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--  AÑADIR CORE -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>Gestión de Compras</title>
</head>
<body>
<!-- Insertar una navbar  -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<!-- Enlace con el nombre del ususario  -->
  <a class="navbar-brand" href="/">${usuario }</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <!--  enlace para ir a la Home -->
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <!-- Enlace para ir a  MisCompras-->
      <li class="nav-item">
      <!-- enlace par air a ver mis compras  -->
        <a class="nav-link" href="/miscompras">Mis Compras</a>
      </li>
      
    </ul>
    <!--  Form para buscar libros -->
    <form class="form-inline my-2 my-lg-0" action="buscarLibros">
    <!-- Caja de busqueda e isnertar  -->
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="busqueda">
      <!-- Boton para ir a buscarLibros se va al metodo buscar libros -->
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar Libros</button>
    </form>
  </div>
</nav>
	<!-- Crear una tabla  -->

	<div class="container m-4">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6 text-center">
				<h1>Gestión de Compras</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Editorial</th>
							<th scope="col">Ciudad</th>
							<th scope="col">País</th>
						</tr>
					</thead>
					<tbody>
					<!-- con el foreach en e guardo las editoriales  -->
					<c:forEach var="e" items="${editoriales }">
						<tr>
						<!--  Para drle realce al id  -->
							<th scope="row">${e.id }</th>
							<!-- Convertir el nombre en enlace para ir a la editorial  -->
									<!-- este nombre es el de GEstionCompras del Controlador -->
												<!-- e.nombre es el nombre de la editorial -->
							<td><a href="buscarEditorial?id=${e.id}">${e.nombre }</a></td>
							<td>${e.ciudad } - ${e.estado }</td>
							<td>${e.pais }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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