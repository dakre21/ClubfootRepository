package com.packt.clubfootReg.domain.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.ReportsHospital;
import com.packt.clubfootReg.domain.ReportsPatients;
import com.packt.clubfootReg.domain.ReportsVisits;
import com.packt.clubfootReg.domain.Visit;

/**
 * 
 * @author David
 * Interface for the Visit Repository to synchronize data to the database via the following interface methods.
 */
public interface VisitRepo {
	void addVisit(Visit visit); // addVisit method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	//List<Visit> getVisit(int id);	// getVisit method that passes the int value for id
	Visit getVisit(int id);
	void deleteVisit(int id);	// DeleteVisit method which takes the id value 
	List<Visit> getAllVisits();	// List object that contains the getAllVisits method
	void updateVisit(Visit visit);	// UpdateVisit method which takes in the visit object
	int getMaxVisitId();	// Method that returns the maxvisitid
	int getMaxFootId();	// Method that returns the maxfootid
	Map<Integer, String> getAllHospitals();
	Map<Integer, String> getAllEvaluators();
	String getLateralityForPatient(int id);
	List<Visit> getAllVisitsReports(ReportsVisits filter);
}