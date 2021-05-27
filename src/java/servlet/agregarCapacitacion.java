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

@WebServlet(name = "agregarCapacitacion", urlPatterns = {"/agregarCapacitacion"})
public class agregarCapacitacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/capacitacion/agregarCapacitacion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        
        String fechaCap = request.getParameter("fCapacitacion");
        
        java.util.Date fechaCapa = null;
        try {
            fechaCapa = formatoFecha.parse(fechaCap);
        } catch (ParseException ex) {
            Logger.getLogger(agregarCapacitacion.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.sql.Date FECHACAPACITACION = new java.sql.Date(fechaCapa.getTime());       
        
        String descrip = request.getParameter("descripcion");
        String idCliente = request.getParameter("id_cliente");
        String IdProf = sesion.getAttribute("idProfesional").toString();
        
        ConexionBD conec = new ConexionBD();
        Connection conn = conec.conectar(); 
        
        try{  
            CallableStatement cst = conn.prepareCall("{call RegistrarCapacitacion(?,?,?,?)}");
            
            cst.setDate(1, FECHACAPACITACION);
            cst.setString(2,descrip);
            cst.setString(3, idCliente);
            cst.setString(4, IdProf);
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
