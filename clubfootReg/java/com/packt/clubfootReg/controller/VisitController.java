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

import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.repository.VisitRepo;

@Controller
public class VisitController {

	@Autowired
	private VisitRepo visitRepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public String visitForm(Model model){
		Visit visit = new Visit();
		model.addAttribute("visit", visit);
		return "visit";
	}
	
	@RequestMapping(value = "/visit", method = RequestMethod.POST)
	public String visitSubmitForm(@ModelAttribute("visit") Visit visit, Model model){
		model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Visit Data Successfully Submitted");
        visitRepo.addVisit(visit);
		return "home";
	}
	
	public VisitController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
