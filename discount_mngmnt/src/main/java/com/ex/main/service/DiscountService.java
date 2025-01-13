package com.ex.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.main.dao.DiscountDao;
import com.ex.main.dao.ProductDao;
import com.ex.main.dto.DiscountReqDto;
import com.ex.main.entity.Discount;
import com.ex.main.entity.Product;
import com.ex.main.exceptions.DiscountTypeNotAvailable;
import com.ex.main.exceptions.ProductOutOfStock;

import jakarta.transaction.Transactional;

@Service
public class DiscountService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private DiscountDao discountDao;

//	<------------------------------------------------------------------------>

	public Long calculateFinalPrice(String discountType, Long discountValue, Boolean seasonalDiscountActive,
			Long productPrice) throws Exception {

		double finalPrice = productPrice;

		if (seasonalDiscountActive) {
			finalPrice -= productPrice * 0.25;
		}

		switch (discountType.toLowerCase()) {
		case "flat":
			finalPrice -= discountValue;
			break;
		case "percentage":
			finalPrice -= productPrice * (discountValue / 100.0);
			break;
		default:
			throw new DiscountTypeNotAvailable("Discount should be 'flat' or 'percentage'.");
		}

		if (finalPrice <= 0) {
			finalPrice = 0;
		}

		return Math.round(finalPrice);

	}

//	<------------------------------------------------------------------------>

	@Transactional
	public Product addDiscount(DiscountReqDto req) throws Exception {

		Product product = productDao.getByProductId(req.getProductId())
				.orElseThrow(() -> new ProductOutOfStock("This product is not available..."));

		if (product.getQuantity() <= 0) {
			throw new ProductOutOfStock("this product is out of stock...");
		}

		Discount discount = product.getDiscount();
		if (discount == null) {
			discount = new Discount();
		}

		Long finalPrice = calculateFinalPrice(req.getDiscountType(), req.getDiscountValue(),
				req.getSeasonalDiscountActive(), product.getOriginalPrice());

		discount.setDiscountType(req.getDiscountType());
		discount.setDiscountValue(req.getDiscountValue());
		discount.setFinalPrice(finalPrice);
		discount.setSeasonalDiscountActive(req.getSeasonalDiscountActive());

		Discount savedDiscount = discountDao.saveEntity(discount);
		product.setDiscount(savedDiscount);

		productDao.saveProduct(product);

		return product;
	}

//	<------------------------------------------------------------------------>

}
