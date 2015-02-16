package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.newPatient;

public interface newPatientRepo {
	//List <newPatient> getNewPatients();
	newPatient getNewPatient(int id);
	void addPatient(newPatient newpatient);
	void setDataSource(DataSource ds);
	List<newPatient> getPatient(int id);
	List<newPatient> getAllPatients();
	void deletePatient(int id);
	void updatePatient(newPatient newpatient);
	int getMaxPatientID();
}
