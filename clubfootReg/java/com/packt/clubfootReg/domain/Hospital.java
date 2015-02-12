package com.packt.clubfootReg.domain;

public class Hospital {
	
	private int id;
	private String name;
	private int region_id;
	
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	public Hospital(int id, String name, int region_id){
		this.id = id;
		this.name = name;
		this.region_id = region_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public void setName(String hospitalName) {
		this.name = hospitalName;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int hospitalRegion) {
		this.region_id = hospitalRegion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
