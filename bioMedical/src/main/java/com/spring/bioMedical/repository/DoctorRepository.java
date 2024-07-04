package com.spring.bioMedical.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.bioMedical.entity.Doctor;

@Repository("doctorRepository")
public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
	
	
	 Doctor findBySpecialist(String specialist);
}
