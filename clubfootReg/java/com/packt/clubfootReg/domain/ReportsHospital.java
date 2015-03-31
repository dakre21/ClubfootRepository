package com.packt.clubfootReg.domain;

public class ReportsHospital {

	private int id;
	private String hospitalName;
	private String regionName;
	private int numOfPatients;
	
	public ReportsHospital() {
		// TODO Auto-generated constructor stub
	}

	public ReportsHospital(String hospitalName, String regionName, int numOfPatients) {
		this.hospitalName = hospitalName;
		this.regionName = regionName;
		this.numOfPatients = numOfPatients;
	}
	public int getNumOfPatients() {
		return numOfPatients;
	}

	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

}
