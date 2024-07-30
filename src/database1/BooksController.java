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
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
public class BooksController implements Initializable {

    @FXML
    private TableColumn<Book, Integer> c1;
    @FXML
    private TableColumn<Book, String> c2;
    @FXML
    private ImageView one;
    @FXML
    private ImageView two;
    @FXML
    private ImageView tree;
    @FXML
    private TableView<Book> btable;
    @FXML
    private TextField bar;
    @FXML
    private TextField tit;
    @FXML
    private TextField writer;
    @FXML
    private TextField price;
    @FXML
    private TableColumn<Book, String> c3;
    @FXML
    private TableColumn<Book, Integer> c4;
    int index;
    @FXML
    private JFXTextField rr;
    @FXML
    private Button search;

    /**
     * Initializes the controller class.
     */
    
    
    
     @FXML
    private void add(ActionEvent event) {
        try{
         EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
      
        String barr = bar.getText();
        String titt = tit.getText();
         String wri = writer.getText();
           String pri = price.getText();
           
//  btable.getItems().add(new Book(BigDecimal.valueOf(Long.parseLong(barr)), titt, BigInteger.valueOf(Long.parseLong(barrr))));
  Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)));

         em.getTransaction().begin();
         em.persist(b);
         em.getTransaction().commit();
         
         
         btable.getItems().add(b);
           for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
           EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr7=em1.createNamedQuery("Book.findAll");
             List <Book> emp7 = qr7.getResultList();
             for( Book c : emp7){
                      
        BigDecimal barr7 = c.getBookBarcode();
        String titt7 = c.getTitle();
         String wri7 = c.getWritter();
            BigInteger pri7 = c.getPrice();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("bookBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Book ,String>("title")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Book ,String>("writter")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("price")) ;
            
         
         
         
         
         
         
         
         
         JOptionPane.showMessageDialog(null, "تم اضافه الكتاب بنجاح ");
         
        }
       // btable.getItems().add(new Book(bookBarcode,  title));
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "الكتاب موجود مسبقا "); 
           
       }
        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr=em.createNamedQuery("Book.findAll");
             List <Book> emp = qr.getResultList();
             for( Book c : emp){
                      
        BigDecimal barr = c.getBookBarcode();
        String titt = c.getTitle();
         String wri = c.getWritter();
            BigInteger pri = c.getPrice();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("bookBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Book ,String>("title")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Book ,String>("writter")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("price")) ;
        
        
        //  em.getTransaction().commit();  
       // c2.cellValueFactoryProperty(e->e.get);
    
       
      
    }    

   

    @FXML
    private void delete(ActionEvent event) {
            if (index<=-1){
         return;
     }
            try{
                EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
                
            btable.getItems().remove(index);
            index=-1;
          
               Query qr=em.createNamedQuery("Book.findAll");
           //     PreparedStatementment ps = em.PreparedStatementment
             List <Book> emp = qr.getResultList();
             for( Book c : emp){
                      String s7=""+c.getBookBarcode();
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
          
               Query qr=em.createNamedQuery("Book.findAll");
           //     PreparedStatementment ps = em.PreparedStatementment
             List <Book> emp = qr.getResultList();
             for( Book c : emp){
                      String s7=""+c.getBookBarcode();
     if (s7.equals(bar.getText())){
         
       
       em.refresh(c);
           // em.remove(c);
            
         break;
     }
     
             }
//  btable.getItems().add(new Book(BigDecimal.valueOf(Long.parseLong(barr)), titt, BigInteger.valueOf(Long.parseLong(barrr))));
 // Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)));
 //  btable.getItems().remove(index);
   
          String barr = bar.getText();
                     String titt = tit.getText();
         String wri = writer.getText();
           String pri = price.getText();

           
 //  Book b = new Book (BigDecimal.valueOf(Long.parseLong(barr)), titt,wri, BigInteger.valueOf(Long.parseLong(pri)) );
              //em.refresh(titt);em.createQuery("update Book set title = "+tit.getText());
         Book b = em.find(Book.class,BigDecimal.valueOf(Long.parseLong(barr)));
 //btable.getItems().add(b);
 
   em.getTransaction().begin();
  b.setPrice(BigInteger.valueOf(Long.parseLong(pri)));
  b.setWritter(wri);
   b.setTitle(titt);
    //em.refresh(b);
       em.persist(b);
         em.getTransaction().commit();
         
         
         
       for ( int i = 0; i<btable.getItems().size(); i++) {
    btable.getItems().clear();
}
           EntityManager em1 =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();
         Query qr7=em1.createNamedQuery("Book.findAll");
             List <Book> emp7 = qr.getResultList();
             for( Book c : emp7){
                      
        BigDecimal barr7 = c.getBookBarcode();
        String titt7 = c.getTitle();
         String wri7 = c.getWritter();
            BigInteger pri7 = c.getPrice();
               btable.getItems().add(c);
             }
        
        
        c1.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("bookBarcode")) ;
        c2.setCellValueFactory(new PropertyValueFactory<Book ,String>("title")) ;
        c3.setCellValueFactory(new PropertyValueFactory<Book ,String>("writter")) ;
          c4.setCellValueFactory(new PropertyValueFactory<Book ,Integer>("price")) ;
            
                  
                  // em1.getTransaction().commit();  
         JOptionPane.showMessageDialog(null, "تم تعديله الكتاب بنجاح ");

         //btable.getItems().add(b);
         }
         catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
         }
  
    }

    @FXML
    private void search(ActionEvent event) {
        try{
      EntityManager em =  Persistence.createEntityManagerFactory("database1PU").createEntityManager();  
      
      String k = rr.getText();
      Book b = em.find(Book.class,BigDecimal.valueOf(Long.parseLong(k)));
            bar.setText(b.getBookBarcode().toString());  
    
    tit.setText( b.getTitle());  
    writer.setText( b.getWritter());  
    price.setText(b.getPrice().toString() ); 
        
        
        }
        catch(Exception e){
                           JOptionPane.showMessageDialog(null, e.toString());
 
        }
        
        
        
    }

 
    
}
