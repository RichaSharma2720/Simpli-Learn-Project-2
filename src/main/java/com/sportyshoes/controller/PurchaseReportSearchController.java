package com.sportyshoes.controller;

import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PurchaseReportSearchController {

	@Autowired
	private PurchaseServices service;

	@GetMapping("/PurchaseReportModel")
	public List<PurchaseReport> getAllPurchaseReports() {
		return service.getAllPurchaseReports();
	}

	@GetMapping("/PurchaseReportModel/PurchaseReportCategory/{PurchaseReportCategory}")
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportCategory(@PathVariable String PurchaseReportCategory) {
		return service.getAllPurchaseReportsByPurchaseReportCategory(PurchaseReportCategory);
	}

	@GetMapping("/PurchaseReportModel/PurchaseReportDate/{PurchaseReportDate}")
	public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportDate(@PathVariable String PurchaseReportDate) {
		return service.getAllPurchaseReportsByPurchaseReportDate(PurchaseReportDate);
	}


	@GetMapping("/PurchaseReportModel/PurchaseReportUser/")
	public List<PurchaseReport> getAllPurchaseReportsByUserID(@RequestParam Integer userid) {
		return service.getAllPurchaseReportsByUserId(userid);
	}

	@GetMapping("/PurchaseReportModel/PurchaseReportProduct/")
	public List<PurchaseReport> getAllPurchaseReportsByProductID(@RequestParam Integer productid) {
		return service.getAllPurchaseReportsByProductId(productid);
	}

}
