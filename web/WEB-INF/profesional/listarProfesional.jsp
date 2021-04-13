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
            body{
                background-color: #EBFBE8;
            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 80%;
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
        .btn-buscar,
.btn-todos,
.btn-crear {
	
	color: black;
	border: 1px solid #fbfbf8;
}

.btn-sgant {
	background-color: #A1FF6A;
	color: #020747;
}

.btn-editar {
	background: #93937f;
	color: #fbfbf8;
}

.btn-eliminar {
	background: #bf270f;
	color: #fbfbf8;
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
        <h2>Listado de Profesionales</h2>
        <div class="input-group mb-3">
					
		<input type="text" value="" name="buscar" placeholder="Ingrese nombre para buscar" aria-describedby="basic-addon1">
                    
			<button class="btn btn-buscar" type="submit">Buscar Usuario</button>
			<a href="listarProfesional" class="btn btn-todos" >Ver todos</a>
			<a href="agregarProfesional" class="btn btn-crear ">Crear Profesional</a>
            </div>
	</div>
        <table class="table table-sm table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Nombre</th>
                <th>Apellido Paterno</th>
                <th>Apellido Materno</th>
                <th>Cargo</th>
                <th>Pago</th>
                <th>Opciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${profesionales}" var="profesional">
                <tr>
                    <td>${profesional.idProfesional}</td>
                    <td>${profesional.nombre}</td>
                    <td>${profesional.aPaterno}</td>
                    <td>${profesional.aMaterno}</td>
                    <td>${profesional.cargo}</td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix"></div>
	<hr>
	<div class="text-right">
	<a href="?page=1" class="btn btn-sgant" rel="next">Siguiente →</a>

	</div>
    </body>
</html>