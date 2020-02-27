package com.company.OfficialCouponSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.OfficialCouponSystem.beans.Company;
import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.services.CompanyService;
import com.company.OfficialCouponSystem.util.Category;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService comService;
	private Company company;
	
	@PostMapping("addCoupon")
	public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon) throws Exception{
		//coupon.setCompanyID(company.getId());
		comService.addCoupon(coupon);
		return new ResponseEntity<>("coupon added", HttpStatus.OK);
	}
	
	@PutMapping("updateCoupon")
	public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon) throws Exception{
		comService.updateCoupon(coupon);
		return new ResponseEntity<>("coupon updated", HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCoupon")
	public ResponseEntity<?>deleteCoupon(@RequestParam(name = "id") long id) throws Exception{
		
		comService.deleteCoupon(id);
		return new ResponseEntity<>("coupon deleted", HttpStatus.OK);
	}
	
	@GetMapping("getAllCoupons")
	public ResponseEntity<?> getAllCoupons(@RequestParam (name = "id")long id){
		return new ResponseEntity<>(comService.getCompanyCoupons(id), HttpStatus.OK);
	}
	
	@GetMapping("getCouponsByCategory")
	public ResponseEntity<?> getCouponsByCategory(@RequestParam(name = "id") long id, @RequestParam(name = "category")Category category){
		return new ResponseEntity<>(comService.getCompanyCouponsByCategory(id, category), HttpStatus.OK);
	}
	
	@GetMapping("getCouponsByMaxPrice")
	public ResponseEntity<?> getCouponsByPrice(@RequestParam(name = "id") long id, @RequestParam(name = "price")double price){
		return new ResponseEntity<>(comService.getCompanyCouponsByMaxPrice(id, price),HttpStatus.OK);
	}
	
	@GetMapping("showCompanyDetails")
	public ResponseEntity<?>showCompanyDetails(@RequestParam(name = "id")long id ){
		return new ResponseEntity<>(comService.showCompanyDetails(id), HttpStatus.OK);
	}
}
