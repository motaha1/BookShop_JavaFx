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
@Table(name = "SPORTS_EQUIPMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportsEquipment.findAll", query = "SELECT s FROM SportsEquipment s")
    , @NamedQuery(name = "SportsEquipment.findBySportBarcode", query = "SELECT s FROM SportsEquipment s WHERE s.sportBarcode = :sportBarcode")
    , @NamedQuery(name = "SportsEquipment.findByName", query = "SELECT s FROM SportsEquipment s WHERE s.name = :name")
    , @NamedQuery(name = "SportsEquipment.findByPrice", query = "SELECT s FROM SportsEquipment s WHERE s.price = :price")})
public class SportsEquipment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SPORT_BARCODE")
    private BigDecimal sportBarcode;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private BigInteger price;
    @OneToMany(mappedBy = "sportBarcode")
    private Collection<BuySport> buySportCollection;

    public SportsEquipment() {
    }

    public SportsEquipment(BigDecimal sportBarcode) {
        this.sportBarcode = sportBarcode;
    }

    public SportsEquipment(BigDecimal sportBarcode, String name) {
        this.sportBarcode = sportBarcode;
        this.name = name;
    }

    public BigDecimal getSportBarcode() {
        return sportBarcode;
    }

    public void setSportBarcode(BigDecimal sportBarcode) {
        this.sportBarcode = sportBarcode;
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
    public Collection<BuySport> getBuySportCollection() {
        return buySportCollection;
    }

    public void setBuySportCollection(Collection<BuySport> buySportCollection) {
        this.buySportCollection = buySportCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sportBarcode != null ? sportBarcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SportsEquipment)) {
            return false;
        }
        SportsEquipment other = (SportsEquipment) object;
        if ((this.sportBarcode == null && other.sportBarcode != null) || (this.sportBarcode != null && !this.sportBarcode.equals(other.sportBarcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.SportsEquipment[ sportBarcode=" + sportBarcode + " ]";
    }
    
}
