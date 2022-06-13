package com.sportyshoes.repository;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.DTO.User;
import com.sportyshoes.model.PurchaseReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface PurchaseReportRepository extends JpaRepository<PurchaseReportModel, Integer> {
    List<PurchaseReportModel> findByPurchaseReportCategoryEqualsIgnoreCase(String purchaseReportCategory);

    List<PurchaseReportModel> findByPurchaseReportDateEquals(String purchaseReportDate);

    List<PurchaseReportModel> findByUserId_IdEquals(Integer id);

    List<PurchaseReportModel> findByProductid_ProductidEquals(Integer productid);

//	@Query("SELECT * FROM PurchaseReportModel pr INNER JOIN pr.user us")
//	public List<User> findByUserId();
//
//	@Query("SELECT pd FROM PurchaseReportModel pr INNER JOIN pr.product pd")
//	public List<Products> findByProductId();
//
//
//	@Query("SELECT * FROM PurchaseReportModel pr where pr.purchasereportcatagory =:purchasereportcatagory")
//	public List<PurchaseReportModel> findByPurchaseReportCategory(@Param("purchasereportcatagory") String purchasereportcatagory);
//
//	@Query("SELECT * FROM PurchaseReportModel pr where pr.purchasereportdate =:purchasereportdate")
//	public List<PurchaseReport> findByPurchaseReportDate(@Param("purchasereportdate") String purchasereportdate);
}
