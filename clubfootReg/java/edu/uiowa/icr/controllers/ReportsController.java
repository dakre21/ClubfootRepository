package edu.uiowa.icr.controllers;

import java.awt.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.uiowa.icr.implementation.inter.EvaluatorRepo;
import edu.uiowa.icr.implementation.inter.HospitalRepo;
import edu.uiowa.icr.implementation.inter.VisitRepo;
import edu.uiowa.icr.implementation.inter.PatientRepo;
import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.ReportsHospital;
import edu.uiowa.icr.models.ReportsPatients;
import edu.uiowa.icr.models.ReportsVisits;
import edu.uiowa.icr.models.Visit;
import edu.uiowa.icr.models.Patient;

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
	private PatientRepo newpatientRepo;
	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired
	private EvaluatorRepo evaluatorRepo;
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	// Instantiation of SimpleDateFormat for the database to properly synch data in that format
		sdf.setLenient(true);	// Method call to setLenient and passes boolean value "true" to it
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));	// Binder binds the date format set up earlier to registerCustomEditor class
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/visit_reports", method=RequestMethod.GET)	// Posts the visit form information to the database
	public String visitReports(Model model) {
		model.addAttribute("visit_reports", visitRepo.getAllVisitsReports(null));
		return "visit_reports";// Returns the view_visit_info page
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/visit_reports", method=RequestMethod.POST)	// Posts the visit form information to the database
	public String visitReportsFilter(@ModelAttribute("filters") ReportsVisits filter, Model model) {
		model.addAttribute("visit_reports", visitRepo.getAllVisitsReports(filter));
		model.addAttribute("filters", filter);
		return "visit_reports";// Returns the view_visit_info page
	}
	

	@RequestMapping(value="/patient_reports", method=RequestMethod.GET)	
	public String patientReports(Model model) {
		model.addAttribute("patients", newpatientRepo.getAllPatientsReports(null));	
		return "patient_reports";
	}
	
	@RequestMapping(value="/patient_reports", method=RequestMethod.POST)	
    public String filterPatientsSubmit(@ModelAttribute("filters") ReportsPatients filters, Model model) {
        model.addAttribute("patients", newpatientRepo.getAllPatientsReports(filters));	
        model.addAttribute("filters", filters);
        return "patient_reports";	
    }
	
	@RequestMapping(value="/hospital_reports", method=RequestMethod.GET)
	public String hospitalReports(Model model) {
		model.addAttribute("hospitals", hospitalRepo.getAllHospitalsReports(0));
		return "hospital_reports";
	}
	
	@RequestMapping(value="/hospital_reports", method=RequestMethod.POST)	
    public String filterHospitalsSubmit(@ModelAttribute("hospitalId") int hospitalId, Model model) {
        model.addAttribute("hospitals", hospitalRepo.getAllHospitalsReports(hospitalId));
        model.addAttribute("hospitalId", hospitalId);
        return "hospital_reports";	
    }
	
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return evaluatorRepo.getAllHospitals();
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