package com.company.OfficialCouponSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.OfficialCouponSystem.beans.Company;
import com.company.OfficialCouponSystem.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public Optional<Customer> findByEmail(String email);
	public boolean existsByEmail(String email);
	public boolean existsByPassword(String password);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public void save(Optional<Customer> customer);
	
}
