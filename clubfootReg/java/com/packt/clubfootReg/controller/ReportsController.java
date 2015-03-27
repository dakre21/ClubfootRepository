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

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.HospitalRepo;
import com.packt.clubfootReg.domain.repository.VisitRepo;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

/**
 * 
 * @author David
 * This class is the ReportsController which routes and synchronizes data submitted via the view to the model.
 * This class contains Three get methods and One post method. 
 */
// Visit Controller class 
@Controller
public class ReportsController {

	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private VisitRepo visitRepo;	// An instantiation of VisitRepo interface
	@Autowired 
	private newPatientRepo newpatientRepo;
	@Autowired
	private HospitalRepo hospitalRepo;
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/visit_reports", method=RequestMethod.GET)	// Posts the visit form information to the database
	public String visitReports(@ModelAttribute("visit_reports") Visit visit, Model model) {
		//visitRepo.addVisit(visit);	// Visitrepo adds visit object to the interface
		//model.addAttribute("visit_reports", visitRepo.getVisit(visit.getId()));	// Gets the visit id from the interface method getVisit and adds it to the attribute of the model
		return "visit_reports";// Returns the view_visit_info page
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/patient_reports", method=RequestMethod.GET)	// Posts the visit form information to the database
	public String patientReports(@ModelAttribute("patient_reports") newPatient newpatient, Model model) {
		//newpatientRepo.addPatient(newpatient);	// Visitrepo adds visit object to the interface
		//model.addAttribute("patient_reports", newpatientRepo.getPatient(newpatient.getId()));	// Gets the visit id from the interface method getVisit and adds it to the attribute of the model
		return "patient_reports";// Returns the view_visit_info page
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/hospital_reports", method=RequestMethod.GET)	// Posts the visit form information to the database
	public String patientReports(@ModelAttribute("hospital_reports") Hospital hospital, Model model) {
		//hospitalRepo.addHospital(hospital);	// Visitrepo adds visit object to the interface
		//model.addAttribute("hospital_reports", hospitalRepo.getHospital(hospital.getId()));	// Gets the visit id from the interface method getVisit and adds it to the attribute of the model
		return "hospital_reports";// Returns the view_visit_info page
	}
	/*
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/patient_reports", method = RequestMethod.GET)	// Gets the view_patient_info form 
	public ModelAndView patientReports(HttpServletRequest request) {
		int patient_id = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call
		newPatient patient = newpatientRepo.getPatient(patient_id);	// Gets patient_id from newpatient repo's method getPatient
		ModelAndView model = new ModelAndView("patient_reports");	// Passes the view_patient_info view to the model
		model.addObject("patient", patient);	// Adds an object called patient to the model
		return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/hospital_reports", method = RequestMethod.GET)	// Gets the view_patient_info form 
	public ModelAndView hospitalReports(HttpServletRequest request) {
		int hospital_id = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call
		Hospital hospital = hospitalRepo.getHospital1(hospital_id);	// Gets patient_id from newpatient repo's method getPatient
		ModelAndView model = new ModelAndView("hospital_reports");	// Passes the view_patient_info view to the model
		model.addObject("hospital", hospital);	// Adds an object called patient to the model
		return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/visit_reports", method = RequestMethod.GET)	// Gets the view_patient_info form 
	public ModelAndView visitReports(HttpServletRequest request) {
		Visit visit = new Visit(Integer.parseInt(request.getParameter("id")));	// Instantiation of visit and passes parses an integer from the getParameter method for "id"
	    ModelAndView model = new ModelAndView("visit_reports");	// Model passes the "visit" view to it
		model.addObject("visit", visit);	// Adds an object called visit to the model
	    return model;// Returns the model 
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}