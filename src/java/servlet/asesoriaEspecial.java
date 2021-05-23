package servlet;

import ConexionconBD.ConexionBD;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class asesoriaEspecial extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.getRequestDispatcher("WEB-INF/asesoria/asesoriaEspecial.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession sesion = request.getSession();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        
        String fechaAse = request.getParameter("fAsesoria");
        
        java.util.Date fechaAs = null;
        
        try {
            fechaAs = formatoFecha.parse(fechaAse);
        } catch (ParseException ex) {
            Logger.getLogger(asesoriaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date fechaAsesoria = new java.sql.Date(fechaAs.getTime()); 
        
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        int IdProf = Integer.parseInt(sesion.getAttribute("idProfesional").toString());
        String tipoAsesoria = request.getParameter("tAsesoria");
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar(); 
        
        try {
            CallableStatement cst = conn.prepareCall("{call RegistrarAsesoria(?,?,?,?)}");
            cst.setDate(1, fechaAsesoria);
            cst.setString(2, tipoAsesoria);
            cst.setInt(3, IdProf);
            cst.setInt(4, idCliente);
            cst.executeUpdate();           
        } catch (SQLException ex) {
            Logger.getLogger(asesoriaEspecial.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("listarAsesoria");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
