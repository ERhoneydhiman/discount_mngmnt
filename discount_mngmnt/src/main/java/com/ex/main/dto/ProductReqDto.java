package com.ex.main.dto;

import lombok.Data;

@Data
public class ProductReqDto {
	    
	    private String productId;
	    
	    private String name;

	    private Long price;

	    private Long quantity;

	    private DiscountDto discount;

}
