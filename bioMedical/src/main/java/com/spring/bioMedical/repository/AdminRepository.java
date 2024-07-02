package com.spring.bioMedical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bioMedical.entity.Admin;


@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByEmail(String user);

	Admin findById(int userId);
	
	void deleteById(int userId);
	
	List<Admin> findByRole(String user);
}

