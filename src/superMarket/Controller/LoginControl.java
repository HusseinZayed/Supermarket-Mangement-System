
package superMarket.Controller;

import java.sql.ResultSet;
import superMarket.model.LoginModel;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hussein
 */

public class LoginControl {
    
         Statement st;
         String type;
         
        public  boolean isLogin(LoginModel lg ){
           
         
            
        try {
             st=ConnectionDB.openConnection().createStatement();
            String check="select * from admins where username ='"+lg.getUsername()+"' and password = '"+lg.getPassword()+"'";
            ResultSet result =  st.executeQuery(check);
            while(result.next()){
                type=result.getString(3);
                return true;
            }
             ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            System.out.println("hi"+ex.getMessage());
        }
       
       return false;
    }
        
  
    public String getType(){
        
        if(type.equals("admin"))
            return "admin";
        else
            return "cachier";
    }
   

    
}
