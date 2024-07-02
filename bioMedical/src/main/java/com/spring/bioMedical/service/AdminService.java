package com.spring.bioMedical.service;

import java.util.List;

import com.spring.bioMedical.entity.Admin;

public interface AdminService {


	public List<Admin> findByRole(String user);

	public Admin findByEmail(String user);

	public Admin findById(int userId);
	
	public List<Admin> findAll();

	public void save(Admin admin);

	public void deleteById(int userId);
	
}
