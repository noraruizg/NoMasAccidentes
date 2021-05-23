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
            <li><a href="listarContrato"class="active">Contratos</a></li>
            <li><a href="listarCapacitacion">Capacitaciones</a></li>
            <li><a href="listarAsesoria">Asesorias</a></li>
            <li><a href="">Checklist</a></li>
            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        <h2>Listado de Contratos</h2>
        <div class="input-group mb-3">				
            <a href="agregarContrato" class="btn btn-crear ">Crear Contrato</a>
        </div>
        <table class="table table-sm table-striped">
            <thead>
            <tr>
                <th>Fecha Inicio</th>
                <th>Fecha Vencimiento</th>
                <th>Cliente</th>
                <th>Opciones</th>
            </tr>
            </thead>
            <tbody>
                <%  
                    String idProfes = sesion.getAttribute("idProfesional").toString();
                    String queryContratos = "SELECT co.FECHAINICIO, co.FECHATERMINO, NOMBRE FROM CONTRATO co INNER JOIN CLIENTE cli ON co.cliente_id_cliente = cli.id_cliente INNER JOIN PROFESIONAL pro ON co.profesional_id_profesional = pro.id_profesional WHERE pro.id_profesional = " + idProfes;
                    ResultSet rsContrato = st.executeQuery(queryContratos);                
                    while(rsContrato.next()){
                    java.sql.Date fechaIni = rsContrato.getDate("FECHAINICIO");
                    java.sql.Date fechaTer = rsContrato.getDate("FECHATERMINO");
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String fechaIn = dateFormat.format(fechaIni);
                    String fechaTe = dateFormat.format(fechaTer);
                %>
                <tr>
                    <td><%= fechaIn%></td>
                    <td><%= fechaTe%></td>
                    <td><%= rsContrato.getString("NOMBRE")%></td>
                    <td></td>
                </tr>
                <%
                    } 
                %>
            </tbody>
        </table>
    </body>
</html>