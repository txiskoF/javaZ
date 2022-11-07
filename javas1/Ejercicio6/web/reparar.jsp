<%-- 
    Document   : login
    Created on : 10-oct-2019, 13:15:43
    Author     : ichueca
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="net.zabalburu.ejercicio6.Reparacion"%>
<%@page import="java.util.List"%>
<%@page import="net.zabalburu.ejercicio6.service.Servicio"%>
<jsp:useBean id="usuario" class="net.zabalburu.ejercicio6.Usuario" 
             scope="session"></jsp:useBean>
<%!
    private Servicio servicio = new Servicio();
    private DateFormat df = DateFormat.getDateInstance();
    private NumberFormat nf = NumberFormat.getCurrencyInstance();
%>
<%
    String accion = request.getParameter("accion");
    if (accion != null){
        if (accion.equals("Cancelar")){
            %>
            <jsp:forward page="opciones.jsp"/>
            <%
        } else {
            String[] strRepno = request.getParameterValues("repno");
            String[] strCostes = request.getParameterValues("coste");
            for(int i=0; i<strCostes.length; i++){
                if (!strCostes[i].isEmpty()){
                    double coste = Double.parseDouble(strCostes[i]);
                    int repNo = Integer.parseInt(strRepno[i]);
                    servicio.reparar(repNo, usuario.getNombre(), coste);
                }
            }
            %>
            <jsp:forward page="opciones.jsp">
                <jsp:param name="info" value="Cambios guardados"/>
            </jsp:forward>
            <%
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

        <title>Reparar</title>
    </head>
    <body>
        <div class="container">
            <div class="row mt-5">
                <div class="col-1"></div>
                <div class="col-10">
                    <h2>Por favor, <%= usuario.getNombre()%>, complete la información de las reparaciones realizadas</h2>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-1"></div>
                <div class="col-10">
                    <%
                        List<Reparacion> reparaciones = servicio.getReparacionesPendientes();
                        if (reparaciones.isEmpty()) {
                    %>
                    <div class="alert alert-info">No hay reparaciones pendientes</div>
                    <%
                    } else {

                    %>
                    <form action="reparar.jsp">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Elemento</th>
                                    <th scope="col">Id</th>
                                    <th scope="col">Descripción</th>
                                    <th scope="col">Fecha Solicitud</th>
                                    <th scope="col">Fecha Reparación</th>
                                    <th scope="col">Coste</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                                for (Reparacion r : reparaciones) {
                                %>
                                <tr>
                                    <th scope="row"><%= r.getElemento()%></th>
                                    <td><input name="repno" class="form-control" type="text" readonly value="<%= r.getRepNo()%>"></td>
                                    <td><%= r.getDescripcion()%></td>
                                    <td><%= df.format(r.getFechaSolicitud())%></td>
                                    <td><%= df.format(new java.util.Date())%></td>
                                    <td><input type="text" class="form-control" name="coste"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <%
                                        }
                                    %>
                                </tr>

                            </tbody>
                        </table>
                        <input type="submit" class="btn btn-primary" name="accion" value="Guardar Cambios">
                        <input type="submit" class="btn btn-secondary" name="accion" value="Cancelar">
                    </form>
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
