
package superMarket.viewControl;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import superMarket.Controller.EmployeeControl;
import superMarket.Controller.ProductControl;
import superMarket.model.EmployeeModel;
import superMarket.model.ProductModel;

/**
 *
 * @author hussein
 */
public class Employee implements Initializable{
    

    

    @FXML
    private TextField txtName ;
    @FXML
    private TextField txtSalary;
    @FXML
    private TextField txtRank;
    @FXML
    private TextField txtCity ;
    @FXML
    private TextField txtSearch ;
    @FXML
    private TextField txtStreet ;
    @FXML
    private DatePicker date ;
    @FXML
    private ComboBox Type ;
    @FXML
    private Button btnAdd ;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnBack;
    @FXML
    private TableView table;
    @FXML
    private TableColumn id;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn salary;
    @FXML
    private TableColumn join;
    @FXML
    private TableColumn rank;
    @FXML
    private TableColumn city;
    @FXML
    private TableColumn street;
    
    
    EmployeeControl ec = new EmployeeControl();
    int ID;
    String  TypeProduct[]={"manager","cachier"};;
    ObservableList<String> olType =FXCollections.observableArrayList(TypeProduct);
    
      
        //Action 
       //-----------------------------------------------------------------------------------------
        public void Add(Event e)
        {
          EmployeeModel emp = new EmployeeModel();
          if(!txtName.getText().equals("")&&!txtSalary.getText().equals("")&&!Type.getValue().equals("")){
          emp.setEmp_Name(txtName.getText());
          emp.setEmp_Salary(Double.parseDouble(txtSalary.getText()));
          emp.setJoin_Year(Date.valueOf(date.getValue()));
          emp.setRank(Type.getValue().toString());
          emp.setCity(txtCity.getText());
          emp.setStreet(txtStreet.getText());
         
          
          
          ec.insert(emp);
          
          txtName.setText("");
          txtSalary.setText("");
          txtCity.setText("");
          txtStreet.setText("");
         
          
          table.setItems(ec.getAllEmployee());
          }
          
        }
        
        public void Update(Event e)
        {
          EmployeeModel emp = new EmployeeModel();
         if(!txtName.getText().equals("")&&!txtSalary.getText().equals("")&&!Type.getValue().equals("")){
          emp.setEmp_Name(txtName.getText());
          emp.setEmp_Salary(Double.parseDouble(txtSalary.getText()));
          emp.setJoin_Year(Date.valueOf(date.getValue()));        
          emp.setRank(Type.getValue().toString());
          emp.setCity(txtCity.getText());
          emp.setStreet(txtStreet.getText());       
          emp.setEmp_ID(ID);
          
          ec.update(emp);
          
          txtName.setText("");
          txtSalary.setText("");
          txtCity.setText("");
          txtStreet.setText("");;
          
          table.setItems(ec.getAllEmployee());
          }          
        }
        
       public void Delete(Event e)
        {
         // ProductModel product = new ProductModel();
          ec.delete(ID);
          
          txtName.setText("");
          txtSalary.setText("");
          txtCity.setText("");
          txtStreet.setText("");
          
          
          table.setItems(ec.getAllEmployee());
                
        }
       
 public void Back(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   stage.close();
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/superMarket/viewFXML/Home.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
       
       public void Search(Event e)
        {
          
          table.setItems(ec.getSearchEmployee(txtSearch.getText()));
          
          
        }
       
       public void clickTable(Event e)
        {
           EmployeeModel emp =  (EmployeeModel) table.getSelectionModel().getSelectedItem();
           txtName.setText(emp.getEmp_Name());
           txtSalary.setText(emp.getEmp_Salary()+"");
           txtCity.setText(emp.getCity());
           txtStreet.setText(emp.getStreet());                 
           ID=emp.getEmp_ID();
           Type.setValue(emp.getRank());
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         
        //refere to attribute 
        
        id.setCellValueFactory(new PropertyValueFactory<>("emp_ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("emp_Name"));
        salary.setCellValueFactory(new PropertyValueFactory<>("emp_Salary"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        street.setCellValueFactory(new PropertyValueFactory<>("street"));
        join.setCellValueFactory(new PropertyValueFactory<>("join_Year"));
        rank.setCellValueFactory(new PropertyValueFactory<>("emp_Rank"));
        
        
        //show data
        table.setItems(ec.getAllEmployee());
        Type.getItems().addAll(olType);
    }
         
        
        
}


