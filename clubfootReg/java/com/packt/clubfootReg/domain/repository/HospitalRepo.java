package com.packt.clubfootReg.domain.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;

public interface HospitalRepo {
	
	Hospital getHospital1(int id);
	void addHospital(Hospital hospital);
	void setDataSource(DataSource ds);
	List<Hospital> getHospital(int id);
	void deleteHospital(int id);
	void updateHospital(Hospital hospital);
	int getMaxHospitalID();
	Map<Integer, String> getAllHospitals();
}
