package com.company.OfficialCouponSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.OfficialCouponSystem.beans.Company;
import com.company.OfficialCouponSystem.beans.Coupon;
import com.company.OfficialCouponSystem.beans.Customer;
import com.company.OfficialCouponSystem.repositories.CompanyRepository;
import com.company.OfficialCouponSystem.repositories.CouponRepository;
import com.company.OfficialCouponSystem.repositories.CustomerRepository;

@Service
public class AdminService {

	@Autowired
	private CompanyRepository comRepo;

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private CouponRepository couponRepo;

	//private Company company;
	private Customer customer;

	public Company addCompany(Company company) throws Exception {
		//Optional<Coupon> coupon=couponRepo.existsByCompanyID(company.getId());
		if (comRepo.existsByEmail(company.getEmail())||
				comRepo.existsByName(company.getName())) {
			throw new Exception("company already exists");
		}
		return comRepo.save(company);
	}

	public void updateCompany(Company company) throws Exception {
		Optional<Company> companyCheck=comRepo.findById(company.getId());
		if (companyCheck.get().getEmail().equalsIgnoreCase(company.getEmail())) {
			throw new Exception("Email already exists");
			
		}
		companyCheck.get().setEmail(company.getEmail());
		companyCheck.get().setPassword(company.getPassword());
		companyCheck.get().setCoupons(company.getCoupons());
		comRepo.save(company);
		
	}

	/*
	 * public void updateCompany2(String email, String password) {
	 * company.setEmail(email); company.setPassword(password);
	 * comRepo.save(company); }
	 */

	public void deleteCompany(long id) throws Exception {
		Optional<Company> company=comRepo.findById(id);
		if (!company.isEmpty()) {
			for (Coupon coupon : company.get().getCoupons()) {
				couponRepo.delete(coupon);
			}
			comRepo.deleteById(id);
			return;
		}
		throw new Exception("Company doesn't exist");
	}

	public Optional<Company> getCompany(long id) {
		return comRepo.findById(id);
	}

	public List<Company> getAllCompanies() {
		return comRepo.findAll();
	}

	public Customer addCustomer(Customer customer) throws Exception {
//		if (custRepo.existsByEmail(customer.getEmail())) {
//			throw new Exception("customer already exists");
//		}
		return custRepo.save(customer);
	}

	public void updateCustomer(Customer customer) throws Exception {
		Optional<Customer> customerCheck=custRepo.findById(customer.getId());
		if (customerCheck.get().getEmail().equalsIgnoreCase(customer.getEmail())) {
			throw new Exception("Email already exists");
			
		}
		customerCheck.get().setEmail(customer.getEmail());
		customerCheck.get().setPassword(customer.getPassword());
		customerCheck.get().setCoupons(customer.getCoupons());
		custRepo.save(customer);
	}

	public void deleteCustomer(long id) throws Exception {
		Optional<Customer> customer=custRepo.findById(id);
		if (!customer.isEmpty()) {
			for (Coupon coupon : customer.get().getCoupons()) {
				couponRepo.delete(coupon);
			}
			custRepo.deleteById(id);
			return;
		}
		throw new Exception("Customer doesn't exist");
	}

	public Optional<Customer> getCustomer(long id) {
		return custRepo.findById(id);
	}

	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

}
