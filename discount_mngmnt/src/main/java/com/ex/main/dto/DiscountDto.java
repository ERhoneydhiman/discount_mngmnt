package com.ex.main.dto;

import lombok.Data;
@Data
public class DiscountDto {
	
	    private String discountType;  
	    private Long discountValue;
	    private Boolean seasonalDiscountActive;

}
