

package superMarket.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hussein
 */
public class ConnectionDB {
    
        
    private static Connection con ;
    private static String url="jdbc:mysql://localhost/SuperMarket?useUnicode=true&characterEncoding=UTF-8";

    private ConnectionDB() {
        
    }
    
   
    
    public static Connection openConnection()
    {
       if(con == null){
         try {          
            con = (Connection) DriverManager.getConnection(url,"root","");                   
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        return con;
    }
    
    public static void closeConnection()
    {       
        if(con != null)
          con = null;
    }
}
