<%-- 
    Document   : index
    Created on : 12-04-2021, 18:01:27
    Author     : norar
--%>

<%@page import="java.sql.Connection"%>
<%@page import="ConexionconBD.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=email], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            buttoninput[type=submit]:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
            }

            

            .container {
                padding: 16px;
                width: 40%;
                margin: auto;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
            p{
                text-align: right;
                color: red;
            }
        </style>
    </head>
    <body>
        <form action="login" method="POST">
            <div class="container">
                <h2>Inicio de Sesión</h2>
                <label for=""><b>Correo</b></label>
                <input type="email" placeholder="Ingresa correo" name="txtEmail">

                <label for=""><b>Contraseña</b></label>
                <input type="password" placeholder="Ingresa contraseña" name="txtPass">

                <input type="submit" name="btnIngresar" value="Ingresar">
            </div>
        </form>
    </body>
</html>
