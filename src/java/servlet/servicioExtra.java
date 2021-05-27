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

@WebServlet(name = "servicioExtra", urlPatterns = {"/servicioExtra"})
public class servicioExtra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/servicioExtra.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        
        String fechaEx = request.getParameter("fechaExtra");
        
        java.util.Date fechaExtr = null;
        try {
            fechaExtr = formatoFecha.parse(fechaEx);
        } catch (ParseException ex) {
            Logger.getLogger(servicioExtra.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Date FECHAEXTRA = new java.sql.Date(fechaExtr.getTime());   
    
        int IdTpEx = Integer.parseInt(request.getParameter("idTipoExtra"));
//        String IdTpEx = sesion.getAttribute("idTipoExtra").toString();
        String descEx = request.getParameter("descripcionExtra");
        String costoExtra = request.getParameter("costoExtra");
        int IdCon = Integer.parseInt(request.getParameter("idContrato"));
//        String IdCap = request.getParameter("idCapacitacionSeleccionada");
        String rutCli = request.getParameter("rutCliente");
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar(); 
        
        try{  
            CallableStatement cst = conn.prepareCall("{call RegistrarServicioExtra(?,?,?,?,?,?)}");
            
            cst.setString(1,descEx );
            cst.setDate(2, FECHAEXTRA);
            cst.setString(3, costoExtra);
            cst.setInt(4,IdCon);
            cst.setInt(5, IdTpEx);
            cst.setString(6, rutCli);
            cst.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Error de SQL" + ex);
        }
        response.sendRedirect("listarContrato");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}