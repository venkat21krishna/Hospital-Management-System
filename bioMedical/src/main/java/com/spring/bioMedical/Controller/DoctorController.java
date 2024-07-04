package com.spring.bioMedical.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bioMedical.entity.Admin;
import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.service.AdminServiceImplementation;
import com.spring.bioMedical.service.AppointmentServiceImplementation;
import com.spring.bioMedical.service.UserService;


@Controller
@RequestMapping("/doctor")
public class DoctorController {

	private UserService userService;

	private AdminServiceImplementation adminServiceImplementation;
	
	private AppointmentServiceImplementation appointmentServiceImplementation;

	
	@Autowired
	public DoctorController(UserService userService,AdminServiceImplementation obj,
			AppointmentServiceImplementation app) {
		this.userService = userService;
		adminServiceImplementation=obj;
		appointmentServiceImplementation=app;
	}
	
	
	@RequestMapping("/index")
	public String index(Model model){

	
		
		// get last seen
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		  
		  
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		Admin admin = adminServiceImplementation.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin.setLastseen(log);
		         
		         adminServiceImplementation.save(admin);
		
		// String temp="nani@gmail.com";
		         
		List<Appointment> list=appointmentServiceImplementation.findAll();
		
		model.addAttribute("name",admin.getFirstName());
		
		model.addAttribute("email",admin.getEmail());
		
		
		model.addAttribute("user",admin.getFirstName()+" "+admin.getLastName());
		
		// add to the spring model
		model.addAttribute("app", list);
		
		return "doctor/index";
	}

	@GetMapping("/update-app/{appoId}")
    public String showappUpdateForm(@PathVariable("appoId") int appoId, Model model) {
        Appointment appo =appointmentServiceImplementation.findById(appoId);
        if (appo != null) {
            model.addAttribute("appo", appo);
            return "doctorupdateapp";
        }
        return "redirect:/doctor/index";
    }

	@PostMapping("update-app")
    public String updateappUser(@ModelAttribute("appo") Appointment appoint, RedirectAttributes redirectAttributes) {
        Appointment existingAppointment2 = appointmentServiceImplementation.findById(appoint.getId());
        if (existingAppointment2 != null) {
			    existingAppointment2.setName(appoint.getName());
			    existingAppointment2.setEmail(appoint.getEmail());
			    existingAppointment2.setDate(appoint.getDate());
			    existingAppointment2.setTime(appoint.getTime());
				Date now = new Date();  
				String log=now.toString();
				
				existingAppointment2.setRegtime(appoint.getRegtime());
				existingAppointment2.setDoctorDesc(appoint.getDoctorDesc());
				appointmentServiceImplementation.save(existingAppointment2);
            	redirectAttributes.addFlashAttribute("successMessage", "Doctor description updated successfully.");
            	// redirectAttributes.addFlashAttribute("appointmentId",appoint.getId());	
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Doctor desc update failed.");
			// redirectAttributes.addFlashAttribute("appointmentId",appoint.getId());	

        }
        return "redirect:/doctor/index";
    }	

	@GetMapping("/edit-doc-profile")
	public String EditForm(Model theModel) {
		
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		  String Pass = ((UserDetails)principal).getPassword();
		  System.out.println("One + "+username+"   "+Pass);
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}	
		
		
		
		Admin admin = adminServiceImplementation.findByEmail(username);
				 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date now = new Date();  
		    
		String log=now.toString();
		    
		admin.setLastseen(log);
		         
		adminServiceImplementation.save(admin);
		
		// System.out.println(admin);
		
		theModel.addAttribute("profile", admin);
		
		return "doctor/updateMyProfile";
	}
			
	
	@PostMapping("/update")
	public String update(@ModelAttribute("profile") Admin admin) {
		
		
		System.out.println(admin);
		
		adminServiceImplementation.save(admin);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/doctor/index";
	}
}
