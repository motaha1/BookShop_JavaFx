/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "BUY_BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuyBook.findAll", query = "SELECT b FROM BuyBook b")
    , @NamedQuery(name = "BuyBook.findByBuyId", query = "SELECT b FROM BuyBook b WHERE b.buyId = :buyId")
    , @NamedQuery(name = "BuyBook.findByDateOfSell", query = "SELECT b FROM BuyBook b WHERE b.dateOfSell = :dateOfSell")})
public class BuyBook implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "BUY_ID")
    private BigDecimal buyId;
    @Basic(optional = false)
    @Column(name = "DATE_OF_SELL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSell;
    @JoinColumn(name = "BOOK_BARCODE", referencedColumnName = "BOOK_BARCODE")
    @ManyToOne
    private Book bookBarcode;
    @JoinColumn(name = "CUSTOMER_SSN", referencedColumnName = "SNN")
    @ManyToOne
    private Customer customerSsn;

    public BuyBook() {
    }

    public BuyBook(BigDecimal buyId) {
        this.buyId = buyId;
    }

    public BuyBook(BigDecimal buyId, Date dateOfSell) {
        this.buyId = buyId;
        this.dateOfSell = dateOfSell;
    }

    public BigDecimal getBuyId() {
        return buyId;
    }

    public void setBuyId(BigDecimal buyId) {
        this.buyId = buyId;
    }

    public Date getDateOfSell() {
        return dateOfSell;
    }

    public void setDateOfSell(Date dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    public Book getBookBarcode() {
        return bookBarcode;
    }

    public void setBookBarcode(Book bookBarcode) {
        this.bookBarcode = bookBarcode;
    }

    public Customer getCustomerSsn() {
        return customerSsn;
    }

    public void setCustomerSsn(Customer customerSsn) {
        this.customerSsn = customerSsn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (buyId != null ? buyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyBook)) {
            return false;
        }
        BuyBook other = (BuyBook) object;
        if ((this.buyId == null && other.buyId != null) || (this.buyId != null && !this.buyId.equals(other.buyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.BuyBook[ buyId=" + buyId + " ]";
    }
    
}
