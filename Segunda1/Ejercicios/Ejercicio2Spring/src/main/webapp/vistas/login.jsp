<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="es">

    <head>
        <title>Gestión de Reuniones</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport"           content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
            integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    </head>
    <body>
        <div class="container ">
        	<div class="row">
        		<div class="col-3"></div>
        		<h1 class="text-align-center">Es necesaria autenticación</h1>
        	</div>
            
            <div class="row">
            	<div class="col-3"></div>
            	<div class="col-6">
            	<form action="login" method="POST">
                    <div class="form-group">
                        <label for="username">Nombre usuario</label>
                        <br>
                        <select class="col-12 select custom-select" name="apellido">
                        	<c:forEach var="e" items="${empleados }">
                        		<option value="${e.apellidos }">${e.apellidos }, ${e.nombre }</option>
                        	</c:forEach>
                        </select>
                        
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="id"
                            placeholder="Contraseña">
                    </div>
                    <input type=submit value="Entrar" class="btn btn-primary">
                </form>
                </div>
            </div>	
                <c:if test="${!empty error}">
					<div class="mt-3 alert alert-danger">${error }</div>
				</c:if>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>
    </body>
</html>