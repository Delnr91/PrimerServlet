
<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista  de Usuarios Registrados</h1>

        <%
            List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");

            int cont = 1;
            for (Usuario usu : listaUsuarios) {

        %>
        <p><b>Usuario N° <%=cont%></b></p>
        <p>Id: <%=usu.getId()%></p>
        <p>Dni: <%=usu.getDni()%></p>
        <p>Nombre: <%=usu.getNombre()%></p>
        <p>Apellido: <%=usu.getApellido()%></p>
        <p>Telefono: <%=usu.getTelefono()%></p>
        <p>------------------------------</p>
        <%  cont = cont + 1;%>

        <% }%>
    </body>
</html>
