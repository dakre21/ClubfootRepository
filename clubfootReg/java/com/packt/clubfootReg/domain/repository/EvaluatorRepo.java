package com.packt.clubfootReg.domain.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Evaluator;

/**
 * 
 * @author David
 * Interface for the Evaluator Repository to synchronize data to the database via the following interface methods.
 */
public interface EvaluatorRepo {
	void addEvaluator(Evaluator evaluator);	// addEvaluator method to add the model data to the database
	void setDataSource(DataSource ds);	// Sets up the dataSource for the database synch
	Evaluator getEvaluator(int id);	// getEvaluator method that passes the int value for the id
	List<Evaluator> getAllEvaluators();	// List object that contains the getAllEvaluators method
	void deleteEvaluator(int id);	// DeleteEvaluator method which takes the id value 
	void updateEvaluator(Evaluator evaluator);	// UpdateEvaluator method which takes in the evaluator object
	int getMaxPersonID();	// Method that returns the maxpersonid
	Map<Integer, String> getAllHospitals();	// Map object that has a vector of Integer and String values which getsAllHospitals
}
