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

public class checklistAsesoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/asesoria/checklistAsesoria.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession sesion = request.getSession();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        
        String fechaChAs = request.getParameter("fechaChecklistAsesoria");
        
        java.util.Date fechaChkAsesoria = null;
        try {
            fechaChkAsesoria = formatoFecha.parse(fechaChAs);
        } catch (ParseException ex) {
            Logger.getLogger(agregarContrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date fechaChekListAsesoria = new java.sql.Date(fechaChkAsesoria.getTime());
        
        String CausanteChecklist = request.getParameter("causanteAsesoria");
        String mejoracheckList = request.getParameter("mejoraCheckListAsesoria");
        int IdAsesoria = Integer.parseInt(request.getParameter("idAsesoria"));
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar();
        
        try{  
            CallableStatement cst = conn.prepareCall("{call RegistrarCheckListAsesoria(?,?,?,?,?)}");
            cst.setDate(1, fechaChekListAsesoria);
            cst.setString(2, CausanteChecklist);
            cst.setString(3, mejoracheckList);
            cst.setString(4, "T"); 
            cst.setInt(5, IdAsesoria); 
            cst.executeUpdate(); 
        }catch(SQLException ex){
            System.out.println("Error de SQL" + ex);
        }
        response.sendRedirect("listarAsesoria");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
