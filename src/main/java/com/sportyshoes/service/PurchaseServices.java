package com.sportyshoes.service;

import com.sportyshoes.DAO.PurchaseReportService;
import com.sportyshoes.DTO.PurchaseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServices {

    @Autowired
    private PurchaseReportService service;
    public PurchaseReport createPurchaseReport(PurchaseReport purchaseReport) {
        return service.createPurchaseReport(purchaseReport);
    }

    public PurchaseReport updatePurchaseReport(PurchaseReport purchaseReport) {
        return service.updatePurchaseReport(purchaseReport);
    }

    public PurchaseReport getPurchaseReportById(int id) {
        return service.getPurchaseReportById(id);
    }

    public void deletePurchaseReportById(int id) {
        service.deletePurchaseReportById(id);
    }

    public List<PurchaseReport> getAllPurchaseReports() {
        return service.getAllPurchaseReports();
    }

    public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportCategory(String purchaseReportCategory) {
        return service.getAllPurchaseReportsByPurchaseReportCategory(purchaseReportCategory);
    }

    public List<PurchaseReport> getAllPurchaseReportsByPurchaseReportDate(String purchaseReportDate) {
        return service.getAllPurchaseReportsByPurchaseReportDate(purchaseReportDate);
    }

    public List<PurchaseReport> getAllPurchaseReportsByUserId(Integer id) {
        return service.findByUserId(id);
    }

    public List<PurchaseReport> getAllPurchaseReportsByProductId(Integer id) {
        return service.findByProductId(id);
    }
}
