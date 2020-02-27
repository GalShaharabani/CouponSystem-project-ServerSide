package com.company.OfficialCouponSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.util.Category;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
	
	public boolean existsByCompanyID(long companyID);
	public boolean existsByTitle(String title);
	public List<Coupon> findByCategory(Category category);
	public List<Coupon> findByPriceLessThanEqual(double price);
}
