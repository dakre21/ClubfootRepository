package com.packt.clubfootReg.domain;

public class User {
	private String userName;
	private String hospitalName;
	private int id;
	private int user_id;
	
	public User(){
		
	}
	public User(int id, String userName, String hospitalName, int user_id) {
		this.id = id;
		this.userName = userName;
		this.hospitalName = hospitalName;
		this.user_id = user_id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
