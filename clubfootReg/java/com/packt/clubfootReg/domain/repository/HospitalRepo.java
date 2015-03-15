package com.packt.clubfootReg.domain.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;

/**
 * 
 * @author David
 * Interface for the Hospital Repository to synchronize data to the database via the following interface methods.
 */
public interface HospitalRepo {
	
	Hospital getHospital1(int id);
	void addHospital(Hospital hospital); // addHospital method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	List<Hospital> getHospital(int id); // getHospital method that passes the int value for the id
	void deleteHospital(int id); // DeleteHospital method which takes the id value 
	void updateHospital(Hospital hospital); // UpdateHospital method which takes in the hospital object
	int getMaxHospitalID();	// Method that returns the maxhospitalid
	Map<Integer, String> getAllHospitals();	// Map object that has a vector of Integer and String values which getsAllHospitals
}
