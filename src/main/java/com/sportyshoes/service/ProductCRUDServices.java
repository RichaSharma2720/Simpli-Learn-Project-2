package com.sportyshoes.service;

import com.sportyshoes.DAO.ProductService;
import com.sportyshoes.DTO.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCRUDServices {

    @Autowired
    private ProductService productService;

    public Products createShoesProduct(Products product) {
        Products products = productService.createProducts(product);
        return product;
    }
    public Products updateShoesProduct(Products product){
        Products products= productService.updateProducts(product);
        return product;
    }


//    public Products updateProducts(Products product) {
//        return productService.updateProducts(product);
//    }

    public Products getProductsById(int id) {
        return productService.getProductsById(id);
    }

    public Products deleteProductById(int id) {
        return productService.deleteProductById(id);
    }
}
