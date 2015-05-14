package edu.uiowa.icr.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import edu.uiowa.icr.implementation.inter.HospitalRepo;
import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.Hospital;

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
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/edit_hospital", method = RequestMethod.GET) // In this instance we receive the jsp view "edit_evaluator" and get command to view the page
	public ModelAndView editHospitalForm(HttpServletRequest request) {
	    int hospitalId = Integer.parseInt(request.getParameter("id"));	// This parses an int from the request object's getParameter method for "id"
	    Hospital h = hospitalRepo.getHospital(hospitalId);	// Instantiation of Hospital based on the integer id value of the hospital
	    ModelAndView model = new ModelAndView("edit_hospital");	// Instantition of the Model and view built in method and passes edit_hospital view to it
	    model.addObject("hospital", h); // Adds an object to the model called hospital and passes the object h to it for the edit functionality
	    return model; // Returns the model for the user to edit
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/edit_hospital", method=RequestMethod.POST) // In this instance we receive the jsp view "edit_evaluator" and post command to submit edit form data to the database
    public String editHospitalSubmit(@ModelAttribute("editHospital") Hospital hospital, Model model) {
        hospitalRepo.updateHospital(hospital);	// The object evaluateRepo calls the "updateEvaluator" method and passes evaluator to it
        //model.addAttribute("evaluator", evaluatorRepo.getEvaluator(evaluator.getId()));
        model.addAttribute("hospitals", hospitalRepo.getAllHospitals());	// This invokes the addAttribute method of the model and receives all of the evaluators
        return "view_hospitals"; // Returns the view_evaluators page for the user to view
    }
	
	
	@ModelAttribute("regionList")
	public Map<Integer, String> populateRegionSelect() {
	    return hospitalRepo.getAllRegions();
	}
	
	public HospitalController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
