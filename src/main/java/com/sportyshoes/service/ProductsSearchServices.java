package com.sportyshoes.service;

import com.sportyshoes.DAO.ProductService;
import com.sportyshoes.DAO.PurchaseReportService;
import com.sportyshoes.DTO.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsSearchServices {

    @Autowired
    private PurchaseReportService service;

    @Autowired
    private ProductService productService;

    public List<Products> getAllShoes() {
        return productService.getAllProducts();
    }

    public List<Products> getAllProductbyProductType(String productType) {
        return productService.getAllProductsByProductType(productType);
    }
}
