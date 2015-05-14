package edu.uiowa.icr.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uiowa.icr.implementation.inter.HospitalRepo;
import edu.uiowa.icr.implementation.inter.PatientRepo;
import edu.uiowa.icr.models.Visit;
import edu.uiowa.icr.models.Patient;

/**
 * 
 * @author David
 * This is the newPatientController which receives routing commands and syncrhonizes jsp form data with the model.
 * This controller contains four GET commands and Two Post commands. 
 */
// newPatientController class
@Controller
public class PatientController{

	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private PatientRepo newpatientrepo; // Instantiation of the newPatientRepo class 
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(HttpServletRequest request,WebDataBinder binder) throws ServletException{
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	// Instantiation of SimpleDateFormat for the database to properly synch data in that format
	    sdf.setLenient(true);	// Method call to setLenient and passes boolean value "true" to it
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));	// Binder binds the date format set up earlier to registerCustomEditor class
	   // binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) throws Exception {
			binder.registerCustomEditor(byte[].class,
                new ByteArrayMultipartFileEditor());
	}
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/patient", method=RequestMethod.GET)	// Gets the newpatient form
	public String patientForm(Model model) {
		Patient newpatient = new Patient();	// Instantiation of the newpatient model class
		model.addAttribute("newpatient", newpatient);	// Adds the object newpatient to the model attribute "newpatient"
		return "patient";	// Returns the newpatient view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/patient", method=RequestMethod.POST)	// Returns the newpatient form data to the model
    public String newPatientSubmit(@ModelAttribute("newPatient") Patient newpatient, Model model) {
        newpatientrepo.addPatient(newpatient);	// Method call to the addPatient class and passes the newpatient object to it
        model.addAttribute("patients", newpatientrepo.getAllPatients());	// Receives all patients via a method call from repo to the model attribute patients
        return "viewpatients";	// Returns the view_patient view
    }
	
	/*
	 * 
	 * 
	 * if (!file.isEmpty()) {
            try {
            	//BufferedImage bytes = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                System.out.println("File upload sucess");
                newpatientrepo.addPhoto(bytes);
            } catch (Exception e) {
            	System.out.println("File upload failed");
            }
        } else {
        	System.out.println("No file uploaded");
        }
String fileName,
            @RequestParam("file") MultipartFile file) {
>>>>>>> jake
		  if (!file.isEmpty()) {
	            try {
	            	BufferedImage bytes = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	                //byte[] bytes = file.getBytes();
	                //BufferedOutputStream stream =
	                        //new BufferedOutputStream(new FileOutputStream(new File(file)));
	                //stream.write(bytes);
	                //stream.close();
	                System.out.println("File upload sucess");
	                newpatientrepo.addPhoto(bytes);
	            } catch (Exception e) {
	            	System.out.println("File upload failed");
	            }
	        } else {
	        	System.out.println("No file uploaded");
	        }

	@RequestMapping(value="/edit_patient", method=RequestMethod.GET)
    public String editPatientForm(Model model) {
        model.addAttribute("patient", newpatientrepo.getPatient(77));
        return "edit_patient";
    }
    */
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/editpatient", method = RequestMethod.GET)	// Gets the edit_patient form
	public ModelAndView editPatientForm(HttpServletRequest request) {
	    int patientId = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call and finds "id"
	    Patient patient = newpatientrepo.getPatient(patientId);	// Method call on newpatientrepo to get the patient id
	    ModelAndView model = new ModelAndView("editpatient");	// Instantiation of ModelAndView and passes "edit_patient" view to it
	    model.addObject("patient", patient);	// Adds the object patient to the model
	    return model;	// Returns the model
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/editpatient", method=RequestMethod.POST)	// Returns the edit_patient form
    public String editPatientSubmit(@ModelAttribute("editPatient") Patient patient, Model model) {
        newpatientrepo.updatePatient(patient);	// Method call to update patient information
        model.addAttribute("patient", newpatientrepo.getPatient(patient.getId()));	// Model adds the attribute of patient by id
        return "viewpatientinfo";	// Returns view_patient_info
    }
	
	/*
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)
    public String newPatientSubmit(Model model) {
        //newpatientrepo.addPatient(newpatient);
        model.addAttribute("patients", newpatientrepo.getAllPatients());
        return "view_patients";
    }*/
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/viewpatients", method = RequestMethod.GET)	// Gets the view_patients form
	public String viewPatientsForm(Model model){
		model.addAttribute("patients", newpatientrepo.getAllPatients());	// Adds all patients from the getAllPatients method
		return "viewpatients";	// Returns view_patients view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/viewpatientinfo", method = RequestMethod.GET)	// Gets the view_patient_info form 
	public ModelAndView viewPatientInfoForm(HttpServletRequest request) {
	    ModelAndView model = new ModelAndView("viewpatientinfo");	// Passes the view_patient_info view to the model
	    int patientId = Integer.parseInt(request.getParameter("id"));	// Parses an integer from the getParameter method call
	    
	    Patient patient = newpatientrepo.getPatient(patientId);	// Gets patient_id from newpatient repo's method getPatient
	    model.addObject("patient", patient);	// Adds an object called patient to the model
	    
	    List<Visit> visits = newpatientrepo.getVisitsForPatient(patientId);	// Gets patient_id from newpatient repo's method getPatient
	    model.addObject("visits", visits);	// Adds an object called patient to the model
	    
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
	
	public PatientController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}