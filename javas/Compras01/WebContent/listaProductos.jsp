<%@page import="net.zabalburu.compras.modelo.Carrito"%>
<%@page import="net.zabalburu.compras.servicio.ServicioCompras"%>
<%@page import="java.util.List"%>
<%@page import="net.zabalburu.compras.modelo.Producto"%>
<%@page import="net.zabalburu.compras.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="bootstrap.jsp">
	<jsp:param value="Login" name="titulo" />
</jsp:include>
			<%-- DE LA SESION COJO EL USUARIO, EL SERVICIO, EL CARRITO --%>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	ServicioCompras servicio = (ServicioCompras) session.getAttribute("servicio");
	Carrito carrito = servicio.getCarrito();
%>
<body>
	<div class='container'>
		<div class='row mt-5'>
			<div class='col-1'></div>
			<div class='col-10 text-center'>
				<h2>
					Bienvenido
					<%-- DEL USUARIO COJO EL NOMBRE Y APELLIDOS--%>
					<%=usuario.getApellidos()%>,
					<%=usuario.getNombre()%>  
					<a href="Compras?accion=VerCarrito" class='btn btn-primary'>
					<%-- MYUESTRO ICONO CARRRITO --%>
            			<span class="material-icons">shopping_cart</span> 
            			<%-- DE LOS DETALLES DEL CARRITO COJO EL TAMAÑO PARA MOSTRAR EL NUMERO DE OBJETOS--%>
            			<span class="badge badge-primary"><%= carrito.getDetalles().size() %></span> 
            		</a>
					</h2>
			   <h4>Introduzca las cantidades a comprar de cada producto</h4>
			</div>
		</div>
		<div class='row'>
			<div class='col-1'></div>
			<div class='col-10 text-center'>
			<form action="Compras">
			<%-- MUESTRO EN TARJETAS TODOS LOS PRODUCTOS--%>
				<div class="card-columns">
				<%-- DEL SERVICIO RECORO TODOS LOS PRODUCTOS--%>
				<%
					for (Producto p : servicio.getProductos()) {
				%>
					<div class="card">
						<div class="card-body">
									<%-- OBTENGO PRECIO NOMBRE ID--%>
							<h5 class="card-title"><%= p.getNombre() %></h5>
							<p class="card-text">Precio : <%= p.getPrecio() %></p>
									<%-- COMOO VALUE EL id PERO VA OCULTO --%>
							<p><input type="text" clas="form-control" name="id" value="<%= p.getId() %>" hidden>
							<input type="text" clas="form-control" name="unidades" style="width:50px;"> unids.
							</p>
						</div>
					</div>
				<%
					} 
				%>
				</div>
				<input type="submit" name="accion" value="Comprar" class="btn btn-primary">
				</form>
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