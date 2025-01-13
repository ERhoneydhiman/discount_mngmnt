package com.ex.main.validation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ex.main.dto.DiscountReqDto;
import com.ex.main.exceptions.ValidationException;

@Aspect
@Component
public class DiscountValidation {

    @Before("execution(* com.ex.main.controller..*(..)) && args(discountReqDto, ..)")
    public void validateDiscountDto(JoinPoint joinPoint, DiscountReqDto discountReqDto) {
        if (discountReqDto == null) {
            throw new ValidationException("Discount request cannot be null.");
        }
        if (!StringUtils.hasText(discountReqDto.getProductId())) {
            throw new ValidationException("Product ID must not be empty.");
        }
        if (!StringUtils.hasText(discountReqDto.getDiscountType())) {
            throw new ValidationException("Discount Type must not be empty.");
        }
        if (discountReqDto.getDiscountValue() == null || discountReqDto.getDiscountValue() <= 0) {
            throw new ValidationException("Discount Value must be greater than 0.");
        }
        if (discountReqDto.getSeasonalDiscountActive() == null) {
            throw new ValidationException("Seasonal Discount Active flag is required.");
        }
    }
}

