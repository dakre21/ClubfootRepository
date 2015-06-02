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
	Hospital getHospital1(Long id);
	void addHospital(Hospital hospital); // addHospital method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	Hospital getHospital(Long id); // getHospital method that passes the Long value for the id
	void deleteHospital(Long id); // DeleteHospital method which takes the id value 
	void updateHospital(Hospital hospital); // UpdateHospital method which takes in the hospital object
	Long getMaxHospitalID();	// Method that returns the maxhospitalid
	List<Hospital> getAllHospitals();	// Map object that has a vector of Integer and String values which getsAllHospitals
	List<ReportsHospital> getAllHospitalsReports(Long hospitalId);
	//Map<Integer, String> getHRP();
	Map<Long, String> getAllRegions();
}
