package com.ex.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@GetMapping
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("hello world!!!", HttpStatus.OK);
		
	}
	
}
