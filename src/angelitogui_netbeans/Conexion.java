package angelitogui_netbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es exclusiva del conector, el cual es nuestro intermediario
 * para conectar la base de datos de la empresa con nuestra interfaz
 * en java
 * 
 * @author jonce
 */

public class Conexion {
    public static Connection getConexion(){
        
    Connection con = null;
        
    String URL="jdbc:mysql://localhost:3306/angelito";
    String USERNAME="root";
    String PASSWORD="coatza";
    
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  con;            
   
    
    }
}
