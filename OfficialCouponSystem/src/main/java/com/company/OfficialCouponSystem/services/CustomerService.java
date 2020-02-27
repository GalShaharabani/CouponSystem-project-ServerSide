package com.company.OfficialCouponSystem.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.beans.Customer;
import com.company.OfficialCouponSystem.repositories.CouponRepository;
import com.company.OfficialCouponSystem.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private CouponRepository couponRepo;

	public void purchaseCoupon(long couponID, long customerID) throws Exception {
		Optional<Customer> customer = custRepo.findById(customerID);
		Optional<Coupon> coupon = couponRepo.findById(couponID);
			if (customer.get().getCoupons().contains(coupon.get())) {
				throw new Exception("customer already owns this coupon");
			} 
			else if (new Date().after(coupon.get().getEndDate())) {
				throw new Exception("this coupon has expired and no longer valid");
			}
			else if (coupon.get().getAmount() > 0){
				
				customer.get().getCoupons().add(coupon.get());
				custRepo.save(customer.get());
				coupon.get().setAmount(coupon.get().getAmount()-1);
				couponRepo.save(coupon.get());
			
		}
	}

	public List<Coupon> getCustomerCoupons(long id) {
		Optional<Customer> customer = custRepo.findById(id);
		return customer.get().getCoupons();
	}
	
	public List<Coupon> getCustomerCouponsByCategory(long id, String category){
		Optional<Customer> customer = custRepo.findById(id);
		ArrayList<Coupon> coupons=new ArrayList<>();
		for (Coupon coupon : customer.get().getCoupons()) {
			if (coupon.getCategory().name().equalsIgnoreCase(category)) {
				coupons.add(coupon);
			}
		}
		return coupons;
		 
	}
	
	public List<Coupon> getCustomerCouponsByPrice(long id, double price){
		Optional<Customer> customer = custRepo.findById(id);
		ArrayList<Coupon> coupons=new ArrayList<>();
		for (Coupon coupon : customer.get().getCoupons()) {
			if (coupon.getPrice()<=price) {
				coupons.add(coupon);
			}
		}
		return coupons;
	}
	
	public Optional<Customer> showCustomerDetails(long id) {
		return custRepo.findById(id);
	}

}
