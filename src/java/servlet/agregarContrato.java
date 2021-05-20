/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ConexionconBD.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        
        try{  
            CallableStatement  cst = conn.prepareCall("{call RegistrarContrato(?,?,?,?,?)}");
            cst.setDate(1, fechaInicio);
            cst.setDate(2, fechaTermino);
            cst.setInt(3, 2); 
            cst.setInt(4, idProfesional);
            cst.setInt(5, planServicio); 
            cst.executeUpdate(); 
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
