package edu.uiowa.icr.implementation.inter;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import edu.uiowa.icr.models.Hospital;
import edu.uiowa.icr.models.ReportsHospital;

/**
 * 
 * @author David
 * Interface for the Hospital Repository to synchronize data to the database via the following interface methods.
 */
public interface HospitalRepo {
	Hospital getHospital1(int id);
	void addHospital(Hospital hospital); // addHospital method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	Hospital getHospital(int id); // getHospital method that passes the int value for the id
	void deleteHospital(int id); // DeleteHospital method which takes the id value 
	void updateHospital(Hospital hospital); // UpdateHospital method which takes in the hospital object
	int getMaxHospitalID();	// Method that returns the maxhospitalid
	List<Hospital> getAllHospitals();	// Map object that has a vector of Integer and String values which getsAllHospitals
	List<ReportsHospital> getAllHospitalsReports(int hospitalId);
	//Map<Integer, String> getHRP();
	Map<Integer, String> getAllRegions();
}
