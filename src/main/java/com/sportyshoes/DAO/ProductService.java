package com.sportyshoes.DAO;

import java.util.List;

import com.sportyshoes.DTO.Products;

public interface ProductService {
	
	public Products createProducts(Products product);
	public Products updateProducts(Products product);
	public Products getProductsById(int id);
	public Products deleteProductById(int id);
	
	public List<Products> getAllProducts();
	public List<Products> getAllProductsByProductType(String ProductType);
	public List<Products> getAllProductByProductName(String ProductName);
	

}
