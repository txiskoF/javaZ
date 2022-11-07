<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>Discos</title>
  </head>
  <body>
  	<div class="container m-5">
  	<!--  -->
  						 	<!-- ENCABEZADO -->
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    <%-- mostrar nombre de usuario lo cojo de cliente--%>
                    <h2>Pedidos: ${cliente.apellido}, ${cliente.nombre}</h2>
                </div>
            </div>
            
            
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                
                			<!-- SI NO TIENE PEDIDOS -->
                    <c:if test="${empty pedidos}">
                        <div class="alert alert-info">No tiene pedidos</div>
                    </c:if>
                    
                       <%-- SI TIENE PEDIDOS LOS MUESTRO --%>
                    <c:if test="${!empty pedidos}">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Album</th>
                                    <th scope="col">Artista</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%-- guardo cada pedido en la variable p --%>
                                <c:forEach items="${pedidos}" var="p">
                                    <tr>
                                        <th scope="row">${p.id}</th>
                                        <td>${p.album.titulo}</td>
                                        <td>${p.album.artista.nombre}</td>
										<td><fmt:formatDate value="${p.fechaPedido }"/> </td>
										<td><a href="Controlador?idPedido=${p.id}&accion=Eliminar" class="btn btn-outline-danger">Eliminar</a></td>
                                    </tr>
                                </c:forEach>
                       		</tbody>
                        </table>
                    </c:if>
                    
                    
                    <%-- MOSTRAR LA LISTA DE ALBUMES --%>  
		            <form action="Controlador">
		                <div class="row">
		                    <div class="col-3"></div>
		                    <h3>Seleccione un Album</h3>
		                </div>
		                <div class="row">
		                    <div class="col-3"></div>
		                    <div class="col-6">
		                        <div class="input-group mb-3">
		                            <select class="select custom-select" name="id">
										<c:forEach var="a" items="${albumes}">
											<option value="${a.id}">${a.titulo}, ${a.artista.nombre} </option>
										</c:forEach>
									</select>
		                            <div class="input-group-append">
		                                <button type="submit" class="btn btn-primary" name="accion"
		                                        value="Pedir">Pedir</button>
		                            </div>
		                            <div class="input-group-append">
		                                <button type="submit" class="btn btn-primary" name="accion"
		                                        value="Salir">Salir</button>
		                            </div>   
		                        </div>
		                    </div>
		                </div>
		            </form>  
             	</div> 
             </div>  
  	</div>
    

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js" integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js" integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG" crossorigin="anonymous"></script>
    -->
  </body>
</html>