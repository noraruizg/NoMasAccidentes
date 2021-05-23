package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Contrato;
import servicio.Cont;

@WebServlet(name = "listarContrato", urlPatterns = {"/listarContrato"})
public class listarContrato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession s = request.getSession();
        
        Cont c= (Cont)s.getAttribute("cont");
        if(c==null)
            request.getRequestDispatcher("WEB-INF/contrato/listarContrato.jsp").forward(request, response);
        else{
            ArrayList<Contrato> contratos = c.getContrato();
            request.setAttribute("contratos", contratos);
            request.getRequestDispatcher("WEB-INF/contrato/listarContrato.jsp").forward(request, response);
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
