
package superMarket.viewControl;

import superMarket.Controller.ConnectionDB;
import superMarket.Controller.LoginControl;
import superMarket.model.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author hussein
 */
public class Login implements Initializable {

    LoginControl rg = new LoginControl();
    LoginModel lg = new LoginModel();
    
    
    @FXML
    private Button signin;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField password;
    @FXML
    private Label lblServer;
    @FXML
    private Label lblError;
    
    Connection con=null;

    public Login() {
       
        con=ConnectionDB.openConnection();
    }
    
   
    
    @FXML
    public void isSign(Event event) {

       
            //login here
      
            lg.setUsername(txtUserName.getText());
            lg.setPassword(password.getText());
            
            if (rg.isLogin(lg)) {
                try {
                    //add you loading or delays - ;-)
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();                  
                    stage.close();
                   if(rg.getType().equals("admin")){
                   Parent root = FXMLLoader.load(getClass().getResource("/superMarket/viewFXML/Home.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
                   }
                   else{
                   Parent root = FXMLLoader.load(getClass().getResource("/superMarket/viewFXML/Services.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
                   }
                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
                
            }
            else
                lblError.setText("username or password is wrong");
            
        
    }
            
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        if (con == null) {
            lblServer.setTextFill(Color.TOMATO);
            lblServer.setText("Server Error : Check");
        } else {
            lblServer.setTextFill(Color.GREEN);
            lblServer.setText("Server is up : Good to go");
        }
    }
    
}
