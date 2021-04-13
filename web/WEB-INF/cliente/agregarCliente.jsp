<%-- 
    Document   : formulario
    Created on : 03-04-2021, 19:04:15
    Author     : norar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <style>
        body{
                background-color: #EBFBE8;
            }
         input[type=text],input[type=password],input[type=number],input[type=email], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }
    </style>
    <body>
        <ul>
            <li><a href="listarUsuario">Usuarios</a></li>
            <li><a href="listarProfesional">Profesional</a></li>
            <li><a href="listarCliente" class="active">Clientes</a></li>
            <li><a href="listarContrato">Contratos</a></li>
            <li><a href="listarReportes">Reportes</a></li>

            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        <h3>Agregar Cliente</h3>

        <div>
            <form action="agregarCliente" method="POST">
                <label>Nombre</label>
                <input type="text" name="nombre" placeholder="Nombre de cliente/empresa" required>

                <label >Rubro</label>
                <input type="text" name="rubro" required>

                <label>Email</label>
                <input type="email" name="email" required>

                <label>Descripcion</label><br>
                <textarea rows="10" cols=80% name="descripcion"></textarea>
                <br>
                <label>Usuario</label>
                <select name="idUsuario">
                    <option value="sinAsignar">Sin Asignar</option>
                </select>

                <input type="submit" value="Crear Cliente">
            </form>
            <h3>${mensaje}</h3>
            <c:forEach items="${mensajes}" var="mensaje">
                <h3>${mensaje}</h3>
            </c:forEach>
        </div>

    </body>
</html>