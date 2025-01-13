package com.ex.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.main.dao.ProductDao;
import com.ex.main.dto.ProductResDto;
import com.ex.main.entity.Product;
import com.ex.main.exceptions.ProductNotFound;
import com.ex.main.mapper.ProductMapper;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductMapper mapper;
	
//	<------------------------------------------------------------------------>

	public ProductResDto getByProductId(String productId) throws Exception {
		Product product = productDao.getByProductId(productId)
				.orElseThrow(() -> new ProductNotFound("this product with " + productId + " not available."));

		return mapper.toDto(product);
	}

//	<------------------------------------------------------------------------>

}
