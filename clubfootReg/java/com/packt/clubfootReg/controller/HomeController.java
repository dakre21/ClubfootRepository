package com.packt.clubfootReg.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("greeting", "Welcome to the Clubfoot Registry");
		model.addAttribute("tagline", "This is a UIowa Project");
		model.addAttribute("newpatient");
		
		return "home";
	}
	
	@RequestMapping("/home")
	public String home1(Model model) {
		model.addAttribute("greeting", "Welcome to the Clubfoot Registry");
		model.addAttribute("tagline", "This is a UIowa Project");
		model.addAttribute("newpatient");
		
		return "home";
	}
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
