
package superMarket.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import superMarket.model.EmployeeModel;
import superMarket.model.ProductModel;

/**
 *
 * @author hussein
 */
public class EmployeeControl {
    
     Statement state ;
    
    public void insert(EmployeeModel  emp)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("INSERT INTO `employees` (`emp_Name`, `emp_Salary`, `join_Year`, `emp_Rank`, `city`, `street`) VALUES ( '"+emp.getEmp_Name()+"' , "+emp.getEmp_Salary()+",'"+emp.getJoin_Year()+"','"+emp.getRank()+"' ,'"+emp.getCity()+"','"+emp.getStreet()+"'");
             ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("Delete FROM `employees` WHERE emp_ID = " + id);
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            ConnectionDB.closeConnection();
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(EmployeeModel emp)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE employees set  `emp_Name` = "+"'"+emp.getEmp_Name()+"'"+", `emp_Salary` = "+emp.getEmp_Salary()+", `join_Year` =  '" + emp.getJoin_Year()+"', `emp_Rank` = "+"'"+emp.getRank()+"'"+", `city` =  '"+emp.getCity()+"',`street` = '"+emp.getStreet()+"' WHERE emp_ID = "+emp.getEmp_ID());
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
    
    // return all data as observable list because table parmetar is observable
   public ObservableList<EmployeeModel> getAllEmployee()
   {
        ObservableList<EmployeeModel> employee =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM employees");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             EmployeeModel emp = new EmployeeModel();   
             emp.setEmp_ID(result.getInt(1));
             emp.setEmp_Name(result.getString(2));
             emp.setEmp_Salary(result.getDouble(3));
             emp.setJoin_Year(result.getDate(4));
             emp.setRank(result.getString(5));
             emp.setCity(result.getString(6));
             emp.setStreet(result.getString(7));
             employee.add(emp);
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return employee;
   }
   
       // return data which i search about it as observable list because table parmetar is observable
   public ObservableList<EmployeeModel> getSearchEmployee(String name)
   {
        ObservableList<EmployeeModel> employee =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM employees WHERE emp_Name LIKE '%"+name+"%'");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             EmployeeModel emp = new EmployeeModel();   
             emp.setEmp_ID(result.getInt(1));
             emp.setEmp_Name(result.getString(2));
             emp.setEmp_Salary(result.getDouble(3));
             emp.setJoin_Year(result.getDate(4));
             emp.setRank(result.getString(5));
             emp.setCity(result.getString(6));
             emp.setStreet(result.getString(7));
             employee.add(emp);      
            }
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
     
       return employee;
   }
   

    
}
