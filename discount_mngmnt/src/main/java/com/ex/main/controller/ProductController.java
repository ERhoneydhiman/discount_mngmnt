package com.ex.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.main.dto.ProductResDto;
import com.ex.main.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	<------------------------------------------------------------------------>
	
	@GetMapping
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("hello world!!!", HttpStatus.OK);
		
	}
	
//	<------------------------------------------------------------------------>

	@GetMapping("/product/{productId}")
	public ResponseEntity<?> getByProductId(@PathVariable String productId) throws Exception{
		return new ResponseEntity<ProductResDto>(productService.getByProductId(productId) ,HttpStatus.OK);
	}
	
//	<------------------------------------------------------------------------>
	
}
