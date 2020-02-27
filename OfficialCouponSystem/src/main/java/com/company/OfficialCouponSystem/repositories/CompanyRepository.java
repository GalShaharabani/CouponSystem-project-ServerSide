package com.company.OfficialCouponSystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.OfficialCouponSystem.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	public Optional<Company> findByEmail(String email);
	public String findByName(String name);
	public boolean existsByName(String name);
	public boolean existsByEmail(String email);
	public boolean existsByPassword(String password);
	public void save(Optional<Company> company);
}
