<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--<jsp:useBean id="error" class="java.lang.String" scope="request"></jsp:useBean> -->
<% String err = (String) request.getAttribute("error"); 
	String usuario = request.getParameter("usuario");
	if (usuario == null){
		usuario = "";
	}
%>
<jsp:include page="bootstrap.jsp">
	<jsp:param value="Login" name="titulo" />
</jsp:include>

<body>
	<div class='container'>
		<div class='row mt-5'>
			<div class='col-3'></div>
			<div class='col-6 text-center'>
				<h2>Introduzca sus datos</h2>
			</div>
		</div>
		<div class='row'>
			<div class='col-3'></div>
			<div class='col-6'>
				<form action='GestorTareas'>
					<div class="form-group">
						<label for="exampleInputEmail1">Usuario</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name='usuario'
							value='<%= usuario %>'
							placeholder='Introduzca su email'>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							name='password' placeholder='Introduzca su contraseña'>
					</div>
					<button type="submit" class="btn btn-primary" name="accion"
						value="Entrar">Entrar</button>
				</form>
				<% if (!error.isEmpty()) { %>
					<div class="alert alert-danger mt-3"><%= error %></div>
				<% } %>
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