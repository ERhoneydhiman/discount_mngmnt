package com.ex.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.main.entity.Discount;
import com.ex.main.repo.DiscountRepo;

@Repository
public class DiscountDao {
	
	@Autowired
	private DiscountRepo discountRepo;
	
	public Discount saveEntity(Discount discount) throws Exception{
		return discountRepo.save(discount);
	}

}
