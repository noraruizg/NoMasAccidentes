<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        Class.forName("oracle.jdbc.OracleDriver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sebafzen", "duoc");
        Statement st = con.createStatement();
        HttpSession sesion = request.getSession();
    %>
    
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
            <li><a href="crearAccidente">Reportar Accidentes</a></li>
            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        
        <div class="input-group mb-3">
            <h1>Bienvenido <%=sesion.getAttribute("idCliente")%></h1>
            <br>
            
            <h3>Contrato</h3>
            <table class="table table-sm table-striped">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Fecha de Inicio</th>
                        <th>Fecha de Termino</th>
                        <th>Estado del Contrato</th>
                        <th>Profesional a Cargo</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%  
                        String idCliente = sesion.getAttribute("idCliente").toString();
                        String queryContratoCliente = "SELECT co.ID_CONTRATO, co.FECHAINICIO, co.FECHATERMINO, co.ESTADO, pro.NOMBREPROFESIONAL FROM CONTRATO co INNER JOIN PROFESIONAL pro ON co.profesional_rut_profesional = pro.rut_profesional INNER JOIN CLIENTE cli ON co.cliente_rut_cliente = cli.rut_cliente WHERE cli.rut_cliente = '"+idCliente+"'";
                        ResultSet rsContratoCliente = st.executeQuery(queryContratoCliente);                
                        while(rsContratoCliente.next()){
                        java.sql.Date fechaInCont = rsContratoCliente.getDate("FECHAINICIO");
                        java.sql.Date fechaTeCont = rsContratoCliente.getDate("FECHATERMINO");
                        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String fechaConCliIn = dateFormat.format(fechaInCont);
                        String fechaConCliTe = dateFormat.format(fechaTeCont);
                    %>
                    <tr>
                        <td><%=rsContratoCliente.getInt("ID_CONTRATO")%></td>
                        <td><%=fechaConCliIn%></td>
                        <td><%=fechaConCliTe%></td>
                        <td><%=rsContratoCliente.getString("ESTADO")%></td>
                        <td><%=rsContratoCliente.getString("NOMBREPROFESIONAL")%></td>
                        <td>
                            <a href="">Ver Contrato</a>
                        </td>
                    </tr>
                    <%
                        } 
                    %>
                </tbody>
            </table>
        <br>
        
        <h3>Servicios Extra</h3>
            <table class="table table-sm table-striped">
                <thead>
                    <tr>
                        <th>Codigo</th>
                        <th>Descripción</th>
                        <th>Fecha Solicitud</th>
                        <th>Costo del Servicio</th>
                    </tr>
                </thead>
                <tbody>
                    <%  
                        String queryServicioExtraCliente = "SELECT se.ID_EXTRA, se.DESCRIPCIONEXTRA, se.FECHAEXTRA, se.COSTOEXTRA FROM SERVICIOEXTRA se INNER JOIN CLIENTE cl ON se.contrato_rut_cliente = cl.rut_cliente WHERE cl.rut_cliente = '"+idCliente+"'";
                        ResultSet rsServicioExtraCliente = st.executeQuery(queryServicioExtraCliente);                
                        while(rsServicioExtraCliente.next()){
                        java.sql.Date fechaExCli = rsContratoCliente.getDate("FECHAEXTRA");
                        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        String fechaSerExtCli = dateFormat.format(fechaExCli);
                    %>
                    <tr>
                        <td><%=rsServicioExtraCliente.getInt("ID_EXTRA")%></td>
                        <td><%=rsServicioExtraCliente.getString("DESCRIPCIONEXTRA")%></td>
                        <td><%=fechaSerExtCli%></td>
                        <td><%=rsServicioExtraCliente.getInt("COSTOEXTRA")%></td>
                    </tr>
                    <%
                        } 
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
