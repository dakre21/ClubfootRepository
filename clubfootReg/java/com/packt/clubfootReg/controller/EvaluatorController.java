package com.packt.clubfootReg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		Evaluator evaluator = new Evaluator(evaluatorRepo.getMaxPersonID() + 1, null, null, null, null, 1);
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
	
	public EvaluatorController() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
