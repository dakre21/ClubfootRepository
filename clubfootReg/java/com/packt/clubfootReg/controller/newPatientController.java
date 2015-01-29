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

import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

@Controller
public class newPatientController {

	@Autowired
	private newPatientRepo newpatientrepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	@RequestMapping(value="/newpatient", method=RequestMethod.GET)
	public String patientForm(Model model) {
		newPatient newpatient = new newPatient();
		model.addAttribute("newpatient", newpatient);
		return "newpatient";
	}
	
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)
    public String newPatientSubmit(@ModelAttribute("newpatient") newPatient newpatient, Model model) {

        model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Patient Data Successfully Submitted");
        newpatientrepo.addPatient(newpatient);
        return "home";
    }
	
	public newPatientController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}