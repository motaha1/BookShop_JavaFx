/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class EmController implements Initializable {

    @FXML
    private TableView<Employee> btable;
    @FXML
    private TableColumn<Employee, Integer> c1;
    @FXML
    private TableColumn<Employee,String> c2;
    @FXML
    private TableColumn<Employee, String> c3;
    @FXML
    private TableColumn<Employee, Integer> c4;
    @FXML
    private Button add;
    @FXML
    private Button del;
    @FXML
    private Button update;
    @FXML
    private JFXTextField tit;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField bar;
    @FXML
    private JFXTextField writer;
int index ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr=em.createNamedQuery("Employee.findAll");
             List <Employee> emp = qr.getResultList();
             for( Employee c : emp){
                      
        BigDecimal barr = c.getSnn();
        String titt = c.getFname();
         String wri = c.getLname();
            BigInteger pri = c.getSalary();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("snn")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Employee ,String>("fname")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Employee ,String>("lname")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("salary")) ;
        
        
        // TODO
    }    

    @FXML
    private void select(MouseEvent event) {
         index=  btable.getSelectionModel().getSelectedIndex();
     if (index<=-1){
         return;
     }
     String s= ""+c1.getCellData(index);
      String s1= ""+c4.getCellData(index);
    bar.setText(s);  
    
    tit.setText( c2.getCellData(index));  
    writer.setText( c3.getCellData(index));  
    price.setText( s1);  
    }

    @FXML
    private void add(ActionEvent event) {
           try{
         EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
      
        String barr = bar.getText();
        String titt = tit.getText();
         String wri = writer.getText();
           String pri = price.getText();
           
//  btable.getItems().add(new Book(BigDecimal.valueOf(Long.parseLong(barr)), titt, BigInteger.valueOf(Long.parseLong(barrr))));
 Employee b = new Employee(BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)));

         em.getTransaction().begin();
         em.persist(b);
         em.getTransaction().commit();
         
         
         btable.getItems().add(b);
           for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
           EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr=em1.createNamedQuery("Employee.findAll");
             List <Employee> emp = qr.getResultList();
             for( Employee c : emp){
                      
        BigDecimal barr1 = c.getSnn();
        String titt1 = c.getFname();
         String wri1 = c.getLname();
            BigInteger pri1 = c.getSalary();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("snn")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Employee ,String>("fname")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Employee ,String>("lname")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("salary")) ;
         
         
         
         
         
         
         
         JOptionPane.showMessageDialog(null, "تم الاضافه بنجاح ");
         
        }
       // btable.getItems().add(new Book(bookBarcode,  title));
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "error "); 
           
       }  
        
        
        
        
        
        
    }

    @FXML
    private void del(ActionEvent event) {
                 if (index<=-1){
         return;
     }
            try{
                EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
                
            btable.getItems().remove(index);
            index=-1;
          
               Query qr=em.createNamedQuery("Employee.findAll");
           //     PreparedStatementment ps = em.PreparedStatementment
             List <Employee> emp = qr.getResultList();
             for( Employee c : emp){
                      String s7=""+c.getSnn();
     if (s7.equals(bar.getText())){
         
        emp.remove(c) ;
        em.remove(c);
           // em.remove(c);
            
         break;
     }
     
             }
          emp.clear();
           em.getTransaction().begin();
          //em.persist(emp);
         em.getTransaction().commit();  
         em.close();
           bar.clear();
            tit.clear();
            writer.clear(); 
            price.clear();
            }
            catch (Exception e){
                
                  JOptionPane.showMessageDialog(null, e.toString());
            }   
        
        
    }

    @FXML
    private void update(ActionEvent event) {
     try{   
             EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
            //     btable.getItems().remove(index);
          //  index=-1;
          
 
//  btable.getItems().add(new Book(BigDecimal.valueOf(Long.parseLong(barr)), titt, BigInteger.valueOf(Long.parseLong(barrr))));
 // Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)));
 //  btable.getItems().remove(index);
   
          String barr = bar.getText();
                     String titt = tit.getText();
         String wri = writer.getText();
           String pri = price.getText();

           
 //  Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)) );
              //em.refresh(titt);em.createQuery("update Book set title = "+tit.getText());
        Employee b = em.find(Employee.class,BigDecimal.valueOf(Long.parseLong(barr)));
 //btable.getItems().add(b);
 
   em.getTransaction().begin();
  b.setSalary(BigInteger.valueOf(Long.parseLong(pri)));
  b.setFname(titt);
   b.setLname(wri);
    //em.refresh(b);
       em.persist(b);
         em.getTransaction().commit();
         
         
         
       for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
     EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr1=em1.createNamedQuery("Employee.findAll");
             List <Employee> emp1 = qr1.getResultList();
             for( Employee c : emp1){
                      
        BigDecimal barr1 = c.getSnn();
        String titt1 = c.getFname();
         String wri1 = c.getLname();
            BigInteger pri1 = c.getSalary();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("snn")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Employee ,String>("fname")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Employee ,String>("lname")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Employee ,Integer>("salary")) ;
            
                  
                  // em1.getTransaction().commit();  
         JOptionPane.showMessageDialog(null, "تم تعديله  بنجاح ");

         //btable.getItems().add(b);
         }
         catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
         }
      
        
        
        
        
        
    }
    
}
