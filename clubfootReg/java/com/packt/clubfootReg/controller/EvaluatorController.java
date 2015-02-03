package com.packt.clubfootReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.clubfootReg.domain.Evaluator;
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
	
	@RequestMapping(value = "/evaluator", method = RequestMethod.POST)
	public String evaluatorSubmitForm(@ModelAttribute("evaluator") Evaluator evaluator, Model model){
		model.addAttribute("greeting", "UIowa Clubfoot Registry");
        model.addAttribute("tagline", "Evaluator Data Successfully Submitted");
        evaluatorRepo.addEvaluator(evaluator);
		return "home";
	}
	
	public EvaluatorController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
