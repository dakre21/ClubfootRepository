package com.packt.clubfootReg.domain.repository;

import java.util.List;
import javax.sql.DataSource;
import com.packt.clubfootReg.domain.Evaluator;

public interface EvaluatorRepo {
	void addEvaluator(Evaluator evaluator);
	void setDataSource(DataSource ds);
	List<Evaluator> getEvaluator(int id);
	List<Evaluator> getAllEvaluators();
	void deleteEvaluator(int id);
	void updateEvaluator(Evaluator evaluator);
	int getMaxPersonID();
}
