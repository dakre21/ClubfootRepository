package com.packt.clubfootReg.domain.repository;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.Visit;

public interface VisitRepo {
	void addVisit(Visit visit);
	void setDataSource(DataSource ds);
	List<Visit> getVisit(int id);
	void deleteVisit(int id);
	List<Visit> getAllVisits();
	void updateVisit(Visit visit);
	int getMaxVisitId();
	int getMaxFootId();
	Map<Integer, String> getAllHospitals();
}