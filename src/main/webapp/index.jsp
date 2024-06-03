<%-- 
    Document   : index
    Created on : May 28, 2024, 3:23:28 PM
    Author     : invde
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta http-equiv="X-UA-Compatible" content="IE=edge">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del Usuario</h1>
        <form action="SvUsuarios" method="POST">
            <p><label>Dni:</label><input type="text" name = "dni"></p>
            <p><label>Nombre:</label><input type="text" name = "nombre"></p>
            <p><label>Apellido:</label><input type="text" name = "apellido"></p>
            <p><label>Telefono:</label><input type="text" name = "telefono"></p>
            <button type="submit" >Enviar</button>
        </form>

        <h1>Ver lista de Usuario</h1>
        <p>Para ver los datos de los usuarios cargados, hacer click en el siguiente botón</p>
        <form action="SvUsuarios" method="GET" >
            <button type="submit"> Mostrar Usuarios </button>
        </form>

        <h1>Eliminar Usuario</h1>
        <p>Ingrese la Id del usuario para eliminar</p>
        <form action="SvEliminar" method="POST">
            <p><label>Id:</label><input type="text" name = "id_usuario"></p>
            <button type="submit"> Eliminar Usuarios </button>
        </form>

        <h1>Editar Usuario</h1>
        <p>Ingrese la Id del usuario para editar</p>
        <form action="SvEditar" method="GET">
            <p><label>Id:</label><input type="text" name = "id_usuarioEdit"></p>
            <button type="submit"> Editar usuarios </button>
        </form>
    </body>
</html>
