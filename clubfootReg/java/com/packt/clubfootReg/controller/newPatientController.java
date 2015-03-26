package com.packt.clubfootReg.controller;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.HospitalRepo;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

/**
 * 
 * @author David
 * This is the newPatientController which receives routing commands and syncrhonizes jsp form data with the model.
 * This controller contains four GET commands and Two Post commands. 
 */
// newPatientController class
@Controller
public class newPatientController {

	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private newPatientRepo newpatientrepo; // Instantiation of the newPatientRepo class 
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	// Instantiation of SimpleDateFormat for the database to properly synch data in that format
	    sdf.setLenient(true);	// Method call to setLenient and passes boolean value "true" to it
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));	// Binder binds the date format set up earlier to registerCustomEditor class
	}
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/newpatient", method=RequestMethod.GET)	// Gets the newpatient form
	public String patientForm(Model model) {
		newPatient newpatient = new newPatient();	// Instantiation of the newpatient model class
		model.addAttribute("newpatient", newpatient);	// Adds the object newpatient to the model attribute "newpatient"
		return "newpatient";	// Returns the newpatient view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)	// Returns the newpatient form data to the model
    public String newPatientSubmit(@ModelAttribute("newPatient") newPatient newpatient, Model model, String fileName,
            @RequestParam("file") MultipartFile file) {
		  if (!file.isEmpty()) {
	            try {
	                byte[] bytes = file.getBytes();
	                BufferedOutputStream stream =
	                        new BufferedOutputStream(new FileOutputStream(new File(fileName)));
	                stream.write(bytes);
	                stream.close();
	                System.out.println("File upload sucess");
	            } catch (Exception e) {
	            	System.out.println("File upload failed");
	            }
	        } else {
	        	System.out.println("No file uploaded");
	        }
        newpatientrepo.addPatient(newpatient);	// Method call to the addPatient class and passes the newpatient object to it
        model.addAttribute("patients", newpatientrepo.getAllPatients());	// Receives all patients via a method call from repo to the model attribute patients
        return "view_patients";	// Returns the view_patient view
    }
	
	/*
	@RequestMapping(value="/edit_patient", method=RequestMethod.GET)
    public String editPatientForm(Model model) {
        model.addAttribute("patient", newpatientrepo.getPatient(77));
        return "edit_patient";
    }
    */
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/edit_patient", method = RequestMethod.GET)	// Gets the edit_patient form
	public ModelAndView editPatientForm(HttpServletRequest request) {
	    int patient_id = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call and finds "id"
	    newPatient patient = newpatientrepo.getPatient(patient_id);	// Method call on newpatientrepo to get the patient id
	    ModelAndView model = new ModelAndView("edit_patient");	// Instantiation of ModelAndView and passes "edit_patient" view to it
	    model.addObject("patient", patient);	// Adds the object patient to the model
	    return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/edit_patient", method=RequestMethod.POST)	// Returns the edit_patient form
    public String editPatientSubmit(@ModelAttribute("editPatient") newPatient patient, Model model) {
        newpatientrepo.updatePatient(patient);	// Method call to update patient information
        model.addAttribute("patient", newpatientrepo.getPatient(patient.getId()));	// Model adds the attribute of patient by id
        return "view_patient_info";	// Returns view_patient_info
    }
	
	/*
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)
    public String newPatientSubmit(Model model) {
        //newpatientrepo.addPatient(newpatient);
        model.addAttribute("patients", newpatientrepo.getAllPatients());
        return "view_patients";
    }*/
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/view_patients", method = RequestMethod.GET)	// Gets the view_patients form
	public String viewPatientsForm(Model model){
		model.addAttribute("patients", newpatientrepo.getAllPatients());	// Adds all patients from the getAllPatients method
		return "view_patients";	// Returns view_patients view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/view_patient_info", method = RequestMethod.GET)	// Gets the view_patient_info form 
	public ModelAndView viewPatientInfoForm(HttpServletRequest request) {
	    int patient_id = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call
	    newPatient patient = newpatientrepo.getPatient(patient_id);	// Gets patient_id from newpatient repo's method getPatient
	    ModelAndView model = new ModelAndView("view_patient_info");	// Passes the view_patient_info view to the model
	    model.addObject("patient", patient);	// Adds an object called patient to the model
	    return model;	// Returns the model
	}
	
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return newpatientrepo.getAllHospitals();
	}
	
	@ModelAttribute("evaluatorList")
	public Map<Integer, String> populateEvaluatorSelect() {
	    return newpatientrepo.getAllEvaluators();
	}
	
	public newPatientController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}