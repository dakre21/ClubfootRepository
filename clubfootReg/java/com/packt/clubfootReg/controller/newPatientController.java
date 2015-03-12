package com.packt.clubfootReg.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.HospitalRepo;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

@Controller
public class newPatientController {

	@Autowired
	private newPatientRepo newpatientrepo;
	//private HospitalRepo hospitalRepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(value="/newpatient", method=RequestMethod.GET)
	public String patientForm(Model model) {
		newPatient newpatient = new newPatient();
		model.addAttribute("newpatient", newpatient);
		return "newpatient";
	}
	
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)
    public String newPatientSubmit(@ModelAttribute("newPatient") newPatient newpatient, Model model) {
        newpatientrepo.addPatient(newpatient);
        model.addAttribute("patients", newpatientrepo.getAllPatients());
        return "view_patients";
    }
	
	/*
	@RequestMapping(value="/edit_patient", method=RequestMethod.GET)
    public String editPatientForm(Model model) {
        model.addAttribute("patient", newpatientrepo.getPatient(77));
        return "edit_patient";
    }
    */
	
	@RequestMapping(value = "/edit_patient", method = RequestMethod.GET)
	public ModelAndView editPatientForm(HttpServletRequest request) {
	    int patient_id = Integer.parseInt(request.getParameter("id"));
	    newPatient patient = newpatientrepo.getPatient(patient_id);
	    ModelAndView model = new ModelAndView("edit_patient");
	    model.addObject("patient", patient);
	    return model;
	}
	
	
	@RequestMapping(value="/edit_patient", method=RequestMethod.POST)
    public String editPatientSubmit(@ModelAttribute("editPatient") newPatient patient, Model model) {
        newpatientrepo.updatePatient(patient);
        model.addAttribute("patient", newpatientrepo.getPatient(patient.getId()));
        return "view_patient_info";
    }
	
	/*
	@RequestMapping(value="/newpatient", method=RequestMethod.POST)
    public String newPatientSubmit(Model model) {
        //newpatientrepo.addPatient(newpatient);
        model.addAttribute("patients", newpatientrepo.getAllPatients());
        return "view_patients";
    }*/
	
	@RequestMapping(value = "/view_patients", method = RequestMethod.GET)
	public String viewPatientsForm(Model model){
		model.addAttribute("patients", newpatientrepo.getAllPatients());
		return "view_patients";
	}
	
	@RequestMapping(value = "/view_patient_info", method = RequestMethod.GET)
	public ModelAndView viewPatientInfoForm(HttpServletRequest request) {
	    int patient_id = Integer.parseInt(request.getParameter("id"));
	    newPatient patient = newpatientrepo.getPatient(patient_id);
	    ModelAndView model = new ModelAndView("view_patient_info");
	    model.addObject("patient", patient);
	    return model;
	}
	
	public newPatientController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}