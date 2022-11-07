<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@page import="net.zabalburu.ejercicio6.Usuario"%>
<%@page import="net.zabalburu.ejercicio6.service.Servicio"%>
<%! 
    //DECLARO LA CAPA DE SERVICIO PAR ACCEDER A EL
    private Servicio servicio = new Servicio();
%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
// 1º DIRECTIVA PARA CREAR UN USUARIO
<jsp:useBean id="usuario" class="net.zabalburu.ejercicio6.Usuario" scope="session"></jsp:useBean>
// 2º CARGO LOS DATOS DEL USEBEAN A PARTIR DE LAS PROPIEDADES CON TODAS
<jsp:setProperty name="usuario" property="*"/>
//COMPRUEBO SI HAY USUARIO
<%
    String accion = request.getParameter("accion");
    // GUARDAR EN UNA LISTA LOS ERRORES QUE HAYA
    List<String> errores = new ArrayList();
    // SI HAY ACCION HAY USUARIO
    if (accion != null){
        //SI EL NOMBRE ESTA VACIO
        if (request.getParameter("nombre").isEmpty()){
            //AÑADO EL ERROR A LA LISTA DE ERRORES
            errores.add("El nombre no puede estar vacío");
        }
        //SI LA CONSTRSEÑA ESTA VACIA
        if (request.getParameter("password").isEmpty()){
            //AÑADO A LA LSITA DE ERRORES
            errores.add("Debe especificarse la contraseña");
        }
        //SI LA LISTA DE ERRORES ESTA VACIA
        if (errores.isEmpty()){
            //ACCEDO AL  SERVICIO
                                //ESTE METODO PASANDO NOMBRE Y CNTRSEÑA COMPRUEBAN SI ES CORRECTO
            Usuario u = servicio.validar(usuario.getNombre(), usuario.getPassword());
            //SI NO SE OBTIENEN LOS DATOS ES QUE ES ERORES
            if (u == null){
                errores.add("Usuario/contraseña erróneos");
            } else {
                //EL USUSARIO ES VALIDO Y SE PONE EL ROL DEL USUARIO
                usuario.setRol(u.getRol());
                //SE VA A LA PAGINA OPCIONES
                %>
                <jsp:forward page="opciones.jsp"/>
                <%
            }
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <div class="col-3"></div>
                <div class="col-6">
                    <h2>Por favor, identifíquese para acceder a la aplicación</h2>
                    
                </div>
            </div>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6">
                    //VENDRA A ESTA MISMA PAGINA AL DAR A ENTRAR ESE SERA EL ACTION
                    <form action="login.jsp">
                        <div class="form-group">
                            <label for="nombre">Usuario</label>
                            <input type="text" class="form-control" id="nombre" 
                                   name ="nombre"
                                   aria-describedby="emailHelp" placeholder="Nombre de usuario"
                                  <!-- Esto es para que mantenga el nombre de usuario introducido
                                  y si se cambia , tambien lo cambie-->
                                   value="<%= (request.getParameter("nombre")==null)?"":request.getParameter("nombre") %>">
                            
                        </div>
                        <div class="form-group">
                            <label for="password">Contraseña</label>
                            <input type="password" class="form-control" id="password" 
                                   name="password"
                                   placeholder="Password">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Entrar" name="accion">
                    </form>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col-3"></div>
                <div class="col-6">
                    
                    //RECORRO LA LISTA DE ERRORES CREADA
                    <% for(String error : errores) {
                    %>
                    <div class="alert alert-danger"><%= error %></div>
                    <%
                        }
                    %>
                </div>
            </div>
            
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
