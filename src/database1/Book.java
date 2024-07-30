/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByBookBarcode", query = "SELECT b FROM Book b WHERE b.bookBarcode = :bookBarcode")
    , @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title")
    , @NamedQuery(name = "Book.findByWritter", query = "SELECT b FROM Book b WHERE b.writter = :writter")
    , @NamedQuery(name = "Book.findByYearOfPub", query = "SELECT b FROM Book b WHERE b.yearOfPub = :yearOfPub")
    , @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price")



})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BOOK_BARCODE")
    private BigDecimal bookBarcode;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "WRITTER")
    private String writter;
    @Column(name = "YEAR_OF_PUB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yearOfPub;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private BigInteger price;
    @OneToMany(mappedBy = "bookBarcode")
    private Collection<BuyBook> buyBookCollection;

    public Book() {
    }

    public Book(BigDecimal bookBarcode) {
        this.bookBarcode = bookBarcode;
    }

    public Book(BigDecimal bookBarcode, String title, BigInteger price) {
        this.bookBarcode = bookBarcode;
        this.title = title;
        this.price = price;
    }
        public Book(BigDecimal bookBarcode, String title,String writter , BigInteger price) {
        this.bookBarcode = bookBarcode;
        this.title = title;
         this.writter = writter;
        this.price = price;
       
    }

 

   /* Book(BigDecimal valueOf, String titt, String barrr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Book(String barr, String titt, String barrr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public BigDecimal getBookBarcode() {
        return bookBarcode;
    }

    public void setBookBarcode(BigDecimal bookBarcode) {
        this.bookBarcode = bookBarcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public Date getYearOfPub() {
        return yearOfPub;
    }

    public void setYearOfPub(Date yearOfPub) {
        this.yearOfPub = yearOfPub;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<BuyBook> getBuyBookCollection() {
        return buyBookCollection;
    }

    public void setBuyBookCollection(Collection<BuyBook> buyBookCollection) {
        this.buyBookCollection = buyBookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookBarcode != null ? bookBarcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookBarcode == null && other.bookBarcode != null) || (this.bookBarcode != null && !this.bookBarcode.equals(other.bookBarcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.Book[ bookBarcode=" + bookBarcode + " ]";
    }

    void setPrice(String barr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
