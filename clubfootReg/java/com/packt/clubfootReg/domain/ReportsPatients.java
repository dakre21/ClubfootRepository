package com.packt.clubfootReg.domain;

public class ReportsPatients {

	private int id;
	private String sex;
	private String race;
	private String relatives;
	private int hospital_id;
	private String dobSel;
	private String dob;
	private String eval_dateSel;
	private String eval_date;
	
	public ReportsPatients() {
		// TODO Auto-generated constructor stub
	}
	
	public ReportsPatients(int id) {
		this.id = id;
	}

	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	
	
	public String getRelatives() {
		return relatives;
	}
	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}
	
	
	public int getHospital_id() {
		return hospital_id;
	}
	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
	
	
	public String getDobSel() {
		return dobSel;
	}
	public void setDobSel(String dobSel) {
		this.dobSel = dobSel;
	}
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	public String getEval_dateSel() {
		return eval_dateSel;
	}
	public void setEval_dateSel(String eval_dateSel) {
		this.eval_dateSel = eval_dateSel;
	}
	
	
	public String getEval_date() {
		return eval_date;
	}
	public void setEval_date(String eval_date) {
		this.eval_date = eval_date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
