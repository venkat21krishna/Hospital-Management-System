package com.spring.bioMedical.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.bioMedical.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	 User findByEmail(String email);
	
	 User findByConfirmationToken(String confirmationToken);
	 
	 User deleteById(int userId);
	 
	 List<User> findAll();
}