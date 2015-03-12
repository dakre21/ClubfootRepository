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

import com.packt.clubfootReg.domain.Visit;
import com.packt.clubfootReg.domain.repository.HospitalRepo;
import com.packt.clubfootReg.domain.repository.VisitRepo;
import com.packt.clubfootReg.domain.repository.newPatientRepo;

@Controller
public class VisitController {

	@Autowired
	private VisitRepo visitRepo;
	
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
	
	@RequestMapping(value = "/visit", method = RequestMethod.GET)
	public ModelAndView editPatientForm(HttpServletRequest request) {
	    Visit visit = new Visit(Integer.parseInt(request.getParameter("id")));
	    ModelAndView model = new ModelAndView("visit");
		model.addObject("visit", visit);
	    return model;
	}
	
	@RequestMapping(value="/visit", method=RequestMethod.POST)
    public String addVisitSubmit(@ModelAttribute("visit") Visit visit, Model model) {
        visitRepo.addVisit(visit);
        model.addAttribute("visit", visitRepo.getVisit(visit.getId()));
        return "view_visit_info";
    }
	
	@RequestMapping(value = "/view_visit", method = RequestMethod.GET)
	public String view_visitForm(Model model){
		model.addAttribute("visit", visitRepo.getAllVisits());
		return "view_visit";
	}
	
	@RequestMapping(value = "/view_visit_info", method = RequestMethod.GET)
	public String view_visit_infoForm(Model model){
		return "view_visit_info";
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
	
	public VisitController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
