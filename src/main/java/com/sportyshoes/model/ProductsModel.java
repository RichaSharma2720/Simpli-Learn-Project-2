package com.sportyshoes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserProducts")
public class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private Integer productid;

    @Column(name = "pname")
    private String productname;

    @Column(name = "ptype")
    private String producttype;

    @Column(name = "pquantity")
    private int productquantity;

    public ProductsModel() {
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public int getProductquantity() {
        return productquantity;
    }

    public void setProductquantity(int productquantity) {
        this.productquantity = productquantity;
    }
    
    public ProductsModel(String pType, int pQ, String pN) {
		super();
		this.producttype = pType;
		this.productquantity = pQ;
		this.productname= pN;
	}


}
