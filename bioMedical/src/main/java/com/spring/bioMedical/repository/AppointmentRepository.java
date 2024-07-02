package com.spring.bioMedical.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bioMedical.entity.Appointment;


@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
            List<Appointment> findByEmail(String email);
            Appointment findById(int apId);
            void deleteById(int apId);

}