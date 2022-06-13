package com.sportyshoes.DAO.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sportyshoes.DTO.Products;
import com.sportyshoes.assembler.ProductAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sportyshoes.model.ProductsModel;
import com.sportyshoes.repository.ProductRepository;
import com.sportyshoes.DAO.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository repo;

	@Autowired
	private ProductAssembler productAssembler;

	@Override
	public Products createProducts(Products product) {
		ProductsModel productsModel = productAssembler.dtoToModel(product);
		ProductsModel save = repo.save(productsModel);
		return productAssembler.modelToDTO(save);
	}

	@Override
	public Products updateProducts(Products product) {
		ProductsModel productsModel= productAssembler.dtoToModel(product);
		ProductsModel save=repo.save(productsModel);
		return productAssembler.modelToDTO(save);

	}

	@Override
	public Products getProductsById(int id) {
		Optional<ProductsModel> productsModel = repo.findById(id);
//		return repo.findById(id).orElse(null);
		return productAssembler.modelToDTO(productsModel.get());
	}

	@Override
	public Products deleteProductById(int id) {
		Products products = getProductsById(id);
		repo.deleteById(id);
		return products;
	}

	@Override
	public List<Products> getAllProducts() {
		List<ProductsModel> repoAll = repo.findAll();

		return repoAll.stream()
				.map(s->productAssembler.modelToDTO(s))
				.collect(Collectors.toList());
	}

	@Override
	public List<Products> getAllProductsByProductType(String productType) {
		List<Products> allProducts = getAllProducts();

		List<Products> collect = allProducts.stream()
				.filter(s -> s.getProducttype().equals(productType))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<Products> getAllProductByProductName(String productName) {
		List<Products> allProducts = getAllProducts();

		List<Products> collect = allProducts.stream()
				.filter(s -> s.getProductname().equals(productName))
				.collect(Collectors.toList());
		return collect;
	}



}
