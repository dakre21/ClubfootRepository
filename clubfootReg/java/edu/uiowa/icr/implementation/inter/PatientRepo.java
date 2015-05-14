package edu.uiowa.icr.implementation.inter;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import edu.uiowa.icr.models.ReportsHospital;
import edu.uiowa.icr.models.ReportsPatients;
import edu.uiowa.icr.models.Visit;
import edu.uiowa.icr.models.Patient;

/**
 * 
 * @author David
 * Interface for the newPatient Repository to synchronize data to the database via the following interface methods.
 */
public interface PatientRepo {
	//List <newPatient> getNewPatients();
	Patient getNewPatient(int id);
	void addPatient(Patient newpatient); // addPatient method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	Patient getPatient(int id); // getPatient method that passes the int value for the id
	List<Patient> getAllPatients(); // List object that contains the getAllPatients method
	void deletePatient(int id);	// DeletePatient method which takes the id value 
	void updatePatient(Patient newpatient); // UpdatePatient method which takes in the patient object
	int getMaxPersonID();	// Method that returns the maxpersonid
	int getAddressIDForPerson(int id);	// Method that returns maxaddressidforperson
	int getMaxAddressID();// Method that returns the maxaddressid
	int[] getAssociateIDsForPatient(int id);	// Method that returns associateidforpatient
	void addPhoto(byte[] bytes);
	List<Patient> getAllPatientsReports(ReportsPatients filters);
	Map<Integer, String> getAllHospitals();
	Map<Integer, String> getAllEvaluators();
	List<Visit> getVisitsForPatient(int patientId);
}
