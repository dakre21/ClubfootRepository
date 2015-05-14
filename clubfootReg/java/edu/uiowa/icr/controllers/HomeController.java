package edu.uiowa.icr.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author David
 * This the home controller where the user initially gets routed, and where the user can view the main home page
 */

// Home Controller class
@Controller
public class HomeController {

	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping("/")
	public String home(Model model) {
		// Strings being saved to the model
		model.addAttribute("greeting", "Welcome to the Clubfoot Registry");
		model.addAttribute("tagline", "This is a UIowa Project");
		model.addAttribute("newpatient");
		
		return "home";	// Returns the home jsp view 
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping("/home")
	public String home1(Model model) {
		model.addAttribute("greeting", "Welcome to the Clubfoot Registry");
		model.addAttribute("tagline", "This is a UIowa Project");
		model.addAttribute("newpatient");
		
		return "home";	// Returns the home jsp view
	}
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
