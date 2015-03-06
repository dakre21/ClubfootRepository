package com.packt.clubfootReg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.newPatient;
import com.packt.clubfootReg.domain.repository.EvaluatorRepo;


@Controller
public class EvaluatorController {

	@Autowired
	private EvaluatorRepo evaluatorRepo;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
	
	@RequestMapping(value = "/evaluator", method = RequestMethod.GET)
	public String evaluatorForm(Model model){
		Evaluator evaluator = new Evaluator();
		model.addAttribute("evaluator", evaluator);
		return "evaluator";
	}
	
	@RequestMapping(value = "/view_evaluators", method = RequestMethod.GET)
	public String viewEvaluatorsForm(Model model){
		model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators());
		return "view_evaluators";
	}
	
	@RequestMapping(value = "/evaluator", method = RequestMethod.POST)
	public String evaluatorSubmitForm(@ModelAttribute("evaluator") Evaluator evaluator, Model model){
        evaluatorRepo.addEvaluator(evaluator);
        model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators());
		return "view_evaluators";
	}
	
	@RequestMapping(value = "/edit_evaluator", method = RequestMethod.GET)
	public ModelAndView editEvaluatorForm(HttpServletRequest request) {
	    int evaluator_id = Integer.parseInt(request.getParameter("id"));
	    Evaluator e = evaluatorRepo.getEvaluator(evaluator_id);
	    ModelAndView model = new ModelAndView("edit_evaluator");
	    model.addObject("evaluator", e);
	    return model;
	}
	
	@RequestMapping(value="/edit_evaluator", method=RequestMethod.POST)
    public String editEvaluatorSubmit(@ModelAttribute("editEvaluator") Evaluator evaluator, Model model) {
        evaluatorRepo.updateEvaluator(evaluator);
        //model.addAttribute("evaluator", evaluatorRepo.getEvaluator(evaluator.getId()));
        model.addAttribute("evaluators", evaluatorRepo.getAllEvaluators());
        return "view_evaluators";
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
