package com.company.OfficialCouponSystem.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.OfficialCouponSystem.beans.Company;
import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.beans.Customer;
import com.company.OfficialCouponSystem.repositories.CompanyRepository;
import com.company.OfficialCouponSystem.repositories.CustomerRepository;
import com.company.OfficialCouponSystem.util.CompanyRegister;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("/welcome")
public class HomeController {
	
	
	@Autowired
	private CompanyRepository comRepo;
	@Autowired
	private CustomerRepository custRepo;

	@GetMapping("/login")
	public ResponseEntity<?> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password,
			@RequestParam(name = "type") String type) {
		if (email.equals("gal@gmail.com")&&password.equals("1234")&&type.equalsIgnoreCase("admin")) {
			return new ResponseEntity<>("Welcome admin!",HttpStatus.OK);
		}else if (comRepo.existsByEmail(email) && comRepo.existsByPassword(password)&&type.equalsIgnoreCase("company")) {
			Optional<Company> company=comRepo.findByEmail(email);
			return new ResponseEntity<>("Welcome "+company.get().getName()+"!",HttpStatus.OK);
		}else if (custRepo.existsByEmail(email) && custRepo.existsByPassword(password)&&type.equalsIgnoreCase("customer")) {
			Optional<Customer> customer=custRepo.findByEmail(email);
			return new ResponseEntity<>("Welcome "+customer.get().getFirstName()+" "+customer.get().getLastName()+"!",HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("register/company")
	public ResponseEntity<?> companyRegister(@RequestBody Company company){
		if (!comRepo.existsByEmail(company.getEmail())||!comRepo.existsByName(company.getName())) {
//			Company newCompany = new Company();
//			newCompany.setName(company.getName());
//			newCompany.setEmail(company.getEmail());
//			newCompany.setPassword(company.getPassword());
			comRepo.save(company);
			return new ResponseEntity<>("Registration successfull",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("company with these credentials already exists", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("register/customer")
	private ResponseEntity<?> customerRegister(@RequestBody Customer customer){
		if (!custRepo.existsByEmail(customer.getEmail())) {
//			Customer customer = new Customer();
//			customer.setFirstName(firstName);
//			customer.setLastName(lastName);
//			customer.setEmail(email);
//			customer.setPassword(password);
			custRepo.save(customer);
			return new ResponseEntity<>("Registration successfull",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("customer with these credentials already exists", HttpStatus.NOT_FOUND);
		}
	}

//	@PostMapping("register")
//	public ResponseEntity<?> Register(@RequestParam(name = "type") String type) {
//		if (type.equalsIgnoreCase("company")) {
//			//companyRegister(name, email, password, type);
//		}
//		
//		
//	}
}
