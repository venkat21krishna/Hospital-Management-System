package com.spring.bioMedical.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bioMedical.entity.Admin;
import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.entity.Med;
import com.spring.bioMedical.service.AdminServiceImplementation;
import com.spring.bioMedical.service.AppointmentServiceImplementation;
import com.spring.bioMedical.service.MedicineServiceImplementation;
import com.spring.bioMedical.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	

	private UserService userService;

	private AdminServiceImplementation adminServiceImplementation;
	
	private MedicineServiceImplementation medicineServiceImplementation;
	private AppointmentServiceImplementation appointmentServiceImplementation;

	

	
	@Autowired
	public AdminController(UserService userService,AdminServiceImplementation obj,
			AppointmentServiceImplementation app, MedicineServiceImplementation meds) {
		this.userService = userService;
		adminServiceImplementation=obj;
		appointmentServiceImplementation=app;
		medicineServiceImplementation=meds;
	}
	
	
	@RequestMapping("/user-details")
	public String index(Model model){
		
		
		List<Admin> list=adminServiceImplementation.findByRole("ROLE_USER");
		model.addAttribute("user", list);
		
		
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
		
		
		
		return "admin/user";
	}
	
	@RequestMapping("/doctor-details")
	public String doctorDetails(Model model){
		
		
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
		
		
		
		List<Admin> list=adminServiceImplementation.findByRole("ROLE_DOCTOR");
		
		
		
		// add to the spring model
		model.addAttribute("user", list);
		
		
		return "admin/doctor";
	}
	
	@RequestMapping("/admin-details")
	public String adminDetails(Model model){
		
		
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
		
		
		         
		List<Admin> list=adminServiceImplementation.findByRole("ROLE_ADMIN");
		
		
		
		// add to the spring model
		model.addAttribute("user", list);
		
		
		return "admin/admin";
	}
	@GetMapping("/add-medicine")
	public String showMedicineAdd(Model theModel) {
		
		
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
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  
		    
		         String log=now.toString();
		    
		         admin1.setLastseen(log);
		         
		         adminServiceImplementation.save(admin1);
		
		
		// create model attribute to bind form data
		Med meds = new Med();
		
		theModel.addAttribute("meds", meds);
		
		return "admin/addMedicine";
	}
	

	@PostMapping("/save-medicine")
	public String saveMedicine(@ModelAttribute("meds") Med med) {

		medicineServiceImplementation.save(med);

		return "redirect:/admin/get-medicine";
	}


	@GetMapping("/add-doctor")
	public String showFormForAdd(Model theModel) {
		
		
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
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
				 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    Date now = new Date();  		    
		         String log=now.toString();		    
		         admin1.setLastseen(log);		         
		         adminServiceImplementation.save(admin1);
		Admin admin = new Admin();
		
		theModel.addAttribute("doctor", admin);
		
		return "admin/addDoctor";
	}
	
	
	@PostMapping("/save-doctor")
	public String saveEmployee(@ModelAttribute("doctor") Admin admin) {
		
		
		admin.setRole("ROLE_DOCTOR");
		
		admin.setPassword("default");
		
		admin.setEnabled(true);
		
		admin.setConfirmationToken("ByAdmin-Panel");
		
		System.out.println(admin);
		
		adminServiceImplementation.save(admin);
		
		
		return "redirect:/admin/doctor-details";
	}
	
	

	@GetMapping("/add-admin")
	public String showForm(Model theModel) {
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		  	String Pass = ((UserDetails)principal).getPassword();
		  	// System.out.println("One + "+username+"   "+Pass);
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
				 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date now = new Date();  
		
		String log=now.toString();

		admin1.setLastseen(log);
		
		adminServiceImplementation.save(admin1);
	
		Admin admin = new Admin();
		
		theModel.addAttribute("doctor", admin);
		
		return "admin/addAdmin";
	}
	
	
	@PostMapping("/save-admin")
	public String saveEmploye(@ModelAttribute("doctor") Admin admin) {
		
		admin.setRole("ROLE_ADMIN");
		
		admin.setPassword("default");
		
		admin.setEnabled(true);
		
		admin.setConfirmationToken("ByAdmin-Panel");
		
		System.out.println(admin);
		
		adminServiceImplementation.save(admin);
		
		return "redirect:/admin/user-details";
	}

	@GetMapping("/add-user")
	public String showuserForm(Model theModel) {
		String username="";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		  	String Pass = ((UserDetails)principal).getPassword();
		  	// System.out.println("One + "+username+"   "+Pass);
		} else {
		 username = principal.toString();
		  System.out.println("Two + "+username);
		}
		
		Admin admin1 = adminServiceImplementation.findByEmail(username);
				 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date now = new Date();  
		
		String log=now.toString();

		admin1.setLastseen(log);
		
		adminServiceImplementation.save(admin1);
	
		Admin admin = new Admin();
		
		theModel.addAttribute("doctor", admin);
		
		return "admin/addUser";
	}
	
	
	@PostMapping("/save-user")
	public String saveEmploy(@ModelAttribute("doctor") Admin admin) {
		
		admin.setRole("ROLE_USER");
		
		admin.setPassword("default");
		
		admin.setEnabled(true);
		
		admin.setConfirmationToken("ByAdmin-Panel");
		
		System.out.println(admin);
		
		adminServiceImplementation.save(admin);
		
		return "redirect:/admin/user-details";
	}

	@GetMapping("/edit-my-profile")
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
		
		return "admin/updateMyProfile";
	}
			
	
	@PostMapping("/update")
	public String update(@ModelAttribute("profile") Admin admin) {
		
		adminServiceImplementation.save(admin);
		return "redirect:/admin/user-details";
	}
	
	
	@RequestMapping("/appointments")
	public String appointments(Model model){
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
		List<Appointment> list=appointmentServiceImplementation.findAll();
		model.addAttribute("app", list);
		
		
		return "admin/appointment";
	}

	@RequestMapping("/get-medicine")
	public String mediciness(Model model){
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
			
		List<Med> list=medicineServiceImplementation.findAll();
		model.addAttribute("meds", list);
		
		
		return "admin/medDetails";
	}


	@DeleteMapping("/deleting/{userId}")
    public String deleteUser(@PathVariable("userId") int userId, RedirectAttributes redirectAttributes) {
        Admin user = adminServiceImplementation.findById(userId);
        if (user != null) {
            adminServiceImplementation.deleteById(userId);			
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Deletion failed.");
        }
		if(user != null && "ROLE_ADMIN".equals(user.getRole())){
			redirectAttributes.addFlashAttribute("successMessage", "Admin deleted successfully.");
			return "redirect:/admin/admin-details";
		}
		else if( user != null && "ROLE_DOCTOR".equals(user.getRole())){
			redirectAttributes.addFlashAttribute("successMessage", "Doctor deleted successfully.");
			return "redirect:/admin/doctor-details";
		}
		else if(user != null && "ROLE_USER".equals(user.getRole())){
			redirectAttributes.addFlashAttribute("successMessage", "User deleted successfully.");
		}
        return "redirect:/admin/user-details";
    }

	@DeleteMapping("/meddeleting/{medId}")
	public String deleteMed(@PathVariable("medId") int apId, RedirectAttributes redirectAttributes){
		Med apps=medicineServiceImplementation.findById(apId);
		if(apps!=null){
			medicineServiceImplementation.deleteById(apId);
			redirectAttributes.addFlashAttribute("successMessage", "Medicine deleted successfully.");
		}
		else{
            redirectAttributes.addFlashAttribute("errorMessage", "Medicine Deletion failed.");
		}
		return "redirect:/admin/get-medicine";
	}

	@DeleteMapping("/delete-app/{appointId}")
	public String deleteApp(@PathVariable("appointId") int apId, RedirectAttributes redirectAttributes){
		Appointment apps=appointmentServiceImplementation.findById(apId);
		if(apps!=null){
			appointmentServiceImplementation.deleteById(apId);
			redirectAttributes.addFlashAttribute("successMessage", "Appointment deleted successfully.");
		}
		else{
            redirectAttributes.addFlashAttribute("errorMessage", "Deletion failed.");
		}
		return "redirect:/admin/appointment";
	}

	@GetMapping("/update-med/{medId}")
    public String showmedUpdateForm(@PathVariable("medId") int appoId, Model model) {
        Med appo =medicineServiceImplementation.findById(appoId);
        if (appo != null) {
            model.addAttribute("appo", appo);
            return "updatemed";
        }
        return "redirect:/admin/medDetails";
    }

	@PostMapping("update-med")
    public String updatemedUser(@ModelAttribute("appo") Med appoint, RedirectAttributes redirectAttributes) {
        Med existingAppointment = medicineServiceImplementation.findById(appoint.getId());
        if (existingAppointment != null) {
			    existingAppointment.setName(appoint.getName());
			    existingAppointment.setExp(appoint.getExp());
			    existingAppointment.setReg(appoint.getReg());
			    existingAppointment.setCount(appoint.getCount());
				medicineServiceImplementation.save(existingAppointment);
            	redirectAttributes.addFlashAttribute("successMessage", "Medicine by admin updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Medicine by admin update failed.");
        }
        return "redirect:/admin/get-medicine";
    }

	@GetMapping("/update-app/{appoId}")
    public String showappUpdateForm(@PathVariable("appoId") int appoId, Model model) {
        Appointment appo =appointmentServiceImplementation.findById(appoId);
        if (appo != null) {
            model.addAttribute("appo", appo);
            return "updateappo";
        }
        return "redirect:/admin/appointment";
    }

	@PostMapping("update-app")
    public String updateappUser(@ModelAttribute("appo") Appointment appoint, RedirectAttributes redirectAttributes) {
        Appointment existingAppointment = appointmentServiceImplementation.findById(appoint.getId());
        if (existingAppointment != null) {
			    existingAppointment.setName(appoint.getName());
			    existingAppointment.setEmail(appoint.getEmail());
			    existingAppointment.setDate(appoint.getDate());
			    existingAppointment.setTime(appoint.getTime());
				existingAppointment.setGender(appoint.getGender());
				existingAppointment.setAge(appoint.getAge());
				existingAppointment.setPhone(appoint.getPhone());
				Date now = new Date();  
				String log=now.toString();
				
				existingAppointment.setRegtime(appoint.getRegtime());
				appointmentServiceImplementation.save(existingAppointment);
            	redirectAttributes.addFlashAttribute("successMessage", "Appointment by admin updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Appointment by admin update failed.");
        }
        return "redirect:/admin/appointments";
    }

	@GetMapping("/update-doc/{docId}")
    public String showdocUpdateForm(@PathVariable("docId") int docId, Model model) {
        Admin users =adminServiceImplementation.findById(docId);
        if (users != null) {
            model.addAttribute("users", users);
            return "updatedoc";
        }
        return "redirect:/admin/doctor";
    }

	@PostMapping("/update-doc")
    public String updateDoc(@ModelAttribute("users") Admin updatedUser, RedirectAttributes redirectAttributes) {
		
        Admin existingUsers = adminServiceImplementation.findById(updatedUser.getId());
        if (existingUsers != null) {
			    existingUsers.setFirstName(updatedUser.getFirstName());
			    existingUsers.setLastName(updatedUser.getLastName());
			    existingUsers.setEmail(updatedUser.getEmail());
			    existingUsers.setGender(updatedUser.getGender());
			    existingUsers.setRole(updatedUser.getRole());
				adminServiceImplementation.save(existingUsers);
            redirectAttributes.addFlashAttribute("successMessage", "Doctor updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Doctor update failed.");
			
        }
        return "redirect:/admin/doctor-details";
    }

	@GetMapping("/update-user/{userId}")
    public String showUpdateForm(@PathVariable("userId") int userId, Model model) {
        Admin user = adminServiceImplementation.findById(userId);
        if (user != null) {
            model.addAttribute("user", user);
            return "updateuser";
        }
        return "redirect:/admin/user-details";
    }

    @PostMapping("update-user")
    public String updateUser(@ModelAttribute("user") Admin updatedUser, RedirectAttributes redirectAttributes) {
		// int ids=updatedUser.getId();
        Admin existingUser = adminServiceImplementation.findById(updatedUser.getId());
        if (existingUser != null) {
			    existingUser.setFirstName(updatedUser.getFirstName());
			    existingUser.setLastName(updatedUser.getLastName());
			    existingUser.setEmail(updatedUser.getEmail());
			    existingUser.setGender(updatedUser.getGender());
			    existingUser.setRole(updatedUser.getRole());
				adminServiceImplementation.save(existingUser);
            redirectAttributes.addFlashAttribute("successMessage", "User updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "User update failed.");
			
        }
		// adminServiceImplementation.save(updatedUser);
        return "redirect:/admin/user-details";
    }

	
}
