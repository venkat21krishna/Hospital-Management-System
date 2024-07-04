package com.spring.bioMedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.entity.User;
import com.spring.bioMedical.entity.Med;
import com.spring.bioMedical.repository.AppointmentRepository;
import com.spring.bioMedical.repository.MedicineRepository;
import com.spring.bioMedical.repository.UserRepository;



@Service
public class MedicineServiceImplementation {

    private AppointmentRepository appointmentRepository;
    private EmailService emailService;
    private UserRepository userRepository;
    private MedicineRepository medicineRepository;

    // Inject dependencies
    @Autowired
    public MedicineServiceImplementation(MedicineRepository medicineRepository, AppointmentRepository appointmentRepository, EmailService emailService, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.medicineRepository=medicineRepository;
    }

    

    public void save(Med app) {
        medicineRepository.save(app);
    }

    public List<Med> findAll() {
        return medicineRepository.findAll();
    }

   
    public void deleteById(int userId) {
        medicineRepository.deleteById(userId);
    }

	
	public Med findById(int userId){
		return medicineRepository.findById(userId);
	}

    
}

