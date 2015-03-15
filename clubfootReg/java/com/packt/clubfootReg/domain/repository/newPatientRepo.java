package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.newPatient;

/**
 * 
 * @author David
 * Interface for the newPatient Repository to synchronize data to the database via the following interface methods.
 */
public interface newPatientRepo {
	//List <newPatient> getNewPatients();
	newPatient getNewPatient(int id);
	void addPatient(newPatient newpatient); // addPatient method to add the model data to the database
	void setDataSource(DataSource ds); // Sets up the dataSource for the database synch
	newPatient getPatient(int id); // getPatient method that passes the int value for the id
	List<newPatient> getAllPatients(); // List object that contains the getAllPatients method
	void deletePatient(int id);	// DeletePatient method which takes the id value 
	void updatePatient(newPatient newpatient); // UpdatePatient method which takes in the patient object
	int getMaxPersonID();	// Method that returns the maxpersonid
	int getAddressIDForPerson(int id);	// Method that returns maxaddressidforperson
	int getMaxAddressID();// Method that returns the maxaddressid
	int[] getAssociateIDsForPatient(int id);	// Method that returns associateidforpatient
}
