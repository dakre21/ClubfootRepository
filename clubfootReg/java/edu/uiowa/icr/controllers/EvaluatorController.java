package edu.uiowa.icr.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uiowa.icr.implementation.inter.EvaluatorRepo;
import edu.uiowa.icr.implementation.inter.HospitalRepo;
import edu.uiowa.icr.models.Evaluator;
import edu.uiowa.icr.models.Patient;

/**
 * 
 * @author David
 * This controller routes to /evaluator and /view_evaluators based on the users request. 
 * There are three GET requests and two POST requests for adding and editing user information
 */
//Controller class for Evaluator 
@Controller
public class EvaluatorController {

	// Tells the Dispatcher-context to "wire" or inject an instance of EvaluatorRepo for this controller class
	@Autowired
	private EvaluatorRepo evaluatorRepo;	// An instantiation of the EvaluatorRepo interface called evaluatorRepo
	
	// This initializes spring's "webdatabinder" class to bind web request parameters 
	// to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued"); // Instantiation of WebDataBinder of binder to call setDisallowedFields, and makes sure that all parameters are in order
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/evaluator", method = RequestMethod.GET) // In this instance we receive the jsp view "evaluator" and get command to view the page
	public String evaluatorForm(Model model){
		Evaluator evaluator = new Evaluator();	// An instantiation of the Evaluator class
		model.addAttribute("evaluator", evaluator);	// Adds an attribute to the model called evaluator and passes the object evaluator to it
		return "evaluator";	// Returns the evaluator page for the user to view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/viewevaluators", method = RequestMethod.GET) // In this instance we receive the jsp view "view_evaluator" and get command to view the page
	public String viewEvaluatorsForm(Model model){
		model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators()); // Adds an attribute to the model called evaluators and passes all of the saved evaluators to it
		return "viewevaluators"; // Returns the view_evaluators page for the user to view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/evaluator", method = RequestMethod.POST) // In this instance we receive the jsp view "evaluator" and post command to submit form data to the database
	public String evaluatorSubmitForm(@ModelAttribute("evaluator") Evaluator evaluator, Model model){
        evaluatorRepo.addEvaluator(evaluator);	// The object evaluatorRepo calls the addEvaluator method and passes evaluator to it
        model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators()); // Adds an attribute to the model called evaluators and passes all of the saved evaluators to it
		return "viewevaluators"; // Returns the view_evaluators page for the user to view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/editevaluator", method = RequestMethod.GET) // In this instance we receive the jsp view "edit_evaluator" and get command to view the page
	public ModelAndView editEvaluatorForm(HttpServletRequest request) {
		MapUtils.debugPrint(System.out, "Evaulator Request Map", request.getParameterMap());
	    int evaluatorId = Integer.parseInt(request.getParameter("id"));	// This parses an int from the request object's getParameter method for "id"
	    System.out.println("Eval ID: "+evaluatorId);
	    Evaluator e = evaluatorRepo.getEvaluator(evaluatorId);	// Instantiation of Evaluator based on the integer id value of the evaluator
	    
	    ModelAndView model = new ModelAndView("editevaluator");	// Instantition of the Model and view built in method and passes edit_evaluator view to it
	    model.addObject("evaluator", e); // Adds an object to the model called evaluator and passes the object e to it for the edit functionality
	    return model; // Returns the model for the user to edit
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/editevaluator", method=RequestMethod.POST) // In this instance we receive the jsp view "edit_evaluator" and post command to submit edit form data to the database
    public String editEvaluatorSubmit(@ModelAttribute("editEvaluator") Evaluator evaluator, Model model) {
        System.out.println("IN EDIT EVAL SUBMIT");
		evaluatorRepo.updateEvaluator(evaluator);	// The object evaluateRepo calls the "updateEvaluator" method and passes evaluator to it
        //model.addAttribute("evaluator", evaluatorRepo.getEvaluator(evaluator.getId()));
        model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators());	// This invokes the addAttribute method of the model and receives all of the evaluators
        return "viewevaluators"; // Returns the view_evaluators page for the user to view
    }
	
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return evaluatorRepo.getAllHospitals();
	}
	
	public EvaluatorController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
