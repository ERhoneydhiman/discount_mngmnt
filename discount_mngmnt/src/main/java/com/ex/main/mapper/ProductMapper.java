package com.ex.main.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ex.main.dto.ProductReqDto;
import com.ex.main.dto.ProductResDto;
import com.ex.main.entity.Product;

@Component
public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public ProductResDto toDto(Product product) {
		return mapper.map(product, ProductResDto.class);
		
	}
	
	public Product toEntity(ProductReqDto req) {
		return mapper.map(req, Product.class);
	}

}
