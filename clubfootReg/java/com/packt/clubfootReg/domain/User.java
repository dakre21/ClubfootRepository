package com.packt.clubfootReg.domain;

/**
 * 
 * @author David
 * User model class that contains all the attributes to be added to the database and visible on the form.
 */
//User class
public class User {
	// Form attributes to by synchronized to the database
	private int id;
	private String user_name;
	private String email;
	private int hospital_id;
	private String hospital_name;
	private int role_id;
	private String role_name;
	
	public User() {
		
	}
	
	// User constructor that sets up the retriving information from the database via this model
	public User(int id, String userName, String email, int hospital_id, String hospital_name, int role_id, String role_name) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.user_name = userName;
		this.email = email;
		this.hospital_id = hospital_id;
		this.hospital_name = hospital_name;
		this.role_id = role_id;
		this.role_name = role_name;
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
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String userName) {
		this.user_name = userName;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	
	public String getHospital_name() {
		return hospital_name;
	}
	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}
	
	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
