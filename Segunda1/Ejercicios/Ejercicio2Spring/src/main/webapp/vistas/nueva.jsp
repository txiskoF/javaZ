<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="es">
    <head>
        <title>Nueva Reunión</title>
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
        		<h1 class="text-align-center">Nueva Reunión</h1>
        	</div>
            
            <div class="row">
            	<div class="col-3"></div>
            	<div class="col-6">
            	<frm:form action="guardar" modelAttribute="reunion" method="POST">
            		<div class="form-group">
                        <label for="nombre">Nombre</label>
                        <frm:input path="nombre" id="nombre" class="form-control"/>
                        <div class="row mt-2 ml-1"><frm:errors path="nombre" cssClass="alert alert-info"></frm:errors></div>
                    </div>
                    <div class="form-group">
                        <label for="fecha">Fecha</label>
                        <frm:input type="date" path="fecha" id="fecha" class="form-control"/>
                        <div class="row mt-2 ml-1"><frm:errors path="fecha" cssClass="alert alert-info"></frm:errors></div>
                    </div>
                    <div class="form-group">
                        <label for="hora">Hora</label>
                        <frm:input path="hora" id="hora" class="form-control"/>
                        <div class="row mt-2 ml-1"><frm:errors path="hora" cssClass="alert alert-info"></frm:errors></div>
                    </div>
                    <div class="form-group">
                        <label for="duracion">Duración</label>
                        <frm:input path="duracion" id="duracion" class="form-control"/>
                        <div class="row mt-2 ml-1"><frm:errors path="duracion" cssClass="alert alert-info"></frm:errors></div>
                    </div>
                    
                    <div class="form-group">
                        <label for="lugar">Lugar</label>
                        <frm:input path="lugar" id="fecha" class="form-control"/>
                        <div class="row mt-2 ml-1"><frm:errors path="lugar" cssClass="alert alert-info"></frm:errors></div>
                    </div>
                    <div class="form-group">
                        <label for="observaciones">Observaciones</label>
                        <frm:textarea path="observaciones" id="observaciones" class="form-control"/>
                    </div>
                    <input type=submit value="Guardar" class="btn btn-primary">
                    <a href="Cancelar" class="btn btn-secondary">Cancelar</a>
                </frm:form>
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