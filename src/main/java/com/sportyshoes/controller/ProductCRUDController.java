package com.sportyshoes.controller;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.service.ProductCRUDServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api")
public class ProductCRUDController {
	@Autowired
	private ProductCRUDServices productCRUDServices;
	
	@PostMapping("Add/shoes")
	public Products createShoesProduct(@RequestBody Products product) {
		return productCRUDServices.createShoesProduct(product);
	}

	@PutMapping("update/shoes")
	public Products updateShoesProduct(@RequestBody Products product){
		return productCRUDServices.updateShoesProduct(product);
	}
	@GetMapping("serach/shoes/{id}")
	public Products getProductsById(@PathVariable int id){
		return productCRUDServices.getProductsById(id);
	}

	@DeleteMapping("delete/shoes/{id}")
	public Products deleteProductById(@PathVariable int id) {
		return productCRUDServices.deleteProductById(id);
	}

	

}
