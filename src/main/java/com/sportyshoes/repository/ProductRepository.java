package com.sportyshoes.repository;

import java.util.List;

import com.sportyshoes.model.ProductsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsModel, Integer> {

}
