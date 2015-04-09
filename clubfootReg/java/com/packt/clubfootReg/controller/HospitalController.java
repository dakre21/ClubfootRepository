package com.packt.clubfootReg.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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

import com.packt.clubfootReg.domain.Evaluator;
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
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/edit_hospital", method = RequestMethod.GET) // In this instance we receive the jsp view "edit_evaluator" and get command to view the page
	public ModelAndView editHospitalForm(HttpServletRequest request) {
	    int hospital_id = Integer.parseInt(request.getParameter("id"));	// This parses an int from the request object's getParameter method for "id"
	    Hospital h = hospitalRepo.getHospital(hospital_id);	// Instantiation of Hospital based on the integer id value of the hospital
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
		/*
		// TODO Auto-generated method stub
	       //Addition
	       try
	       {
	           int i = 3;
	           int j = 3;
	           int result = addition(i,j);
	           System.out.println("Result = " + result);
	       }
	       catch(Exception ex)
	       {
	           System.out.println("Exception:" + ex);
	       }
	        //Subtraction
	        try
	       {
	           int i = 3;
	           int j = 3;
	           int result = subtraction(i,j);
	           System.out.println("Result = " + result);
	       }
	       catch(Exception ex)
	       {
	           System.out.println("Exception:" + ex);
	       } 
	        //Multiplication
	        try
	        {
	           int i = 4;
	           int j = 3;
	           int result = multiplication(i,j);
	           System.out.println("Result = " + result);
	        }
	        catch(Exception ex)
	        {
	           System.out.println("Exception:" + ex);
	        }  
	        //division
	        try
	        {
	           int i = 4;
	           int j = 3;
	           int result = division(i,j);
	           System.out.println("Result = " + result);
	        }
	        catch(Exception ex)
	        {
	           System.out.println("Exception:" + ex);
	        }          
	       
	    }

	    private static int addition(int number1, int number2) {
	        com.hubberspot.clubfoot.ClubfootServiceService service = new com.hubberspot.clubfoot.ClubfootServiceService();
	        com.hubberspot.clubfoot.ClubfootService port = service.getClubfootServicePort();
	        return port.addition(number1, number2);
	    }

	    private static int division(int number1, int number2) {
	        com.hubberspot.clubfoot.ClubfootServiceService service = new com.hubberspot.clubfoot.ClubfootServiceService();
	        com.hubberspot.clubfoot.ClubfootService port = service.getClubfootServicePort();
	        return port.division(number1, number2);
	    }

	    private static int multiplication(int number1, int number2) {
	        com.hubberspot.clubfoot.ClubfootServiceService service = new com.hubberspot.clubfoot.ClubfootServiceService();
	        com.hubberspot.clubfoot.ClubfootService port = service.getClubfootServicePort();
	        return port.multiplication(number1, number2);
	    }

	    private static int subtraction(int number1, int number2) {
	        com.hubberspot.clubfoot.ClubfootServiceService service = new com.hubberspot.clubfoot.ClubfootServiceService();
	        com.hubberspot.clubfoot.ClubfootService port = service.getClubfootServicePort();
	        return port.subtraction(number1, number2);
	    }
	    

	}
	
	
*/
}
}
