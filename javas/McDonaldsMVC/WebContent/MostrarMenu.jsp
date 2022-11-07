<%@ page import="net.zabalburu.mcdonalds.modelo.Producto" %>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="bootstrap.jsp">
	<jsp:param value="Mostrar Menu" name="titulo"/>
</jsp:include>
<% List<Producto> productos = (List<Producto>)request.getAttribute("productos");%>
<%!
	private NumberFormat nf = NumberFormat.getInstance();
	private NumberFormat nfPorc = NumberFormat.getPercentInstance();
%>
<body>
	<div class='container'>
		<div class='row mt-5'>
			<div class='col-3'>
				<h2 class='col-6 text-center'>Seleccione los productos deseados</h2>
			</div>
			<div class='row'>
				<div class='col-1'></div>
				<div>
					<table class="table">
						<thead>
							 <tr>
							 	<th scope="col">Producto</th>
							 	<th scope="col">Categoría</th>
							 	<th scope="col">Calorías</th>
							 	<th scope="col">Colesterol</th>
							 	<th scope="col">Grasa Saturada</th>
							 	<th scope="col">Eliminar</th>
							 </tr>
						</thead>
						<tbody>
						
						<% 
							double totalCalorias = 0;
							double totalColesterol = 0;
							double porcColesterol = 0;
							double totalGrasas = 0;
							double porcGrasas = 0;
						%>
						<%
	    					for(Producto p : productos){
						%>
   						<tr>
   							<th scope="row"><%= p.getProducto() %></th>
   							<td> <%= p.getCategoria()%></td>
   							<td> <%= nf.format(p.getCalorias()) %></td>
   							<td> <%= p.getColesterol()%></td>
   							<td> <%= p.getGrasaSaturada()%></td>
   							<td> <a href='Controlador?accion=Borrar&id=<%= p.getProducto(). %>'><span class="material-icons">delete</span></a>
</td>
   						</tr>
   						<% 
	   						totalCalorias += p.getCalorias();
	   						totalColesterol += p.getColesterol();
	   						totalGrasas += p.getGrasaSaturada();
	   						porcColesterol += p.getPorcDiaColesterol();
	   						porcGrasas += p.getPorcDiaGrasaSaturada();
   						%>
   						<%	
	    					}
	    				%>
   						<tr>
   							<th scope="row">Totales</th>
   							<th><%=nf.format(totalCalorias)%></th>
			    		    <th><%=nf.format(totalColesterol) + nfPorc.format(porcColesterol/100) %>
			    		    CDR )</th> 
			    		    <th><%=nf.format(totalGrasas) + nfPorc.format(porcGrasas/100) %> CDR )</th>
   						</tr>
						</tbody>
					</table>
					<a href='Controlador' class='btn btn-primary'>Volver</a>
				</div>
			
			</div>
		</div>
	</div>

</body>
</html>