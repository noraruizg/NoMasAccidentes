<%-- 
    Document   : agregarMateriales
    Created on : 24-05-2021, 22:55:43
    Author     : norar
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Class.forName("oracle.jdbc.OracleDriver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "sebafzen", "duoc");
        Statement st = con.createStatement();
    %>
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
        <%
            HttpSession sesion = request.getSession();
            String email;
            String pass;
                
            if(sesion.getAttribute("email") != null && sesion.getAttribute("pass") != null){
                email = sesion.getAttribute("email").toString();
                pass = sesion.getAttribute("pass").toString();
            }
        %>
        
        <ul>
            <li><a href="listarContrato">Contratos</a></li>
            <li><a href="listarCapacitacion"class="active">Capacitaciones</a></li>
            <li><a href="listarAsesoria">Asesorias</a></li>
            <li><a href="servicioExtra">Servicios Extra</a></li>
            <li><a href="">Checklist</a></li>
            <li style="float:right"><a href="logout">Cerrar Sesion ${nombre}</a></li>
        </ul>
        
        <h3>Agregar Materiales</h3>
        
        <div>
            <form action="agregarMateriales" method="POST">
                <label>Nombre de Materiales</label>
                <input type="text" name="nombreMateriles" required>
                <br><br>
                
                <label>Costo Materiales</label>
                <input type="text" name="costoMateriales" required>
                <br><br>
                
                <label>Capacitacion</label>
                <select name="id_capacitacion">
                    <option value="sinAsignar" disabled selected hidden>Sin Asignar</option>
                    <%    
                      //Mostrar Capacitaciones en ComboBox  
                      String queryCapacitacion = "SELECT id_capacitacion, descripcionCapacitacion FROM capacitacion ORDER BY descripcionCapacitacion";
                      ResultSet rsCapacitacion = st.executeQuery(queryCapacitacion);
                      
                      while(rsCapacitacion.next()){
                    %>
                        <option value="<%=rsCapacitacion.getString("id_capacitacion")%>"><%=rsCapacitacion.getString("descripcionCapacitacion")%></option>
                    <%
                      } 
                    %>
                </select>
                <input type="submit" value="Crear Materiales">
            </form>
                <h3>${mensaje}</h3>
                    <c:forEach items="${mensajes}" var="mensaje">
                <h3>${mensaje}</h3>
                    </c:forEach>
        </div>
    </body>
</html>
