package com.ex.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.main.dto.DiscountReqDto;
import com.ex.main.entity.Product;
import com.ex.main.service.DiscountService;

@RestController
@RequestMapping("/product")
public class DiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@PostMapping("/discount")
	public ResponseEntity<?> addDiscount(@RequestBody DiscountReqDto req) throws Exception{
		return new ResponseEntity<Product>(discountService.addDiscount(req), HttpStatus.OK);
	}

}
