

package superMarket.viewControl;

import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import superMarket.Controller.ProductControl;
import superMarket.Controller.ServicesControl;
import superMarket.model.ProductModel;


/**
 *
 * @author hussein
 */
public class Products implements Initializable{
    
    
    //-------------------------------------------------------------------------------------
    //fields
    
    @FXML
    private Label lb ;
    @FXML
    private TextField txtName ;
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtDiscount ;
    @FXML
    private TextField txtSearch ;
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
    private TableColumn number;
    @FXML
    private TableColumn price;
    @FXML
    private TableColumn type;
    @FXML
    private TableColumn discount;
    
    
    ProductControl pc = new ProductControl();
    int ID;
    String  TypeProduct[]={"foods","drinks","fruit","vegtables","sweets","other"};;
    ObservableList<String> olType =FXCollections.observableArrayList(TypeProduct);
    
      
        //Action 
       //-----------------------------------------------------------------------------------------
        public void Add(Event e)
        {
          ProductModel product = new ProductModel();
          if(!txtName.getText().equals("")&&!txtNumber.getText().equals("")&&!txtPrice.getText().equals("")){
          product.setName(txtName.getText());
          product.setNumber(Integer.parseInt(txtNumber.getText()));
          product.setPrice(Double.parseDouble(txtPrice.getText()));
          product.setType(Type.getValue().toString());
         
          
          if(!txtDiscount.getText().equals(""))
          product.setDiscount(Integer.parseInt(txtDiscount.getText()));
          
          pc.insert(product);
          
          txtName.setText("");
          txtNumber.setText("");
          txtPrice.setText("");
          txtDiscount.setText("");
          
          table.setItems(pc.getAllProduct());
          }
          
        }
        
        public void Update(Event e)
        {
          ProductModel product = new ProductModel();
          if(!txtName.getText().equals("")&&!txtNumber.getText().equals("")&&!txtPrice.getText().equals("")){
          product.setName(txtName.getText());
          product.setNumber(Integer.parseInt(txtNumber.getText()));
          product.setPrice(Double.parseDouble(txtPrice.getText()));
          product.setDiscount(Integer.parseInt(txtDiscount.getText()));
          product.setType(Type.getValue().toString());
          product.setId(ID);
          
          pc.update(product);
          
          txtName.setText("");
          txtNumber.setText("");
          txtPrice.setText("");
          txtDiscount.setText("");
          
          table.setItems(pc.getAllProduct());
          }          
        }
        
       public void Delete(Event e)
        {
        //  ProductModel product = new ProductModel();
          pc.delete(ID);
          
          txtName.setText("");
          txtNumber.setText("");
          txtPrice.setText("");
          txtDiscount.setText("");
          
          table.setItems(pc.getAllProduct());
                
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
          
          table.setItems(pc.getSearchProduct(txtSearch.getText()));
          
          
        }
       
       public void clickTable(Event e)
        {
           ProductModel product =  (ProductModel) table.getSelectionModel().getSelectedItem();
           txtName.setText(product.getName());
           txtNumber.setText(product.getNumber()+"");
           txtPrice.setText(product.getPrice()+"");
           txtDiscount.setText(product.getDiscount()+"");
           ID=product.getId();
           Type.setValue(product.getType());
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
         
        //refere to attribute 
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        
        //show data
        table.setItems(pc.getAllProduct());
        Type.getItems().addAll(olType);
    }
         
        
        
}
