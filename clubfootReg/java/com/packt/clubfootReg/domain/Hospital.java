package com.packt.clubfootReg.domain;

/**
 * 
 * @author David
 * Hospital model class that contains all the attributes to be added to the database and visible on the form.
 */
//Hospital class
public class Hospital {
	
	// Form attributes to by synchronized to the database
	private int id;
	private String hospitalName;
	private int regionId;
	private String regionName;
	
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	
	// Hospital constructor that sets up the retriving information from the database via this model
	public Hospital(int id, String hospitalName, int regionId, String regionName){
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.hospitalName = hospitalName;
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
