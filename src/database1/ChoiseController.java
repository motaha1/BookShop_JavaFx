/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author pc
 */
public class ChoiseController implements Initializable {

    @FXML
    private Button one;
    @FXML
    private Button two;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void open1(ActionEvent event) throws IOException {
         Parent root7 = FXMLLoader.load(getClass().getResource ("books.fxml"));
        
        Scene scene = new Scene(root7);
        
        Stage stage7 =new Stage();
        
        stage7.setScene(scene);
        stage7.setTitle("book ");
        stage7.show(); 
        
        
        
        
    }

    @FXML
    private void open2(ActionEvent event) throws IOException {
           Parent root7 = FXMLLoader.load(getClass().getResource("sta.fxml"));
        
        Scene scene = new Scene(root7);
        
        Stage stage7 =new Stage();
        
        stage7.setScene(scene);
        stage7.setTitle("قرطاسيه ");
        stage7.show(); 
        
        
        
        
        
    }
    
}
