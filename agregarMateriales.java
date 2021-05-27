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

@WebServlet(name = "agregarMateriales", urlPatterns = {"/agregarMateriales"})
public class agregarMateriales extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/capacitacion/agregarMateriales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
    
        String nomMat = request.getParameter("nombreMateriles");
        int cosMat = Integer.parseInt(request.getParameter("costoMateriales"));
        int IdCap = Integer.parseInt(request.getParameter("idCapacitacion"));
//        String IdCap = request.getParameter("idCapacitacionSeleccionada");
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar(); 
        
        try{  
            CallableStatement cst = conn.prepareCall("{call RegistrarMaterial(?,?,?)}");
            
            cst.setString(1, nomMat);
            cst.setInt(2,cosMat);
            cst.setInt(3, IdCap);
            cst.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Error de SQL" + ex);
        }
        response.sendRedirect("listarCapacitaciones");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}