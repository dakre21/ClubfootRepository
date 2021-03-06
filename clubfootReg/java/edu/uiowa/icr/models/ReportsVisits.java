package edu.uiowa.icr.models;

public class ReportsVisits {

	private int id;
	private int hospitalId;
	private String complications;
	private String relapse;
	private String leftTreatment;
	private String rightTreatment;
	
	public ReportsVisits() {
		// TODO Auto-generated constructor stub
	}
	
	public ReportsVisits(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getComplications() {
		return complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public String getRelapse() {
		return relapse;
	}

	public void setRelapse(String relapse) {
		this.relapse = relapse;
	}

	public String getLeftTreatment() {
		return leftTreatment;
	}

	public void setLeftTreatment(String leftTreatment) {
		this.leftTreatment = leftTreatment;
	}

	public String getRightTreatment() {
		return rightTreatment;
	}

	public void setRightTreatment(String rightTreatment) {
		this.rightTreatment = rightTreatment;
	}

}
