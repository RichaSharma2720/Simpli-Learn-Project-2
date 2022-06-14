package com.sportyshoes.controller;

import com.sportyshoes.DAO.PurchaseReportService;
import com.sportyshoes.DTO.PurchaseReport;
import com.sportyshoes.service.PurchaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PurchaseReportCRUDController {

	@Autowired
	private PurchaseServices service;

	private MultiValueMap<String, String> errorMap;

	@PostMapping("/PurchaseReportModel/create")
	public PurchaseReport createPurchaseReport(@RequestBody PurchaseReport purchaseReport) {
		return service.createPurchaseReport(purchaseReport);
	}

	@PutMapping("/PurchaseReportModel/update")
	public PurchaseReport updatePurchaseReport(@RequestBody PurchaseReport purchaseReport) {
		return service.updatePurchaseReport(purchaseReport);
	}

	@GetMapping("/PurchaseReportModel/{id}")
	public ResponseEntity<PurchaseReport> getPurchaseReportById(@PathVariable int id) {
		return new ResponseEntity<>(service.getPurchaseReportById(id),HttpStatus.OK);
	}

	@DeleteMapping("/PurchaseReportModel/{id}")
	public void deletePurchaseReportById(@PathVariable int id) {
		service.deletePurchaseReportById(id);
	}

}
