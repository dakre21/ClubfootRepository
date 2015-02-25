package com.packt.clubfootReg.domain.repository;

import java.util.List;

import javax.sql.DataSource;

import com.packt.clubfootReg.domain.Hospital;
import com.packt.clubfootReg.domain.Visit;

public interface VisitRepo {
	
	Visit getVisit1(int id);
	void addVisit(Visit visit);
	void setDataSource(DataSource ds);
	List<Visit> getVisit(int id);
	void deleteVisit(int id);
	List<Visit> getAllVisits();
	void updateVisit(Visit visit);
	int getMaxVisitId();

}