package com.sportyshoes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Products {
    private Integer productid;
    private String productname;

    private String producttype;

    private int productquantity;

    public Products(String productname, String producttype, int productquantity) {
        this.productname = productname;
        this.producttype = producttype;
        this.productquantity = productquantity;
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

    @Override
    public String toString() {
        return "Products{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", producttype='" + producttype + '\'' +
                ", productquantity=" + productquantity +
                '}';
    }
}
