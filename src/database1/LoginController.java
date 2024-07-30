/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;


import java.awt.Event;
import java.math.BigDecimal;
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
import java.net.URL;
import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*; 
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import static javax.persistence.DiscriminatorType.INTEGER;


/**
 * FXML Controller class
 *
 * @author pc
 */







public class LoginController implements Initializable {
@FXML 
Button but;


@FXML 
 TextField user ;

@FXML 
 PasswordField  pass ;
    ImageView im;
    @FXML
    private Label lo;

    @FXML
    public void login (ActionEvent pp){
        lo.setVisible(true);
         int x=0;
        try{
            
           EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
           Query qr=em.createNamedQuery("Employee.findAll");
             List <Employee> emp = qr.getResultList();
             for( Employee c : emp){
                String one = c.getFname();
                BigDecimal bd = c.getSnn();
                String two = bd.toString();
               if( user.getText().trim().equals(one)&&pass.getText().equals(two))  {
                 x=1;
             }   
             }
            em.close();
              if(x==1){
                  x=0;
                  
            Stage stage = (Stage) but.getScene().getWindow();
              
    stage.close();
  
         
             
              
        Parent root = FXMLLoader.load(getClass().getResource("adminmain.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage1 =new Stage();
        stage1.setScene(scene);
        stage1.show();
        
         
              }
              
     else{
                  
                  lo.setVisible(false);
                JOptionPane.showMessageDialog(null, "يرجى التاكد من اسم المستخدم و كلمه المرور");
                 
                
            }
        }
            
            
     
        
        catch(Exception mi){
            
            lo.setVisible(false);
                   JOptionPane.showMessageDialog(null, mi.toString());
            
        }
        
        
    }
//public void zoom(ActionEvent e){
    
  //((Button) e.getSource()).setBackground(Color.yellow);
         
        
//}
    

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          lo.setVisible(false);
        
    }    
    


    
}
    
    