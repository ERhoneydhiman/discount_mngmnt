package com.ex.main.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.main.entity.Product;
import com.ex.main.repo.ProductRepo;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepo productRepo;

//	<------------------------------------------------------------------------>
	
	public Boolean checkByProductId(String id) throws Exception{
		return productRepo.existsByProductId(id);
	}
	
//	<------------------------------------------------------------------------>
	
	public Optional<Product> getByProductId(String productId) throws Exception{
		return productRepo.findByProductId(productId);
	}
	
//	<------------------------------------------------------------------------>
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

//	<------------------------------------------------------------------------>
}
