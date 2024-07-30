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
public class StaController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button del;
    @FXML
    private TableView<Stationery> btable;
    @FXML
    private TableColumn<Stationery, Integer> c1;
    @FXML
    private TableColumn<Stationery, String> c2;
    @FXML
    private TableColumn<Stationery, Double> c3;
    @FXML
    private JFXTextField tit;
    @FXML
    private JFXTextField price;
    @FXML
    private JFXTextField bar;
    int index = -1;
    @FXML
    private Button update;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
          
         Query qr=em.createNamedQuery("Stationery.findAll");
             List <Stationery> emp = qr.getResultList();
             for( Stationery c : emp){
                      
        BigDecimal barr = c.getStaBarcode();
        String titt = c.getName();
      //   String wri = c.getWritter();
            BigInteger pri = c.getPrice();
               btable.getItems().add(c);
               
               
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Stationery ,Integer>("staBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("name")) ;
      //  c3.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("writter")) ;
          c3.setCellValueFactory(new PropertyValueFactory<Stationery ,Double>("price")) ;
        
    }    

    @FXML
    private void add(ActionEvent event) {
        
        try{
         EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
      
        String barr = bar.getText();
        String titt = tit.getText();
        
           String pri = price.getText();
           BigInteger k = BigDecimal.valueOf(Long.parseLong(pri)).toBigInteger();

           
//  btable.getItems().add(new Book(BigDecimal.valueOf(Long.parseLong(barr)), titt, BigInteger.valueOf(Long.parseLong(barrr))));
  Stationery b = new Stationery ();
  b.setStaBarcode(BigDecimal.valueOf(Long.parseLong(barr)));
  b.setName(titt);
b.setPrice(BigDecimal.valueOf(Double.parseDouble(pri)).toBigIntegerExact());
         em.getTransaction().begin();
         em.persist(b);
         em.getTransaction().commit();
         
         btable.getItems().add(b);
         
         
         
         
         
         
         
         
         
         for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
           EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr7=em1.createNamedQuery("Stationery.findAll");
             List <Stationery> emp7 = qr7.getResultList();
             for( Stationery c : emp7){
                      
        BigDecimal barr7 = c.getStaBarcode();
        String titt7 = c.getName();
        // String wri7 = c.getWritter();
            BigInteger pri7 = c.getPrice();
               btable.getItems().add(c);
             }
        
      c1.setCellValueFactory(new PropertyValueFactory<Stationery ,Integer>("staBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("name")) ;
      //  c3.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("writter")) ;
          c3.setCellValueFactory(new PropertyValueFactory<Stationery ,Double>("price")) ;
          
          
          JOptionPane.showMessageDialog(null, "تم اضافه المنتج بنجاح ");
        }
        
        
        
        
        
        
        
        
        
        
        
       // btable.getItems().add(new Book(bookBarcode,  title));
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "المنتج موجود مسبقا "); 
           
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
          
               Query qr=em.createNamedQuery("Stationery.findAll");
           //     PreparedStatementment ps = em.PreparedStatementment
             List <Stationery> emp = qr.getResultList();
             for( Stationery c : emp){
                      String s7=""+c.getStaBarcode();
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
            //writer.clear(); 
            price.clear();
            }
            catch (Exception e){
                
                  JOptionPane.showMessageDialog(null, e.toString());
            }
        
    }

    @FXML
    private void select(MouseEvent event) {

     index=  btable.getSelectionModel().getSelectedIndex();
     if (index<=-1){
         return;
     }
     String s= ""+c1.getCellData(index);
      String s1= ""+c3.getCellData(index);
    bar.setText(s);  
    
    tit.setText( c2.getCellData(index));  
   // writer.setText( c3.getCellData(index));  
    price.setText( s1);  
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
         //String wri = writer.getText();
           String pri = price.getText();

           
 //  Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)) );
              //em.refresh(titt);em.createQuery("update Book set title = "+tit.getText());
         Stationery b = em.find(Stationery.class,BigDecimal.valueOf(Long.parseLong(barr)));
 //btable.getItems().add(b);
 
   em.getTransaction().begin();
  b.setPrice(BigInteger.valueOf(Long.parseLong(pri)));
  //b.setWritter(wri);
   b.setName(titt);
    //em.refresh(b);
       em.persist(b);
         em.getTransaction().commit();
         
         
         
       for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
           EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr7=em1.createNamedQuery("Stationery.findAll");
             List <Stationery> emp7 = qr7.getResultList();
             for( Stationery c : emp7){
                      
        BigDecimal barr7 = c.getStaBarcode();
        String titt7 = c.getName();
        // String wri7 = c.getWritter();
            BigInteger pri7 = c.getPrice();
               btable.getItems().add(c);
             }
        
      c1.setCellValueFactory(new PropertyValueFactory<Stationery ,Integer>("staBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("name")) ;
      //  c3.setCellValueFactory(new PropertyValueFactory<Stationery ,String>("writter")) ;
          c3.setCellValueFactory(new PropertyValueFactory<Stationery ,Double>("price")) ;
                  
                  // em1.getTransaction().commit();  
         JOptionPane.showMessageDialog(null, "تم تعديله المنتج بنجاح ");

         //btable.getItems().add(b);
         }
         catch(Exception e){
                JOptionPane.showMessageDialog(null, "لا يمكن تعديل الباركود");
         }
    
        
        
        
        
        
    }
    
    
}
