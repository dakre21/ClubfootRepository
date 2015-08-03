package edu.uiowa.icr.controllers;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author David
 * This Class contains the code for the LoginController which has three GET methods which gets "login" and "home"
 */
// LoginController class
@Controller
public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/login", method = RequestMethod.GET)  
	 public String login(Model model) {  
		Map m = model.asMap();
		String mStr = m.toString();
		System.out.println("THE MAP STRING FOR LOGIN: "+ mStr);
	   
	  return "login";  
	   
	 }  
	//@RequestMapping(value = "/login", method = RequestMethod.GET)	// Gets login view
	//public String login(){
	//	return "login";	// Returns login view
//	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)	// Gets loginfailed view
	public String loginerror(Model model){
		Map m = model.asMap();
		String mStr = m.toString();
		System.out.println("THE MAP STRING FOR LOGIN FAILURE: "+ mStr);
		model.addAttribute("error", "true");	// Adds the error message to the model 
		return "login";	// Returns login view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/logout", method = RequestMethod.GET)	// Gets logout view
	public String logout(Model model) {
		return "home";	// Returns the home view
	}

}
