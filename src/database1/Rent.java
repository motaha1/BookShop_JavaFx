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
@Table(name = "RENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rent.findAll", query = "SELECT r FROM Rent r")
    , @NamedQuery(name = "Rent.findByRentId", query = "SELECT r FROM Rent r WHERE r.rentId = :rentId")
    , @NamedQuery(name = "Rent.findByDateOfRent", query = "SELECT r FROM Rent r WHERE r.dateOfRent = :dateOfRent")
    , @NamedQuery(name = "Rent.findByDateOfReturn", query = "SELECT r FROM Rent r WHERE r.dateOfReturn = :dateOfReturn")})
public class Rent implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RENT_ID")
    private BigDecimal rentId;
    @Basic(optional = false)
    @Column(name = "DATE_OF_RENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRent;
    @Basic(optional = false)
    @Column(name = "DATE_OF_RETURN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReturn;
    @JoinColumn(name = "BOOK_BARCODE", referencedColumnName = "BOOK_BARCODE")
    @ManyToOne(optional = false)
    private BookRent bookBarcode;
    @JoinColumn(name = "CUSTOMER_SSN", referencedColumnName = "SNN")
    @ManyToOne(optional = false)
    private Customer customerSsn;

    public Rent() {
    }

    public Rent(BigDecimal rentId) {
        this.rentId = rentId;
    }

    public Rent(BigDecimal rentId, Date dateOfRent, Date dateOfReturn) {
        this.rentId = rentId;
        this.dateOfRent = dateOfRent;
        this.dateOfReturn = dateOfReturn;
    }

    public BigDecimal getRentId() {
        return rentId;
    }

    public void setRentId(BigDecimal rentId) {
        this.rentId = rentId;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public BookRent getBookBarcode() {
        return bookBarcode;
    }

    public void setBookBarcode(BookRent bookBarcode) {
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
        hash += (rentId != null ? rentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rent)) {
            return false;
        }
        Rent other = (Rent) object;
        if ((this.rentId == null && other.rentId != null) || (this.rentId != null && !this.rentId.equals(other.rentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.Rent[ rentId=" + rentId + " ]";
    }
    
}
