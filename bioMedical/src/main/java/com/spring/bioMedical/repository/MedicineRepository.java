package com.spring.bioMedical.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.entity.Med;


@Repository("medicineRepository")
public interface MedicineRepository extends JpaRepository<Med, Integer> {
            Med findById(int apId);
            List<Med> findAll();

}