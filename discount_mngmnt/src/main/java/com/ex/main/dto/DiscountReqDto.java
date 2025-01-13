package com.ex.main.dto;

import lombok.Data;

@Data
public class DiscountReqDto {
	
	private String productId;
	private String discountType;
	private Long discountValue;
	private Boolean seasonalDiscountActive;	

}
