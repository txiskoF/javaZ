

<%@page import="net.zabalburu.compras.modelo.Carrito"%>
<%@page import="net.zabalburu.compras.servicio.ServicioCompras"%>
<%@page import="net.zabalburu.compras.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="bootstrap.jsp">
	<jsp:param value="Carrito de la compra" name="titulo"/>
</jsp:include>
<%-- DE LA SESION COJO EL USUARIO SERVICIO Y EL CARRITO--%>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	ServicioCompras servicio = (ServicioCompras) session.getAttribute("servicio");
	Carrito carrito = servicio.getCarrito();
%>
<body>
	<div class='container'>
		<div class='row mt-5'>
			<div class='col-2'></div>
			<div class='col-8 text-center'>
					<%-- DEL USUARIO COJO SU APEELIDO Y NOMBRE --%>
				<h2>
					Productos en su carrito (<%= usuario.getApellidos() %>, <%= usuario.getNombre()%>)
				</h2>
			</div>
		</div>
		<div class='row'>
				<%--  DEL CARRITO COJO LOS DETALLES Y SI ESTAN VACIOS--%>
			<%
				if (carrito.getDetalles().isEmpty()){
			%>
			<%-- MUESTRO ERROR DE QUE NO HAY PRODUCTOS--%>
				<div class='col-2'></div>
				<div class='col-8 alert alert-info'>No hay productos en su carrito</div>
			<%
				} else {
			%>	
		
			<div class='col-2'></div>
			<div class='col-8'>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Producto</th>
							<th scope="col">Unidades</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
					<%
						for(Tarea t : tareas){
					%>
						<tr>
							<th scope="col"><%= t.getId() %></th>
							<td><%= t.getDescripcion() %></td>
							<td><%= DateFormat.getDateInstance().format(t.getFecha()) %></td>
							<td><a href='GestorTareas?accion=Borrar&id=<%= t.getId() %>'><span class="material-icons">delete</span></a></td>
						
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
			<% } %>
		</div>
		<!-- Nuevas Tareas -->
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8 text-center"><h3>Nueva Tarea</h3></div>
		</div>
		<div class="row">
			<div class='col-2 text-center'></div>
			<div class='col-8'>
				<form action='GestorTareas'>
					<div class="form-group">
						<label for="descripcion">Descripción</label> 
						<input type="textl" class="form-control" id="descripcion"
							name='descripcion' placeholder='Introduzca la descripcion'>
					</div>
					<div class="form-group">
						<label for="fecha">Fecha</label> 
						<input
							type="date" class="form-control" id="fecha"	name='fecha'
							value='<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>' >
					</div>
					<button type="submit" class="btn btn-primary" name="accion"	value="Añadir">Añadir</button>
				</form>
				<% if (error != null && !error.isEmpty()) { %>
					<div class="alert alert-danger mt-3"><%= error %></div>
				<% } %>
			</div>
				
		</div>
		<div class="row mt-3">
			<div class='col-2'></div>
			<div class='col-8'>
				<a href="GestorTareas" class="btn btn-primary">Volver</a>
			</div>
		</div>
	</div>

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