/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findBySnn", query = "SELECT e FROM Employee e WHERE e.snn = :snn")
    , @NamedQuery(name = "Employee.findByFname", query = "SELECT e FROM Employee e WHERE e.fname = :fname")
    , @NamedQuery(name = "Employee.findByLname", query = "SELECT e FROM Employee e WHERE e.lname = :lname")
    , @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employee.findByCity", query = "SELECT e FROM Employee e WHERE e.city = :city")
    , @NamedQuery(name = "Employee.findByZipcode", query = "SELECT e FROM Employee e WHERE e.zipcode = :zipcode")
    , @NamedQuery(name = "Employee.findByStret", query = "SELECT e FROM Employee e WHERE e.stret = :stret")})
public class Employee implements Serializable {

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
    @Column(name = "LNAME")
    private String lname;
    @Basic(optional = false)
    @Column(name = "SALARY")
    private BigInteger salary;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ZIPCODE")
    private BigInteger zipcode;
    @Column(name = "STRET")
    private String stret;

    public Employee() {
    }

    public Employee(BigDecimal snn) {
        this.snn = snn;
    }

    public Employee(BigDecimal snn, String fname, String lname, BigInteger salary) {
        this.snn = snn;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (snn != null ? snn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.snn == null && other.snn != null) || (this.snn != null && !this.snn.equals(other.snn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database1.Employee[ snn=" + snn + " ]";
    }
    
}
