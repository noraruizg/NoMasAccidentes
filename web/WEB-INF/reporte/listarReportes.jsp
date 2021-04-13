<%-- 
    Document   : listarUsuario
    Created on : 13-04-2021, 0:30:52
    Author     : norar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
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
    </head>
    <body>
        <ul>
            
            <li><a href="listarUsuario">Usuarios</a></li>
            <li><a href="listarProfesional"class="active">Profesional</a></li>
            <li><a href="listarCliente">Clientes</a></li>
            <li><a href="listarContrato">Contratos</a></li>
            <li><a href="listarReportes">Reportes</a></li>

            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        <h2>Tipo de Reportes</h2>

        <div class="input-group-prepend center">
						
            <a href="global" class="btn btn-rep">Reporte Global</a>
            <a href="cliente" class="btn btn-rep">Reporte Cliente</a>
            <a href="profesional" class="btn btn-rep">Reporte Profesional</a>
	</div>

    </body>
</html>