/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ConexionconBD.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

@WebServlet(name = "agregarContrato", urlPatterns = {"/agregarContrato"})
public class agregarContrato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/contrato/agregarContrato.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        
        //Con este codigo es un ejemplo de como agregar un usuario
        
//        Usuario usuario = new Usuario();
//        usuario.setTipousuario(2);
//        usuario.setEmail("nicoruiz@gmail.com");
//        usuario.setPassword("nicoruiz.12");
//        
//        ConexionBD conec = new ConexionBD();
//        Connection conn = conec.conectar();
//        PreparedStatement st;
//        
//        String sql = "INSERT INTO USUARIO(TIPOUSUARIO, EMAIL, PASSWORD) VALUES(?,?,?)";
//        
//        try{           
//                
//            st = conn.prepareStatement(sql);
//            st.setInt(1, usuario.getTipousuario());
//            st.setString(2, usuario.getEmail());
//            st.setString(3, usuario.getPassword());     
//            st.executeUpdate();
//        }catch(SQLException ex){
//            System.out.println("Error de SQL" + ex);
//        }
//        request.getRequestDispatcher("listarContrato").forward(request, response);


        //Codigo para Agregar un contrato
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        
        String fechaIn = request.getParameter("fInicio");
        String fechaTe = request.getParameter("fVencimiento");
        
        java.util.Date fechaIni = null;
        try {
            fechaIni = formatoFecha.parse(fechaIn);
        } catch (ParseException ex) {
            Logger.getLogger(agregarContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Date fechaInicio = new java.sql.Date(fechaIni.getTime());
        
        
        java.util.Date fechaTer = null;
        try {
            fechaTer = formatoFecha.parse(fechaTe);
        } catch (ParseException ex) {
            Logger.getLogger(agregarContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date fechaTermino = new java.sql.Date(fechaTer.getTime());
        
        int idProfesional = Integer.parseInt(request.getParameter("id_Profesional"));
        int planServicio = Integer.parseInt(request.getParameter("id_PlanServicio"));
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar();
        PreparedStatement st;
        
        String sql = "INSERT INTO CONTRATO(FECHAINICIO, FECHATERMINO, CLIENTE_ID_CLIENTE, PROFESIONAL_ID_PROFESIONAL, PLAN_SERVICIO_ID_PLAN_SERVICIO) VALUES(?,?,?,?,?)";
        
        try{                
            st = conn.prepareStatement(sql);
            st.setDate(1, fechaInicio);
            st.setDate(2, fechaTermino);
            st.setInt(3, 2); 
            st.setInt(4, idProfesional);
            st.setInt(5, planServicio);
            st.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Error de SQL" + ex);
        }
        request.getRequestDispatcher("listarContrato").forward(request, response);


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
