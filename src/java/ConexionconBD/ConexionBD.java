package ConexionconBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
