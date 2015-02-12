package com.packt.clubfootReg.domain;

public class Evaluator {

	private int id;
	private String first_name;
	private String middle_name;
	private String last_name;
	private String title;
	private int hospital_id;
	
	public Evaluator() {
		
	}
	
	public Evaluator(int id, String first, String last, String middle, String title, int hosp) {
		this.id = id;
		this.first_name = first;
		this.last_name = last;
		this.middle_name = middle;
		this.title = title;
		this.hospital_id = hosp;
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

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital) {
		this.hospital_id = hospital;
	}

}
