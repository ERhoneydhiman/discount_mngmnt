package com.ex.main.dto;

import lombok.Data;

@Data
public class DiscountResDto {
	    private Long id;
	    private String discountType;
	    private Long discountValue;
	    private Boolean seasonalDiscountActive;
	    private Long finalPrice;
}
