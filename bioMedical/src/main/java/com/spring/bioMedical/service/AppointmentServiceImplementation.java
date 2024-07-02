


package com.spring.bioMedical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.entity.User;
import com.spring.bioMedical.repository.AppointmentRepository;
import com.spring.bioMedical.repository.UserRepository;

@Service
public class AppointmentServiceImplementation {

    private AppointmentRepository appointmentRepository;
    private EmailService emailService;
    private UserRepository userRepository;

    // Inject dependencies
    @Autowired
    public AppointmentServiceImplementation(AppointmentRepository appointmentRepository, EmailService emailService, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    public List<Appointment> findByEmail(String email) {
        return appointmentRepository.findByEmail(email);
    }

    public void save(Appointment app) {
        // Save the appointment
        appointmentRepository.save(app);

        // Send appointment details to user email
        sendAppointmentEmail(app);
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

   
    public void deleteById(int userId) {
        appointmentRepository.deleteById(userId);
    }

	
	public Appointment findById(int userId){
		return appointmentRepository.findById(userId);
	}

    private void sendAppointmentEmail(Appointment appointment) {
        // Retrieve the user associated with the appointment
		System.out.println(appointment.getEmail());
        User user = userRepository.findByEmail(appointment.getEmail());
        if (user != null) {
            // Construct the email content
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(user.getEmail());
            email.setSubject("Appointment Confirmation");
            email.setText("Dear " + user.getFirstName() + ",\n\n"
                + "Your appointment has been confirmed with the following details:\n\n"
                + "Appointment ID: " + appointment.getId() + "\n"
                + "Date: " + appointment.getDate() + "\n"
                + "Time: " + appointment.getTime() + "\n"
                + "Thank you for choosing our service.\n\n"
                + "Best regards,\n"
                + "Your Hospital Team");

            // Send the email
            emailService.sendEmail(email);
        }
    }
}

