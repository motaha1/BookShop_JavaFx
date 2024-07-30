/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.awt.*;
import java.awt.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.*;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author pc
 */
public class HomeController implements Initializable {
@FXML 
Button one;

@FXML 
Button onee;
    @FXML
    private Button two;
    /**
     * Initializes the controller class.
     * @param pp
     */
 public void login (ActionEvent pp) throws IOException{
     
            Stage stage = (Stage) one.getScene().getWindow();
    stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage1 =new Stage();
        
        stage1.setScene(scene);
        stage1.setTitle("login ");
        stage1.show();
        
        
    }
 
 public void zz (Event yy){
     
     
     
 }
 
 
public final EventHandler<ActionEvent> getOnAction(){
    return null;
    
    
    
    
} 


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
