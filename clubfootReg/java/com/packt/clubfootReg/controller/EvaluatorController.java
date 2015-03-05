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
		Evaluator evaluator = new Evaluator(evaluatorRepo.getMaxPersonID() + 1, null, null, null, null, null, 1);
		model.addAttribute("evaluator", evaluator);
		//this.initModelList(model);
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
	/*
	private void initModelList(Model model) {
		Map<Integer,String> hospitals = new LinkedHashMap<Integer,String>();
		hospitals = evaluatorRepo.getAllHospitals();
		model.addAttribute("hospitalList", hospitals);
	}*/
	
	public EvaluatorController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
