package com.sportyshoes.DAO;

import java.util.List;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.DTO.User;
import org.springframework.data.jpa.repository.Query;


public interface PurchaseReportService {

	public PurchaseReport createPurchaseReport(PurchaseReport purchaseReport);
	public PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport);
	public PurchaseReport getPurchaseReportById(int id) ;
	public void deletePurchaseReportById(int id);

	public List<PurchaseReport> getAllPurchaseReports();
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportCategory(String PurchaseReportCategory);
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportDate(String PurchaseReportDate);


	public List<User> findByUserId();
	public List<Products> findByProductId();


}
