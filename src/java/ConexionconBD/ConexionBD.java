package ConexionconBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    static String driver = "oracle.jdbc.OracleDriver";
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String user = "sebafzen";
    static String pass = "duoc";
    
    protected Connection conn = null;
    
    public ConexionBD(){
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
        }catch(SQLException e){
            System.out.println("Error de SQL" + e.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Falta Driver" + ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public int loguear(String email, String pass){
        PreparedStatement pst;
        ResultSet rs;
        int tipoUser = 0;
        String sql = "SELECT TIPOUSUARIO FROM USUARIO WHERE EMAIL = '"+email+"' AND PASSWORD = '"+pass+"'";
               
        try {
            ConexionBD conec = new ConexionBD();
            Connection conn = conec.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                tipoUser = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoUser;
    }
    
    public String obtenerIdProfesional(String email, String pass){
        PreparedStatement pst;
        ResultSet rs;
        String rutProfesional = "";
        String sql = "SELECT p.RUT_PROFESIONAL FROM PROFESIONAL p INNER JOIN USUARIO us ON us.ID_USUARIO = p.USUARIO_ID_USUARIO WHERE us.email = '"+email+"' AND us.password = '"+pass+"'";

        try {
            ConexionBD conec = new ConexionBD();
            Connection conn = conec.conectar();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                rutProfesional = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rutProfesional;
    }
    
}