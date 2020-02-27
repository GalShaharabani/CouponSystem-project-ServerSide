package com.company.OfficialCouponSystem.controllers;

import java.util.Optional;

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
import com.company.OfficialCouponSystem.beans.Customer;
import com.company.OfficialCouponSystem.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("addCompany")
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws Exception {
		
		return new ResponseEntity<>(adminService.addCompany(company),HttpStatus.OK);

	}

	@PostMapping("addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws Exception {
		return new ResponseEntity<Customer>(adminService.addCustomer(customer), HttpStatus.OK);
	}

	@GetMapping("getCompany")
	public Optional<Company> getCompany(@RequestParam(name = "id") String id) {
		return adminService.getCompany(Long.parseLong(id));
	}

	@GetMapping("getCustomer")
	public Optional<Customer> getCustomer(@RequestParam(name = "id") String id) {
		return adminService.getCustomer(Long.parseLong(id));
	}

	@DeleteMapping("deleteCompany")
	public ResponseEntity<?>deleteCustomer(@RequestParam(name = "id")String id) throws NumberFormatException, Exception{
		adminService.deleteCompany(Long.parseLong(id));
		return new ResponseEntity<>("company deleted",HttpStatus.OK);
	}
	
	@PutMapping("updateCompany")
	public ResponseEntity<?>updateCompany(@RequestBody Company company) throws Exception{
		adminService.updateCompany(company);
		return new ResponseEntity<>("Company updated",HttpStatus.OK);
	}
}
