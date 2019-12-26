/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superMarket.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import superMarket.model.ProductModel;

/**
 *
 * @author hussein
 */
public class ServicesControl {
    
    Statement state;
    
   
    public void update(String name,int number)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE Products set  `number` = "+number +" where name = '"+name+"'");
            ConnectionDB.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }
    
   public ObservableList<String> getNamesProduct()
   {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT name FROM Products");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             ProductModel pr = new ProductModel();            
            // pr.setName(result.getString(1));         
             product.add(result.getString(1));            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return product;
   }
   
       // return data which i search about it as observable list because table parmetar is observable
   public ObservableList<String> getSearchNamesProduct(String name)
   {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT name FROM Products WHERE name LIKE '%"+name+"%'");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time
             //ProductModel pr = new ProductModel();   
             
            // pr.setName(result.getString(1));
             
             product.add(result.getString(1));      
             ConnectionDB.closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
             ConnectionDB.closeConnection();
        }
     
       return product;
   }
   
   
   public ProductModel getProduct(String name)
   {
        ProductModel pr = new ProductModel();  
       
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM Products where name = '"+name+"'");
            
            
           
            while(result.next())
            {
             // if define object out while will store last row n time                     
             pr.setId(result.getInt(1));
             pr.setName(result.getString(2));
             pr.setNumber(result.getInt(3));
             pr.setPrice(result.getDouble(4));
             pr.setType(result.getString(5));
             pr.setDiscount(result.getInt(6));          
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       return pr;
   }
   
   
}
