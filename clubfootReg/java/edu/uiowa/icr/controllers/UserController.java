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

import edu.uiowa.icr.implementation.inter.UserRepo;
import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.User;
/**
 * 
 * @author David
 * Documentation for AddUserController:
 * This controller routes to /adduser and /view_users based on the users request. 
 * There are two GET requests (specifically one to get the "adduser" form and the other
 * to get the "view_users" list).
 */

//Controller class for add user
@Controller
public class UserController {

	// Tells the Dispatcher-context to "wire" or inject an instance of UserRepo for this controller class
	@Autowired
	private UserRepo userRepo;	// An instantiation of the UserRepo interface 
	
	// This initializes spring's "webdatabinder" class to bind web request parameters to the java bean objects to receive the incoming data 
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");	// Instantiation of WebDataBinder of binder to call setDisallowedFields, and makes sure that all parameters are in order
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)	// In this instance we receive the jsp view "adduser" and get command to view the page
	public String userForm(Model model){
		User user = new User();	// Instantiation of the User model class
		model.addAttribute("user", user);	// Adding an attribute called user in the model user
		return "adduser";	// Returns the adduser page for the user to view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/adduser", method = RequestMethod.POST) // In this instance we receive the jsp view "adduser" and post command to submit information the user submitted within the form to the database
	public String userSubmitForm(@ModelAttribute("user") User user, Model model){
		userRepo.addUser(user);	// UserRepo's interface method "addUser" passes the object user to the method "addUser"
		model.addAttribute("users", userRepo.getAllUsers());	// Add all users to the model from receiving the information stored in the database and retrieved via the "getAllUsers" method
		return "viewusers";	// Returns view_users jsp view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET) // In this instance we receive the jsp view "view_user" and get command to view all users
	public String viewUsersForm(Model model){
		model.addAttribute("users", userRepo.getAllUsers());	// Receives all of the users saved in the repository class and adds it to the model users
		return "viewusers";	// Returns view_users jsp view
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value = "/edituser", method = RequestMethod.GET) // In this instance we receive the jsp view "edit_evaluator" and get command to view the page
	public ModelAndView editUserForm(HttpServletRequest request) {
	    int userId = Integer.parseInt(request.getParameter("id"));	// This parses an int from the request object's getParameter method for "id"
	    User u = userRepo.getUser(userId);	// Instantiation of User based on the integer id value of the user
	    ModelAndView model = new ModelAndView("edituser");	// Instantition of the Model and view built in method and passes edituser view to it
	    model.addObject("user", u); // Adds an object to the model called user and passes the object h to it for the edit functionality
	    return model; // Returns the model for the user to edit
	}
	
	// Annotation for mapping web requests to specific handler classes/methods
	@RequestMapping(value="/edituser", method=RequestMethod.POST) // In this instance we receive the jsp view "edit_evaluator" and post command to submit edit form data to the database
    public String editUserSubmit(@ModelAttribute("editUser") User user, Model model) {
        userRepo.updateUser(user);	// The object evaluateRepo calls the "updateEvaluator" method and passes evaluator to it
        //model.addAttribute("evaluator", evaluatorRepo.getEvaluator(evaluator.getId()));
        model.addAttribute("users", userRepo.getAllUsers());	// This invokes the addAttribute method of the model and receives all of the evaluators
        return "viewusers"; // Returns the view_evaluators page for the user to view
    }
	
	
	@ModelAttribute("roleList")
	public Map<Integer, String> populateRoleSelect() {
	    return userRepo.getAllRoles();
	}
	
	@ModelAttribute("hospitalList")
	public Map<Integer, String> populateHospitalSelect() {
	    return userRepo.getAllHospitals();
	}
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
