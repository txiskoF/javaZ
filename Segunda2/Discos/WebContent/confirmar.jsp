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
                    <h2>${cliente.apellido}, ${cliente.nombre}</h2>
                    <h5>Confirme su pedido</h5>
                </div>
            </div>
            
            
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                
                			<!-- COMIENZA FORMULARIO -->
                    <form action="Controlador">
                        <div class="form-group">
                            <label for="disco">Album</label>
                            
                            			<!-- POR LA REQUEST ME LLEGA EL ALBUM SELECCIONADO   MUESTRO EL NOMBRE -->
                            <input type="text" class="form-control" id="nombre" name="disco" value="${album.titulo}">
                            		
                            		<!-- GUARDO EN UN CAMPO OCULTO EL ID DEL ALBUM -->
                            <input type="hidden" name="idAlbum" value="${album.id}">
                        </div>
                        <div class="form-group">
                            <label for="artista">Artista</label>
                            					<!-- DEL ALBUM COMPLETO OBTENGO UN ARTISTA COMPLETO Y DE AHI SU NOMBRE -->
                            <input type="text" class="form-control" id="nombreArtista" name="artista" value="${album.artista.nombre}">
                        </div>
                        
                       		<!-- ESTO PARA LA FECHA -->
						<div class="form-group">
							<label for="exampleInputPassword1">Fecha</label> 
							
										<!-- HAGO QUE EL VALUE TOME LA FECHA DE HOY POR DEFECTO -->
							<input
								type="date" name="fecha" class="form-control" id="exampleInputPassword1" value="${hoy }">
						</div>
			
                       
                       
                       
                        <button type="submit" name="accion" value="Comprar" class="btn btn-primary">Comprar</button>
                        <button type="submit" name="accion" value="Cancelar" class="btn btn-primary">Cancelar</button>
                    </form>
                </div>
            </div>

            <c:if test="${! empty errores}">
                <c:forEach var="error" items="${errores}">
                    <div class="row">
                        <div class="col-3"></div>
                        <div class="alert alert-danger m-3">${error}</div>
                    </div>
                </c:forEach>
            </c:if>
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