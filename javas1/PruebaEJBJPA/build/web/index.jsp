<%-- 
    Document   : index
    Created on : 06-nov-2019, 8:13:57
    Author     : ichueca
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <div class="container m-5">
            <h1>Gestíón de Proveedores</h1>
            <form action="Controlador">
                <div class="form-group">
                    <label for="proveedor">Seleccione el proveedor</label>
                    <select name="proveedor" class="custom-select">
                        <c:forEach items="${proveedores}" var="p">
                            <option value="${p.supplierID}" ${(p.supplierID == param.proveedor)?"SELECTED":""} >${p.companyName}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" class="btn btn-primary" name="accion" value="Ver Productos">
            </form>
            <hr>
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Categoría</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Unidades en Stock</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${proveedor.productList}" var="p">
                        <tr>
                            <th scope="row">${p.productID}</th>
                            <td>${p.productName}</td>
                            <td>${p.categoryID.categoryName}</td>
                            <td><fmt:formatNumber type="currency" value="${p.unitPrice}"/></td>
                            <td>${p.unitsInStock}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
