<%-- 
    Document   : checklistAsesoria
    Created on : 25-05-2021, 14:03:47
    Author     : norar
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="ConexionconBD.ConexionBD"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <%
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sebafzen", "duoc");
            Statement st = con.createStatement();
            HttpSession sesion = request.getSession();
        %>
        
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
            <li><a href="listarContrato">Contratos</a></li>
            <li><a href="listarCapacitacion">Capacitaciones</a></li>
            <li><a href="listarAsesoria"class="active">Asesorias</a></li>
            <li><a href="">Checklist</a></li>
            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        
        <h3>Checklist Asesoria</h3>
        <div>
            <form action="checklistAsesoria" method="POST">
                <input type="hidden" name="idAsesoria" value="<%=request.getParameter("idAsesoriaSeleccionada")%>">
                
                <label>Fecha Checklist Asesoria</label>
                <input type="date" name="fechaChecklistAsesoria" required>
                <br><br>
                
                <label>Causante Asesoria</label>
                <input type="text" name="causanteAsesoria" required>
                <br><br>
                
                <label>Mejoras</label>
                <input type="text" name="mejoraCheckListAsesoria" required>
                <br><br>
                
                <label>Fecha Modificacion</label>
                <input type="date" readonly="true" name="fechaModificacion" required>
                <br><br>
                
              <input type="submit" value="Ingresar Checklist">
            </form>
            <h3>${mensaje}</h3>
            <c:forEach items="${mensajes}" var="mensaje">
                <h3>${mensaje}</h3>
            </c:forEach>
        </div>
    </body>
</html>
