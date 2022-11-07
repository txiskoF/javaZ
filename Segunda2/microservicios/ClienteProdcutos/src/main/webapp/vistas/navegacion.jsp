<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Zabal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Productos <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/ofertas">Ofertas</a>
      </li>
      <c:if test="${!empty usuario }">
      	<a class="nav-link" href="/nuevoProducto">Nuevo Producto</a>
      </c:if>
      </ul>
      <c:if test="${empty usuario }">
      	<a class="btn btn-primary ml-auto" href="/login">Login</a>
      </c:if>
      <c:if test="${!empty usuario }">
      <div>
      	<a href="/usuario" style="color:white;">${usuario.nombreCompleto }</a><br/>
      	<a href="/salir" style="color:white;">Salir</a>
      	</div>
      </c:if>
  </div>
</nav>