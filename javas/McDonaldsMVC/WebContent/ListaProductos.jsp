<%@ page import="net.zabalburu.mcdonalds.modelo.Producto" %>
<%@ page import="net.zabalburu.mcdonalds.servicio.Servicio" %>
<%! private Servicio servicio = new Servicio(); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="bootstrap.jsp">
	<jsp:param value="Lista Productos" name="titulo"/>
</jsp:include>

<body>
	<div class='container'>
		<div class='row mt-5'>
			<div class='col-3'></div>
			<h2 class='col-6 text-center'>Seleccione los productos deseados</h2>
		</div>
		<% 
		String error = (String) request.getAttribute("error");
		if (error != null){
		%>
		<div class='row mt-1'>
			<div class='col-3'></div>
			<div class='alert alert-danger col-6'><%= error %></div>
		</div>
		<% 
			} 
		%>
		<div class='row'>
			<div class='col-3'></div>
				<div>
					<form action='Controlador' method='GET'>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">#</th> 
	    		   					<th scope="col">Categoría</th>
	    		     				<th scope="col">Producto</th>
	    		     				<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
							<%
							int contador = 1;
							%>
							<%
	    						for(Producto p : servicio.getProductos()){
   							%>
   							<tr>
   								<th scope="row"> <%= contador %></th>
   								<td> <%= p.getProducto()%></td>
   								<td> <%= p.getCategoria()%></td>
   								<td><input type="checkbox" name="id" value="<%=(contador-1) %>"></td>
   							</tr>
   							<% contador++; %>
	    					<%	
	    						}
	    					%>
							</tbody>
						</table>
						<input type="submit" class="btn btn-primary" name="Enviar" value="Enviar">
					</form>
				</div>
		</div>
	
	</div>
	

</body>
</html>