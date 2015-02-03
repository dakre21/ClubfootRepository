package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Evaluator;
import com.packt.clubfootReg.domain.Hospital;

public interface EvaluatorRepo {

	Evaluator getEvaluator1(int id);
	void addEvaluator(Evaluator evaluator);
	void setDataSource(DataSource ds);
	List<Evaluator> getEvaluator(int id);
	void deleteEvaluator(int id);
	void updateEvaluator(Evaluator evaluator);
}
