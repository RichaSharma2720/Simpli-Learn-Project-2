package com.sportyshoes.model;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.DTO.User;

import javax.persistence.*;

@Entity
@Table(name="purchasereport")
public class PurchaseReportModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="purchasereportid")
	private Integer purchaseReportId;
	
	@Column(name="purchasereportcatagory")
	private String purchaseReportCategory;
	
	@Column(name="purchasereportdate")
	private String purchaseReportDate;



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


	public PurchaseReportModel() {
	}


}
