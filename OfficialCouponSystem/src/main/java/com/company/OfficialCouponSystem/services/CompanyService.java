package com.company.OfficialCouponSystem.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.OfficialCouponSystem.beans.Company;
import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.beans.Customer;
import com.company.OfficialCouponSystem.repositories.CompanyRepository;
import com.company.OfficialCouponSystem.repositories.CouponRepository;
import com.company.OfficialCouponSystem.util.Category;
import com.company.OfficialCouponSystem.util.MyExceptions;

@Service
public class CompanyService {

	@Autowired
	private CouponRepository couponRepo;

	@Autowired
	private CompanyRepository comRepo;
	

	public void addCoupon(Coupon coupon) throws Exception {
		Optional<Company> company = comRepo.findById(coupon.getCompanyID());
		if (couponRepo.existsByCompanyID(coupon.getCompanyID())) {
			if (couponRepo.existsByTitle(coupon.getTitle())) {
				throw new Exception("cannot add coupon with the same title as: "+coupon.getTitle());
			} else {
				coupon.setCompanyID(company.get().getId());
				company.get().getCoupons().add(coupon);
				couponRepo.save(coupon);
				comRepo.save(company.get());
			
			}

		} else {
			coupon.setCompanyID(company.get().getId());
			company.get().getCoupons().add(coupon);
			couponRepo.save(coupon);
			comRepo.save(company.get());

		}
	}
	
	public void updateCoupon(Coupon coupon) throws Exception {
		Optional<Company> company = comRepo.findById(coupon.getCompanyID());
		if (couponRepo.existsById(coupon.getId())) {
			coupon.setCategory(coupon.getCategory());
			coupon.setTitle(coupon.getTitle());
			coupon.setDescription(coupon.getDescription());
			coupon.setStartDate(coupon.getStartDate());
			coupon.setEndDate(coupon.getEndDate());
			coupon.setAmount(coupon.getAmount());
			coupon.setPrice(coupon.getPrice());
			coupon.setImage(coupon.getImage());
		}else if (couponRepo.existsByTitle(coupon.getTitle())) {
			
			throw new Exception("coupon with this title: "+coupon.getTitle()+" already exists");
		}
		
		couponRepo.save(coupon);
		
	}

	public void deleteCoupon(long id) throws Exception {
		if (couponRepo.existsById(id)) {
			couponRepo.deleteById(id);
		}
		else {
			
			throw new Exception("coupon "+id+" doesn not exist");
		}
	}
	
	public List<Coupon> getCompanyCoupons(long id) {
		Optional<Company> company = comRepo.findById(id);
		return company.get().getCoupons();
	}
	
	public List<Coupon>getCompanyCouponsByCategory(Long id, Category category){
		Optional<Company> company = comRepo.findById(id);
		ArrayList<Coupon> coupons=new ArrayList<>();
		for (Coupon coupon : company.get().getCoupons()) {
			if (coupon.getCategory().equals(category)) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public List<Coupon> getCompanyCouponsByMaxPrice(Long id, double price){
		Optional<Company> company = comRepo.findById(id);
		ArrayList<Coupon> coupons=new ArrayList<>();
		for (Coupon coupon : company.get().getCoupons()) {
			if (coupon.getPrice()<=price) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public Optional<Company> showCompanyDetails(long id) {
		return comRepo.findById(id);
	}
	
}
