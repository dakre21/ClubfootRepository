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
	private String firstName;
	private String middleName;
	private String lastName;
	private String title;
	private String hospitalName;
	private int hospitalId;
	
	public Evaluator() {
		
	}
	
	// Evaluator constructor that sets up the retriving information from the database via this model
	public Evaluator(int id, String firstName, String lastName, String middleName, String title, String hospitalName, int hospitalId) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.title = title;
		this.hospitalName = hospitalName;
		this.hospitalId = hospitalId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHospitalName() {
		return hospitalName;
	}
	
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

}
