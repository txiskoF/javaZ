/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.zabalburu.pruebaejbjpa.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ichueca
 */
@Entity
@Table(name = "Suppliers")
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
    , @NamedQuery(name = "Supplier.findBySupplierID", query = "SELECT s FROM Supplier s WHERE s.supplierID = :supplierID")
    , @NamedQuery(name = "Supplier.findByCompanyName", query = "SELECT s FROM Supplier s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "Supplier.findByContactName", query = "SELECT s FROM Supplier s WHERE s.contactName = :contactName")
    , @NamedQuery(name = "Supplier.findByContactTitle", query = "SELECT s FROM Supplier s WHERE s.contactTitle = :contactTitle")
    , @NamedQuery(name = "Supplier.findByAddress", query = "SELECT s FROM Supplier s WHERE s.address = :address")
    , @NamedQuery(name = "Supplier.findByCity", query = "SELECT s FROM Supplier s WHERE s.city = :city")
    , @NamedQuery(name = "Supplier.findByRegion", query = "SELECT s FROM Supplier s WHERE s.region = :region")
    , @NamedQuery(name = "Supplier.findByPostalCode", query = "SELECT s FROM Supplier s WHERE s.postalCode = :postalCode")
    , @NamedQuery(name = "Supplier.findByCountry", query = "SELECT s FROM Supplier s WHERE s.country = :country")
    , @NamedQuery(name = "Supplier.findByPhone", query = "SELECT s FROM Supplier s WHERE s.phone = :phone")
    , @NamedQuery(name = "Supplier.findByFax", query = "SELECT s FROM Supplier s WHERE s.fax = :fax")
    , @NamedQuery(name = "Supplier.findByHomePage", query = "SELECT s FROM Supplier s WHERE s.homePage = :homePage")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SupplierID")
    private Integer supplierID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CompanyName")
    private String companyName;
    @Size(max = 30)
    @Column(name = "ContactName")
    private String contactName;
    @Size(max = 30)
    @Column(name = "ContactTitle")
    private String contactTitle;
    @Size(max = 60)
    @Column(name = "Address")
    private String address;
    @Size(max = 15)
    @Column(name = "City")
    private String city;
    @Size(max = 15)
    @Column(name = "Region")
    private String region;
    @Size(max = 10)
    @Column(name = "PostalCode")
    private String postalCode;
    @Size(max = 15)
    @Column(name = "Country")
    private String country;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 24)
    @Column(name = "Fax")
    private String fax;
    @Size(max = 1073741823)
    @Column(name = "HomePage")
    private String homePage;
    @OneToMany(mappedBy = "supplierID")
    private List<Product> productList;

    public Supplier() {
    }

    public Supplier(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Supplier(Integer supplierID, String companyName) {
        this.supplierID = supplierID;
        this.companyName = companyName;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierID != null ? supplierID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierID == null && other.supplierID != null) || (this.supplierID != null && !this.supplierID.equals(other.supplierID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.zabalburu.pruebaejbjpa.modelo.Supplier[ supplierID=" + supplierID + " ]";
    }
    
}
