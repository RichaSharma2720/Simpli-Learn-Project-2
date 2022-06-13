package com.sportyshoes.DTO;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

public class PurchaseReport {

    private Integer purchaseReportId;

    private String purchaseReportCategory;

    private String purchaseReportDate;

    private Products productid;

    private User userId;

    public Integer getPurchaseReportId() {
        return purchaseReportId;
    }

    public void setPurchaseReportId(Integer purchaseReportId) {
        this.purchaseReportId = purchaseReportId;
    }

    public String getPurchaseReportCategory() {
        return purchaseReportCategory;
    }

    public void setPurchaseReportCategory(String purchaseReportCategory) {
        this.purchaseReportCategory = purchaseReportCategory;
    }

    public String getPurchaseReportDate() {
        return purchaseReportDate;
    }

    public void setPurchaseReportDate(String purchaseReportDate) {
        this.purchaseReportDate = purchaseReportDate;
    }

    public Products getProductid() {
        return productid;
    }

    public void setProductid(Products productid) {
        this.productid = productid;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
