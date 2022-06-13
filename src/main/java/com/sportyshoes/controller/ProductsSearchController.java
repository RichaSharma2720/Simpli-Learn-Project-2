package com.sportyshoes.controller;

import java.util.List;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.service.ProductsSearchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportyshoes.DAO.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductsSearchController {

	@Autowired
	private ProductsSearchServices productsSearchServices;

	@GetMapping("/shoes")
	public List<Products> getAllShoes(){
        return productsSearchServices.getAllShoes();
	}


	@GetMapping("/shoes/ProductType/{ProductType}")
	public List<Products> getAllProductbyProductType(@PathVariable("ProductType") String productType){
        return productsSearchServices.getAllProductbyProductType(productType);
	}



}
