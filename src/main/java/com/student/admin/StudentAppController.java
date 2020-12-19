package com.student.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentAppController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration_form";
	}
	
	@PostMapping("/process_registration") 
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		
		return "registration_success";
	}
	
	@GetMapping("/list_users")
	public String viewStudentList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	
}
