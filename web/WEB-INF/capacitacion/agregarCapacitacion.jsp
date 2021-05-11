<%-- 
    Document   : agregarCapacitacion
    Created on : 08-05-2021, 19:28:15
    Author     : norar
--%>

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
            <li><a href="listarCliente">Clientes</a></li>
            <li><a href="listarContrato" class="active">Contratos</a></li>
            <li><a href="listarReportes">Reportes</a></li>

            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        <h3>Planificar Capacitación</h3>

        <div>
            <form action="agregarCapacitacion" method="POST">
                <label>Fecha de Capacitacion</label>
                <input type="date" name="fCapacitacion" required>
                
                <label>Fecha de Vencimiento</label>
                <input type="date" name="fVencimiento" required>
                <br><br>
                <label>Descripcion Capacitacion</label>
                <input type="text" name="descripcion" required>
                <label>Cantidad Asistentes</label>
                <input type="number" name="cantAsistentes" required>
                <label>Material</label>
                <select name="idMaterial">
                    <option value="0">Sin Asignar</option>
                </select>
                <br><br>
                
                <input type="submit" value="Agregar Capacitacion">
            </form>
            <h3>${mensaje}</h3>
            <c:forEach items="${mensajes}" var="mensaje">
                <h3>${mensaje}</h3>
            </c:forEach>
        </div>
    </body>
</html>
