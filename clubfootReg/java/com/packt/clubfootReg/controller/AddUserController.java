package com.packt.clubfootReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.clubfootReg.domain.User;
import com.packt.clubfootReg.domain.repository.UserRepo;

@Controller
public class AddUserController {

	@Autowired
	private UserRepo userRepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String userForm(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "adduser";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String userSubmitForm(@ModelAttribute("user") User user, Model model){
		userRepo.addUser(user);
		model.addAttribute("users", userRepo.getAllUsers());
		return "view_users";
	}
	
	@RequestMapping(value = "/view_users", method = RequestMethod.GET)
	public String viewUsersForm(Model model){
		model.addAttribute("users", userRepo.getAllUsers());
		return "view_users";
	}
	
	public AddUserController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
