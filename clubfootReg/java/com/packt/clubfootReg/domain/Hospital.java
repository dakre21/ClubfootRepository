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
	private String name;
	private int region_id;
	private String region_name;
	
	
	public Hospital() {
		// TODO Auto-generated constructor stub
	}
	
	// Hospital constructor that sets up the retriving information from the database via this model
	public Hospital(int id, String name, int region_id, String region_name){
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.name = name;
		this.region_id = region_id;
		this.region_name = region_name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */

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

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String regionName) {
		this.region_name = regionName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
