package edu.uiowa.icr.models;

public class ReportsPatients {

	private int id;
	private String sex;
	private String race;
	private String relatives;
	private int hospitalId;
	private String dobSel;
	private String dob;
	private String evalDateSel;
	private String evalDate;
	
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
	
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
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
	
	
	public String getEvalDateSel() {
		return evalDateSel;
	}
	public void setEvalDateSel(String evalDateSel) {
		this.evalDateSel = evalDateSel;
	}
	
	
	public String getEvalDate() {
		return evalDate;
	}
	public void setEvalDate(String evalDate) {
		this.evalDate = evalDate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
