package com.packt.clubfootReg.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.repository.HospitalRepo;
import com.packt.clubfootReg.domain.repository.VisitRepo;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

/**
 * 
 * @author David
 * This class is the VisitController which routes and synchronizes data submitted via the view to the model.
 * This class contains Three get methods and One post method. 
 */
// Visit Controller class 
@Controller
public class VisitController {

	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private VisitRepo visitRepo;	// An instantiation of VisitRepo interface
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	/*
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public String visitForm(Model model){
		Visit visit = new Visit();
		model.addAttribute("visit", visit);
		return "visit";
	}*/
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/visit", method = RequestMethod.GET)	// Gets the visit view
	public ModelAndView editPatientForm(HttpServletRequest request) {
	    Visit visit = new Visit(Integer.parseInt(request.getParameter("id")));	// Instantiation of visit and passes parses an integer from the getParameter method for "id"
	    ModelAndView model = new ModelAndView("visit");	// Model passes the "visit" view to it
		model.addObject("visit", visit);	// Adds an object called visit to the model
	    return model;// Returns the model 
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/visit", method=RequestMethod.POST)	// Posts the visit form information to the database
    public String addVisitSubmit(@ModelAttribute("visit") Visit visit, Model model) {
        visitRepo.addVisit(visit);	// Visitrepo adds visit object to the interface
        model.addAttribute("visit", visitRepo.getVisit(visit.getId()));	// Gets the visit id from the interface method getVisit and adds it to the attribute of the model
        return "view_visit_info";// Returns the view_visit_info page
    }
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/view_visit", method = RequestMethod.GET)	// Get the view_visit page
	public String view_visitForm(Model model){
		model.addAttribute("visit", visitRepo.getAllVisits());	// Gets all the visits from the visitRepo to the visit attribute of the model
		return "view_visit";// Returns the view_visit page
	}
	
	// Annotation for mapping web requests to specific handler classes/methods	
	@RequestMapping(value = "/view_visit_info", method = RequestMethod.GET)	// Get the view_visit_info page info
	public String view_visit_infoForm(Model model){
		return "view_visit_info";	// Returns the view_visit_info page
	}
	
	/*
	@RequestMapping(value = "/visit", method = RequestMethod.POST)
	public String visitSubmitForm(@ModelAttribute("visit") Visit visit, Model model){
		model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Visit Data Successfully Submitted");
        visitRepo.addVisit(visit);
		return "view_visit";
	}*/
	/*
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return visitRepo.getAllHospitals();
	}
	*/
	public VisitController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
