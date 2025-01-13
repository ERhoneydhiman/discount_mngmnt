package com.ex.main.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.main.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	
	Boolean existsByProductId(String productId);
	
	Optional<Product> findByProductId(String productId);
}
