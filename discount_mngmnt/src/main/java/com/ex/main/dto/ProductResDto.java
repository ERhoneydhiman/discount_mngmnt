package com.ex.main.dto;

import lombok.Data;

@Data
public class ProductResDto {
	
	    private Long id;
	    private String productId;
	    private String name;
	    private Long price;
	    private Long quantity;
	    private DiscountResDto discount;

	    
	   

}
