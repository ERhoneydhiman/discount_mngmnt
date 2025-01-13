package com.ex.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.main.entity.Discount;

@Repository
public interface DiscountRepo extends JpaRepository<Discount, Long>{

}
