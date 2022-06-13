package com.sportyshoes.assembler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportyshoes.DTO.Products;
import com.sportyshoes.model.ProductsModel;
import org.springframework.stereotype.Service;

@Service
public class ProductAssembler {

    public ProductsModel dtoToModel(Products products){
        if(products == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(products, ProductsModel.class);
    }

    public Products modelToDTO(ProductsModel productsModel){
        if(productsModel == null){
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(productsModel, Products.class);
    }
}
