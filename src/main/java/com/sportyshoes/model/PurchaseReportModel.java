package com.sportyshoes.model;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.DTO.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="purchasereport")
public class PurchaseReportModel {
	@Id
	@Column(name = "purchasereportid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseReportId;
	
	@Column(name="purchasereportcatagory")
	private String purchaseReportCategory;
	
	@Column(name="purchasereportdate")
	private String purchaseReportDate;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private UserModel userId;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "productid")
	private ProductsModel productid;

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

	public UserModel getUserId() {
		return userId;
	}

	public void setUserId(UserModel userId) {
		this.userId = userId;
	}

	public ProductsModel getProductid() {
		return productid;
	}

	public void setProductid(ProductsModel productid) {
		this.productid = productid;
	}
}
