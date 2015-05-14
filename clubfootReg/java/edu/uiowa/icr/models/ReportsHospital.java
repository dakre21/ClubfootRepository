package edu.uiowa.icr.models;

public class ReportsHospital {

	private int id;
	private String hospitalName;
	private String regionName;
	private int numOfPatients;
	private int numOfMales;
	private int numOfFemales;
	private int latLeft;
	private int latRight;
	private int latUni;
	private int latBi;
	private int affectedRels;
	private int affectedRelsNot;
	private int affectedRelsIDK;
	private int numOfVisits;
	private int treatmentC;
	private int treatmentB;
	private int treatmentT;
	
	public ReportsHospital() {
		// TODO Auto-generated constructor stub
	}

	public ReportsHospital(String hospitalName, String regionName, int numOfPatients) {
		this.hospitalName = hospitalName;
		this.regionName = regionName;
		this.numOfPatients = numOfPatients;
	}
	
	
	public int getTreatmentC() {
		return treatmentC;
	}
	public void setTreatmentC(int treatmentC) {
		this.treatmentC = treatmentC;
	}
	
	
	public int getTreatmentB() {
		return treatmentB;
	}
	public void setTreatmentB(int treatmentB) {
		this.treatmentB = treatmentB;
	}
	
	
	public int getTreatmentT() {
		return treatmentT;
	}
	public void setTreatmentT(int treatmentT) {
		this.treatmentT = treatmentT;
	}
	
	
	public int getNumOfVisits() {
		return numOfVisits;
	}
	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}
	
	
	public int getAffectedRels() {
		return affectedRels;
	}
	public void setAffectedRels(int affectedRels) {
		this.affectedRels = affectedRels;
	}
	
	
	public int getAffectedRelsNot() {
		return affectedRelsNot;
	}
	public void setAffectedRelsNot(int affectedRelsNot) {
		this.affectedRelsNot = affectedRelsNot;
	}
	
	
	public int getAffectedRelsIDK() {
		return affectedRelsIDK;
	}
	public void setAffectedRelsIDK(int affectedRelsIDK) {
		this.affectedRelsIDK = affectedRelsIDK;
	}
	
	
	public int getLatLeft() {
		return latLeft;
	}
	public void setLatLeft(int latLeft) {
		this.latLeft = latLeft;
	}
	
	
	public int getLatRight() {
		return latRight;
	}
	public void setLatRight(int latRight) {
		this.latRight = latRight;
	}
	
	
	public int getLatUni() {
		return latUni;
	}
	public void setLatUni(int latUni) {
		this.latUni = latUni;
	}
	
	
	public int getLatBi() {
		return latBi;
	}
	public void setLatBi(int latBi) {
		this.latBi = latBi;
	}
	
	
	public int getNumOfMales() {
		return numOfMales;
	}
	public void setNumOfMales(int numOfMales) {
		this.numOfMales = numOfMales;
	}
	
	
	public int getNumOfFemales() {
		return numOfFemales;
	}
	public void setNumOfFemales(int numOfFemales) {
		this.numOfFemales = numOfFemales;
	}
	
	
	public int getNumOfPatients() {
		return numOfPatients;
	}
	public void setNumOfPatients(int numOfPatients) {
		this.numOfPatients = numOfPatients;
	}

	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
