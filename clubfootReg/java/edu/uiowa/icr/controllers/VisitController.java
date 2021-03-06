package edu.uiowa.icr.controllers;

import java.util.List;
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

import edu.uiowa.icr.implementation.inter.HospitalRepo;
import edu.uiowa.icr.implementation.inter.VisitRepo;
import edu.uiowa.icr.implementation.inter.PatientRepo;
import edu.uiowa.icr.models.Visit;
import edu.uiowa.icr.models.Patient;

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
	private PatientRepo newPatientRepo;
	
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
	public ModelAndView addVisitForm(HttpServletRequest request) {
		int patientId = Integer.parseInt(request.getParameter("id"));
	    Visit visit = new Visit(patientId);	// Instantiation of visit and passes parses an integer from the getParameter method for "id"
	    visit.setLaterality(visitRepo.getLateralityForPatient(patientId));
	    ModelAndView model = new ModelAndView("visit");	// Model passes the "visit" view to it
		model.addObject("visit", visit);	// Adds an object called visit to the model
	    return model;// Returns the model 
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/visit", method=RequestMethod.POST)	// Posts the visit form information to the database
    public String addVisitSubmit(@ModelAttribute("visit") Visit visit, Model model) {
        visitRepo.addVisit(visit);	// Visitrepo adds visit object to the interface
        model.addAttribute("patient", visitRepo.getPatient(visit.getPatientId()));
        model.addAttribute("visits", visitRepo.getVisitsForPatient(visit.getPatientId()));
        return "viewpatientinfo";// Returns the view_visit_info page
    }
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/viewvisit", method = RequestMethod.GET)	// Get the view_visit page
	public String view_visitForm(Model model){
		model.addAttribute("visit", visitRepo.getAllVisits());	// Gets all the visits from the visitRepo to the visit attribute of the model
		return "viewvisit";// Returns the view_visit page
	}
	
	// Annotation for mapping web requests to specific handler classes/methods	
	@RequestMapping(value = "/viewvisitinfo", method = RequestMethod.GET)	// Get the view_visit_info page info
	public ModelAndView view_visit_infoForm(HttpServletRequest request){
		ModelAndView model = new ModelAndView("viewvisitinfo");	// Passes the view_patient_info view to the model
		int visitId = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call
		Visit visit = visitRepo.getVisit(visitId);	// Gets patient_id from newpatient repo's method getPatient
		//visit.setLaterality(visitRepo.getLateralityWithVisitId(visit_id));
		model.addObject("visit", visit);	// Adds an object called patient to the model
		return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/editvisit", method = RequestMethod.GET)	// Gets the edit_edit form
	public ModelAndView editVisitForm(HttpServletRequest request) {
	    int visitId = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call and finds "id"
	    Visit visit = visitRepo.getVisit(visitId);	// Method call oneditrepo to get the edit id
	    //visit.setLaterality(visitRepo.getLateralityWithVisitId(visit_id));
	    ModelAndView model = new ModelAndView("editvisit");	// Instantiation of ModelAndView and passes "edit_visit" view to it
	    model.addObject("visit", visit);	// Adds the object visit to the model
	    return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/editvisit", method=RequestMethod.POST)	// Returns the edit_visit form
    public String editVisitSubmit(@ModelAttribute("editVisit") Visit visit, Model model) {
        visitRepo.updateVisit(visit);	// Method call to update visit information
        model.addAttribute("visit", visitRepo.getVisit(visit.getId()));	// Model adds the attribute of visit by id
        return "viewvisitinfo";	// Returns view_visit_info
    }
	/*
	@RequestMapping(value = "/visit", method = RequestMethod.POST)
	public String visitSubmitForm(@ModelAttribute("visit") Visit visit, Model model){
		model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Visit Data Successfully Submitted");
        visitRepo.addVisit(visit);
		return "view_visit";
	}*/
	
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return visitRepo.getAllHospitals();
	}
	
	@ModelAttribute("evaluatorList")
	public Map<Integer, String> populateEvaluatorSelect() {
	    return visitRepo.getAllEvaluators();
	}
	
	public VisitController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
