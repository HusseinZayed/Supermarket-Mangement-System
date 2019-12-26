
package superMarket.viewControl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import superMarket.Controller.ServicesControl;
import superMarket.model.ProductModel;

/**
 *
 * @author hussein
 */
public class Services implements Initializable{
    
    @FXML
    private TextField txtNumber;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtDiscount ;
    @FXML
    private TextField txtSearch ;
    @FXML
    private Button btnAdd ;  
    @FXML
    private Button btnSearch;
    @FXML
    private Button back;
    @FXML
    private Button print;        
    @FXML
    private ComboBox table;
    @FXML
    private TextArea bill;
    @FXML
    private Label ltotal ;
   
    
    int numProduct;
    double total=0;
    int num =0;
    ServicesControl SC = new ServicesControl();
    ProductModel pr = new ProductModel();
    

      
        
        
        
               

    
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
 
 public void Search(){
      table.getItems().clear();
      table.getItems().addAll( SC.getSearchNamesProduct(txtSearch.getText()));
     
 }

  public void clickTable(Event e)
        {
           String  product =  (String) table.getSelectionModel().getSelectedItem();         
           pr = SC.getProduct(product);
           txtPrice.setText(pr.getPrice()+"");
           txtDiscount.setText(pr.getDiscount()+"");
           numProduct=pr.getNumber();
        }
  
  public void Buy(){
      String s=bill.getText();
      SC.update(table.getValue()+"",numProduct-(Integer.parseInt( txtNumber.getText() )));
      bill.setText(s+"Name Of Product : "+table.getValue()+"\n"+"Price Of Product : "+txtPrice.getText()+"\n"
      +"Discount Of Product : "+txtDiscount.getText()+"%\n--------------------------------------\n"
      );
      
      txtNumber.setText("");
      double x = Double.parseDouble(txtPrice.getText());
      int y = Integer.parseInt(txtDiscount.getText());
      total+=x-(x*(y/100.0));
      ltotal.setText(total+"");
    }
  
  public void Print() {

      
         
        try {
            num++;
            
             PrintWriter f = new PrintWriter("bill "+String.valueOf(num)+".txt");
             f.println(bill.getText());
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
        bill.setText("");
  
  }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
     
           table.getItems().addAll( SC.getNamesProduct());
           num=0;
           bill.setText("*****************************  فاتوره******************************\n");
    }
 
 
 
 
}
