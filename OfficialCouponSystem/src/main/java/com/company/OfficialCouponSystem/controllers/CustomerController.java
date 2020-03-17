package com.company.OfficialCouponSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.OfficialCouponSystem.services.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@PutMapping("purchaseCoupon")
	public ResponseEntity<?> purchaseCoupon(@RequestParam(name = "coupon_id")long couponID,@RequestParam(name = "customer_id") long customerID) throws Exception{
		custService.purchaseCoupon(couponID, customerID);
		return new ResponseEntity<>("coupon purchased successfully",HttpStatus.OK);
	}
	
	@GetMapping("getCoupons")
	public ResponseEntity<?> getCustomerCoupons(@RequestParam(name = "customer_id") long id){
		return new ResponseEntity<>(custService.getCustomerCoupons(id),HttpStatus.OK);
	}
	
	@GetMapping("getCouponsByCategory")
	public ResponseEntity<?> getCustomerCouponsByCategory(@RequestParam(name = "customer_id") long id, @RequestParam(name = "category") String category){
		return new ResponseEntity<>(custService.getCustomerCouponsByCategory(id, category),HttpStatus.OK);
	}
	
	@GetMapping("getCouponsByPrice")
	public ResponseEntity<?> getCustomerCouponsByPrice(@RequestParam(name = "customer_id") long id, @RequestParam(name = "price") double price){
		return new ResponseEntity<>(custService.getCustomerCouponsByPrice(id, price),HttpStatus.OK);
	}
	
	@GetMapping("getDetails")
	public ResponseEntity<?> showCustomerDetails(@RequestParam(name = "customer_id") long id){
		return new ResponseEntity<>(custService.showCustomerDetails(id),HttpStatus.OK);
	}

}
