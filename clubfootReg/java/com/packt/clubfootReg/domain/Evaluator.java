package com.packt.clubfootReg.domain;

/**
 * 
 * @author David
 * Evaluator model class that contains all the attributes to be added to the database and visible on the form.
 */

// Evaluator class
public class Evaluator {

	// Form attributes to by synchronized to the database
	private int id;	
	private String first_name;
	private String middle_name;
	private String last_name;
	private String title;
	private String hospital_name;
	private int hospital_id;
	
	public Evaluator() {
		
	}
	
	// Evaluator constructor that sets up the retriving information from the database via this model
	public Evaluator(int id, String first, String last, String middle, String title, String hospName, int hosp) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.first_name = first;
		this.last_name = last;
		this.middle_name = middle;
		this.title = title;
		this.hospital_name = hospName;
		this.hospital_id = hosp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHospital_name() {
		return hospital_name;
	}
	
	public void setHospital_name(String name) {
		this.hospital_name = name;
	}
	
	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital) {
		this.hospital_id = hospital;
	}

}
