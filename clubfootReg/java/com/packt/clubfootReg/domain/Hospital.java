package com.packt.clubfootReg.domain;

public class Hospital {

	private String hospitalName;
	private int hospitalRegionId;
	private int id;
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	public Hospital(int id, String name, int region_id){
		this.id = id;
		this.hospitalName = name;
		this.hospitalRegionId = region_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getHospitalRegionId() {
		return hospitalRegionId;
	}

	public void setHospitalRegionId(int hospitalRegion) {
		this.hospitalRegionId = hospitalRegion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
