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

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.repository.HospitalRepo;

@Controller
public class HospitalController {
	
	@Autowired
	private HospitalRepo hospitalRepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	@RequestMapping(value = "/hospital", method = RequestMethod.GET)
	public String hospitalForm(Model model){
		Hospital hospital = new Hospital();
		model.addAttribute("hospital", hospital);
		return "hospital";
	}
	
	@RequestMapping(value = "/hospital", method = RequestMethod.POST)
	public String hospitalSubmitForm(@ModelAttribute("hospital") Hospital hospital, Model model){
		model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Hospital Data Successfully Submitted");
        hospitalRepo.addHospital(hospital);
		return "home";
	}
	public HospitalController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
