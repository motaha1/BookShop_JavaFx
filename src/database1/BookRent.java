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
import javax.persistence.CascadeType;
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
@Table(name = "BOOK_RENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookRent.findAll", query = "SELECT b FROM BookRent b")
    , @NamedQuery(name = "BookRent.findByBookBarcode", query = "SELECT b FROM BookRent b WHERE b.bookBarcode = :bookBarcode")
    , @NamedQuery(name = "BookRent.findByTitle", query = "SELECT b FROM BookRent b WHERE b.title = :title")
    , @NamedQuery(name = "BookRent.findByWritter", query = "SELECT b FROM BookRent b WHERE b.writter = :writter")
    , @NamedQuery(name = "BookRent.findByYearOfPub", query = "SELECT b FROM BookRent b WHERE b.yearOfPub = :yearOfPub")
    , @NamedQuery(name = "BookRent.findByPricePerMonth", query = "SELECT b FROM BookRent b WHERE b.pricePerMonth = :pricePerMonth")})
public class BookRent implements Serializable {

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
    @Column(name = "PRICE_PER_MONTH")
    private BigInteger pricePerMonth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookBarcode")
    private Collection<Rent> rentCollection;

    public BookRent() {
    }

    public BookRent(BigDecimal bookBarcode) {
        this.bookBarcode = bookBarcode;
    }

    public BookRent(BigDecimal bookBarcode, String title, BigInteger pricePerMonth) {
        this.bookBarcode = bookBarcode;
        this.title = title;
        this.pricePerMonth = pricePerMonth;
    }

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

    public BigInteger getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(BigInteger pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    @XmlTransient
    public Collection<Rent> getRentCollection() {
        return rentCollection;
    }

    public void setRentCollection(Collection<Rent> rentCollection) {
        this.rentCollection = rentCollection;
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
        if (!(object instanceof BookRent)) {
            return false;
        }
        BookRent other = (BookRent) object;
        if ((this.bookBarcode == null && other.bookBarcode != null) || (this.bookBarcode != null && !this.bookBarcode.equals(other.bookBarcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.BookRent[ bookBarcode=" + bookBarcode + " ]";
    }
    
}
