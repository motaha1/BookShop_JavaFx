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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findBySnn", query = "SELECT c FROM Customer c WHERE c.snn = :snn")
    , @NamedQuery(name = "Customer.findByFname", query = "SELECT c FROM Customer c WHERE c.fname = :fname")
    , @NamedQuery(name = "Customer.findByMname", query = "SELECT c FROM Customer c WHERE c.mname = :mname")
    , @NamedQuery(name = "Customer.findByLname", query = "SELECT c FROM Customer c WHERE c.lname = :lname")
    , @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city")
    , @NamedQuery(name = "Customer.findByZipcode", query = "SELECT c FROM Customer c WHERE c.zipcode = :zipcode")
    , @NamedQuery(name = "Customer.findByStret", query = "SELECT c FROM Customer c WHERE c.stret = :stret")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SNN")
    private BigDecimal snn;
    @Basic(optional = false)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @Column(name = "MNAME")
    private String mname;
    @Basic(optional = false)
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIPCODE")
    private BigInteger zipcode;
    @Basic(optional = false)
    @Column(name = "STRET")
    private String stret;
    @OneToMany(mappedBy = "customerSsn")
    private Collection<BuyBook> buyBookCollection;
    @OneToMany(mappedBy = "customerSsn")
    private Collection<BuyStationery> buyStationeryCollection;
    @OneToMany(mappedBy = "customerSsn")
    private Collection<BuySport> buySportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerSsn")
    private Collection<Rent> rentCollection;

    public Customer() {
    }

    public Customer(BigDecimal snn) {
        this.snn = snn;
    }

    public Customer(BigDecimal snn, String fname, String mname, String lname, String city, String stret) {
        this.snn = snn;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.city = city;
        this.stret = stret;
    }

    public BigDecimal getSnn() {
        return snn;
    }

    public void setSnn(BigDecimal snn) {
        this.snn = snn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getZipcode() {
        return zipcode;
    }

    public void setZipcode(BigInteger zipcode) {
        this.zipcode = zipcode;
    }

    public String getStret() {
        return stret;
    }

    public void setStret(String stret) {
        this.stret = stret;
    }

    @XmlTransient
    public Collection<BuyBook> getBuyBookCollection() {
        return buyBookCollection;
    }

    public void setBuyBookCollection(Collection<BuyBook> buyBookCollection) {
        this.buyBookCollection = buyBookCollection;
    }

    @XmlTransient
    public Collection<BuyStationery> getBuyStationeryCollection() {
        return buyStationeryCollection;
    }

    public void setBuyStationeryCollection(Collection<BuyStationery> buyStationeryCollection) {
        this.buyStationeryCollection = buyStationeryCollection;
    }

    @XmlTransient
    public Collection<BuySport> getBuySportCollection() {
        return buySportCollection;
    }

    public void setBuySportCollection(Collection<BuySport> buySportCollection) {
        this.buySportCollection = buySportCollection;
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
        hash += (snn != null ? snn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.snn == null && other.snn != null) || (this.snn != null && !this.snn.equals(other.snn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.Customer[ snn=" + snn + " ]";
    }
    
}
