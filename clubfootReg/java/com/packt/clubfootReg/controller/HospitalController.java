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

/**
 * 
 * @author David
 * This HospitalController class routes and synchronizes data based on the users choices. This controller contains
 * Two GET methods and One Post method. 
 */
// Controller class called HospitalController
@Controller
public class HospitalController {
	
	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private HospitalRepo hospitalRepo;	// An instantiation of the HospitalRepo class called hospitalRepo
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/hospital", method = RequestMethod.GET) // In this instance we receive the jsp view "hospital" and get command to view the page
	public String hospitalForm(Model model){
		Hospital hospital = new Hospital();	// An instantiation of the hospital class
		model.addAttribute("hospital", hospital);	// Adds the hospital object to the attribute called "hospital" in the model
		return "hospital";	// Returns the hospital view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/hospital", method = RequestMethod.POST) // In this instance we receive the jsp view "hospital" and post command to submit data to the database
	public String hospitalSubmitForm(@ModelAttribute("hospital") Hospital hospital, Model model){
        hospitalRepo.addHospital(hospital);	// hospitalRepo calls its method addHospital and passes the object hospital to it
        model.addAttribute("hospitals", hospitalRepo.getAllHospitals()); // Method call getAllHospitals receives all of the hospitals from the database and synchronizes to the attribute "hospitals" in the model
		return "view_hospitals";	// Returns view_hospitals view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/view_hospitals", method = RequestMethod.GET) // In this instance we receive the jsp view "view_hospitals" and get command to view the page
	public String viewHospitalsForm(Model model){
		model.addAttribute("hospitals", hospitalRepo.getAllHospitals()); // Method call getAllHospitals receives all of the hospitals from the database and synchronizes to the attribute "hospitals" in the model
		return "view_hospitals";	// Returns view_hospitals view
	}
	public HospitalController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
