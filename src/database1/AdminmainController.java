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
public class AdminmainController implements Initializable {

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void io(ActionEvent event) {
        
    }

    @FXML
    private void iso(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("choise.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage1 =new Stage();
        
        stage1.setScene(scene);
        stage1.setTitle("books ");
        stage1.show();
         
    }

    @FXML
    private void add(ActionEvent event) throws IOException {
  Parent root7 = FXMLLoader.load(getClass().getResource("em.fxml"));
        
        Scene scene = new Scene(root7);
        
        Stage stage7 =new Stage();
        
        stage7.setScene(scene);
        stage7.setTitle("اضافة موظف ");
        stage7.show();
        
        
    }
    
}
