package com.packt.clubfootReg.domain;

public class User {
	private int id;
	private String user_name;
	private String email;
	private int hospital_id;
	private int role_id;
	
	public User() {
		
	}
	
	public User(int id, String userName, String email, int hospital_id, int role_id) {
		this.id = id;
		this.user_name = userName;
		this.email = email;
		this.hospital_id = hospital_id;
		this.role_id = role_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

}
