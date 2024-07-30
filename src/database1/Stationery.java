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
@Table(name = "STATIONERY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stationery.findAll", query = "SELECT s FROM Stationery s")
    , @NamedQuery(name = "Stationery.findByStaBarcode", query = "SELECT s FROM Stationery s WHERE s.staBarcode = :staBarcode")
    , @NamedQuery(name = "Stationery.findByName", query = "SELECT s FROM Stationery s WHERE s.name = :name")
    , @NamedQuery(name = "Stationery.findByPrice", query = "SELECT s FROM Stationery s WHERE s.price = :price")})
public class Stationery implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "STA_BARCODE")
    private BigDecimal staBarcode;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigInteger price;
    @OneToMany(mappedBy = "stationeryBarcode")
    private Collection<BuyStationery> buyStationeryCollection;

    public Stationery() {
    }

    public Stationery(BigDecimal staBarcode) {
        this.staBarcode = staBarcode;
    }

    public Stationery(BigDecimal staBarcode, String name) {
        this.staBarcode = staBarcode;
        this.name = name;
    }

    public BigDecimal getStaBarcode() {
        return staBarcode;
    }

    public void setStaBarcode(BigDecimal staBarcode) {
        this.staBarcode = staBarcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<BuyStationery> getBuyStationeryCollection() {
        return buyStationeryCollection;
    }

    public void setBuyStationeryCollection(Collection<BuyStationery> buyStationeryCollection) {
        this.buyStationeryCollection = buyStationeryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staBarcode != null ? staBarcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stationery)) {
            return false;
        }
        Stationery other = (Stationery) object;
        if ((this.staBarcode == null && other.staBarcode != null) || (this.staBarcode != null && !this.staBarcode.equals(other.staBarcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.Stationery[ staBarcode=" + staBarcode + " ]";
    }
    
}
