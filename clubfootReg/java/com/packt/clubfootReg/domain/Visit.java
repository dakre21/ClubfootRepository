package com.packt.clubfootReg.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author David
 * Visit model class that contains all the attributes to be added to the database and visible on the form.
 */
//Visit class
public class Visit {

	// Form attributes to by synchronized to the database
	private int id;
	
	private int patientId;
	private Integer hospitalId;
	private Integer evaluatorId;
	private String dateOfVisit;
	private String isLastVisit;
	private String nextVisitDate;
	private String relapse;
	
	private Integer hindfootLeftVarus;
	private Integer hindfootLeftCavus;
	private Integer hindfootLeftAbductus;
	private Integer hindfootLeftEquinus;
	private Integer leftPC;
	private Integer leftEH;
	private Integer leftRE;
	private Integer leftMC;
	private Integer leftTHC;
	private Integer leftCLB;
	private String leftTreatment;
	
	private Integer casterLeft;
	private Integer castLeftNum;
	private Integer abductionLeft;
	private Integer dorsiflexionLeft;
	private String braceLeft;
	private String problemsLeft;
	private String actionsLeft;
	private String surgeryLeft;
	private String leftSurgeryComments;
	private String otherLeft;
	
	private Integer hindfootRightVarus;
	private Integer hindfootRightCavus;
	private Integer hindfootRightAbductus;
	private Integer hindfootRightEquinus;
	private Integer rightPC;
	private Integer rightEH;
	private Integer rightRE;
	private Integer rightMC;
	private Integer rightTHC;
	private Integer rightCLB;
	private String rightTreatment;
	
	private Integer casterRight;
	private Integer castRightNum;
	private Integer abductionRight;
	private Integer dorsiflexionRight;
	private String braceRight;
	private String problemsRight;
	private String actionsRight;
	private String surgeryRight;
	private String rightSurgeryComments;
	private String otherRight;
	
	//private String hindfootLeftVarus;
	//private String hindfootRightVarus;
	//private String hindfootLeftCavus;
	//private String hindfootRightCavus;
	//private String hindfootLeftAbductus;
	//private String hindfootRightAbductus;
	//private String hindfootLeftEquinus;
	//private String hindfootRightEquinus;
	private String midfootLeftPosterior;
	private String midfootRightPosterior;
	private String midfootLeftHeel;
	private String midfootRightHeel;
	private String midfootLeftEquinus;
	private String midfootRightEquinus;
	private String midfootLeftMedial;
	private String midfootRightMedial;
	private String midfootLeftTalar;
	private String midfootRightTalar;
	private String midfootLeftLateral;
	private String midfootRightLateral;
	
	private String complications;
	private String comments;
	private String description;
	private String treatmentComplications;
	private String results;
	private String laterality;
	
	public Visit() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */
	
	// Visit constructor that sets up the retriving information from the database via this model
	public Visit(int patientId) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.patientId = patientId;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String getLaterality(){
		return laterality;
	}
	public void setLaterality(String laterality){
		this.laterality = laterality;
	}
	
	public Integer getCasterLeft(){
		return casterLeft;
	}
	public void setCasterLeft(Integer casterLeft){
		this.casterLeft = casterLeft;
	}
	public Integer getCastLeftNum(){
		return castLeftNum;
	}
	public void setCastLeftNum(Integer castLeftNum){
		this.castLeftNum = castLeftNum;
	}
	public Integer getAbductionLeft(){
		return abductionLeft;
	}
	public void setAbductionLeft(Integer abductionLeft){
		this.abductionLeft = abductionLeft;
	}
	public Integer getDorsiflexionLeft(){
		return dorsiflexionLeft;
	}
	public void setDorsiflexionLeft(Integer dorsiflexionLeft){
		this.dorsiflexionLeft = dorsiflexionLeft;
	}
	public String getBraceLeft(){
		return braceLeft;
	}
	public void setBraceLeft(String braceLeft){
		this.braceLeft = braceLeft;
	}
	public String getProblemsLeft(){
		return problemsLeft;
	}
	public void setProblemsLeft(String problemsLeft){
		this.problemsLeft = problemsLeft;
	}
	public String getActionsLeft(){
		return actionsLeft;
	}
	public void setActionsLeft(String actionsLeft){
		this.actionsLeft = actionsLeft;
	}
	public String getOtherLeft(){
		return otherLeft;
	}
	public void setOtherLeft(String otherLeft){
		this.otherLeft = otherLeft;
	}
	public String getLeftSurgeryComments(){
		return leftSurgeryComments;
	}

	public void setLeftSurgeryComments(String leftSurgeryComments){
		this.leftSurgeryComments = leftSurgeryComments;
	}
	public String getSurgeryLeft(){
		return surgeryLeft;
	}
	public void setSurgeryLeft(String surgeryLeft){
		this.surgeryLeft = surgeryLeft;
	}
	public Integer getCasterRight(){
		return casterRight;
	}
	public void setCasterRight(Integer casterRight){
		this.casterRight = casterRight;
	}
	public Integer getCastRightNum(){
		return castRightNum;
	}
	public void setCastRightNum(Integer castRightNum){
		this.castRightNum = castRightNum;
	}
	public Integer getAbductionRight(){
		return abductionRight;
	}
	public void setAbductionRight(Integer abductionRight){
		this.abductionRight = abductionRight;
	}
	public Integer getDorsiflexionRight(){
		return dorsiflexionRight;
	}
	public void setDorsiflexionRight(Integer dorsiflexionRight){
		this.dorsiflexionRight = dorsiflexionRight;
	}
	public String getBraceRight(){
		return braceRight;
	}
	public void setBraceRight(String braceRight){
		this.braceRight = braceRight;
	}
	public String getProblemsRight(){
		return problemsRight;
	}
	public void setProblemsRight(String problemsRight){
		this.problemsRight = problemsRight;
	}
	public String getActionsRight(){
		return actionsRight;
	}
	public void setActionsRight(String actionsRight){
		this.actionsRight = actionsRight;
	}
	public String getOtherRight(){
		return otherRight;
	}
	public void setOtherRight(String otherRight){
		this.otherRight = otherRight;
	}
	public String getRightSurgeryComments(){
		return rightSurgeryComments;
	}

	public void setRightSurgeryComments(String rightSurgeryComments){
		this.rightSurgeryComments = rightSurgeryComments;
	}
	public String getSurgeryRight(){
		return surgeryRight;
	}
	public void setSurgeryRight(String surgeryRight){
		this.surgeryRight = surgeryRight;
	}
	public String getResults(){
		return results;
	}
	public void setResults(String results){
		this.results = results;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getTreatmentComplications(){
		return treatmentComplications;
	}
	public void setTreatmentComplications(String treatmentComplications){
		this.treatmentComplications = treatmentComplications;
	}
	public String getComments(){
		return comments;
	}
	public void setComments(String comments){
		this.comments = comments;
	}
	public String getComplications(){
		return complications;
	}
	public void setComplications(String complications){
		this.complications = complications;
	}
	public String getRightTreatment(){
		return rightTreatment;
	}
	public void setRightTreatment(String rightTreatment){
		this.rightTreatment = rightTreatment;
	}
	public String getLeftTreatment(){
		return leftTreatment;
	}
	public void setLeftTreatment(String leftTreatment){
		this.leftTreatment = leftTreatment;
	}
	public String getMidfootRightLateral(){
		return midfootRightLateral;
	}
	public void setMidfootRightLateral(String midfootRightLateral){
		this.midfootRightLateral = midfootRightLateral;
	}
	public String getMidfootLeftLateral(){
		return midfootLeftLateral;
	}
	public void setMidfootLeftLateral(String midfootLeftLateral){
		this.midfootLeftLateral = midfootLeftLateral;
	}
	public String getMidfootRightTalar(){
		return midfootRightTalar;
	}
	public void setMidfootRightTalar(String midfootRightTalar){
		this.midfootRightTalar = midfootRightTalar;
	}
	public String getMidfootLeftTalar(){
		return midfootLeftTalar;
	}
	public void setMidfootLeftTalar(String midfootLeftTalar){
		this.midfootLeftTalar = midfootLeftTalar;
	}
	public String getMidfootRightMedial(){
		return midfootRightMedial;
	}
	public void setMidfootRightMedial(String midfootRightMedial){
		this.midfootRightMedial = midfootRightMedial;
	}
	public String getMidfootLeftMedial(){
		return midfootLeftMedial;
	}
	public void setMidfootLeftMedial(String midfootLeftMedial){
		this.midfootLeftMedial = midfootLeftMedial;
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getEvaluatorId() {
		return evaluatorId;
	}

	public void setEvaluatorId(Integer evaluatorId) {
		this.evaluatorId = evaluatorId;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getIsLastVisit() {
		return isLastVisit;
	}

	public void setIsLastVisit(String isLastVisit) {
		this.isLastVisit = isLastVisit;
	}
	
	public String getNextVisitDate() {
		return nextVisitDate;
	}
	
	public void setNextVisitDate(String nextVisitDate) {
		this.nextVisitDate = nextVisitDate;
	}

	public String getRelapse() {
		return relapse;
	}

	public void setRelapse(String relapse) {
		this.relapse = relapse;
	}

	public Integer getHindfootLeftVarus() {
		return hindfootLeftVarus;
	}

	public void setHindfootLeftVarus(Integer hindfootLeftVarus) {
		this.hindfootLeftVarus = hindfootLeftVarus;
	}

	public Integer getHindfootRightVarus() {
		return hindfootRightVarus;
	}

	public void setHindfootRightVarus(Integer hindfootRightVarus) {
		this.hindfootRightVarus = hindfootRightVarus;
	}

	public Integer getHindfootLeftCavus() {
		return hindfootLeftCavus;
	}

	public void setHindfootLeftCavus(Integer hindfootLeftCavus) {
		this.hindfootLeftCavus = hindfootLeftCavus;
	}

	public Integer getHindfootRightCavus() {
		return hindfootRightCavus;
	}

	public void setHindfootRightCavus(Integer hindfootRightCavus) {
		this.hindfootRightCavus = hindfootRightCavus;
	}

	public Integer getHindfootLeftAbductus() {
		return hindfootLeftAbductus;
	}

	public void setHindfootLeftAbductus(Integer hindfootLeftAbductus) {
		this.hindfootLeftAbductus = hindfootLeftAbductus;
	}

	public Integer getHindfootRightAbductus() {
		return hindfootRightAbductus;
	}

	public void setHindfootRightAbductus(Integer hindfootRightAbductus) {
		this.hindfootRightAbductus = hindfootRightAbductus;
	}

	public Integer getHindfootLeftEquinus() {
		return hindfootLeftEquinus;
	}

	public void setHindfootLeftEquinus(Integer hindfootLeftEquinus) {
		this.hindfootLeftEquinus = hindfootLeftEquinus;
	}

	public Integer getHindfootRightEquinus() {
		return hindfootRightEquinus;
	}

	public void setHindfootRightEquinus(Integer hindfootRightEquinus) {
		this.hindfootRightEquinus = hindfootRightEquinus;
	}
	
	public Integer getLeftPC() {
		return leftPC;
	}
	public void setLeftPC(Integer leftPC) {
		this.leftPC = leftPC;
	}
	
	public Integer getLeftEH() {
		return leftEH;
	}
	public void setLeftEH(Integer leftEH) {
		this.leftEH = leftEH;
	}
	
	public Integer getLeftRE() {
		return leftRE;
	}
	public void setLeftRE(Integer leftRE) {
		this.leftRE = leftRE;
	}
	
	public Integer getLeftMC() {
		return leftMC;
	}
	public void setLeftMC(Integer leftMC) {
		this.leftMC = leftMC;
	}
	
	public Integer getLeftTHC() {
		return leftTHC;
	}
	public void setLeftTHC(Integer leftTHC) {
		this.leftTHC = leftTHC;
	}
	
	public Integer getLeftCLB() {
		return leftCLB;
	}
	public void setLeftCLB(Integer leftCLB) {
		this.leftCLB = leftCLB;
	}
	
	
	public Integer getRightPC() {
		return rightPC;
	}
	public void setRightPC(Integer rightPC) {
		this.rightPC = rightPC;
	}
	
	public Integer getRightEH() {
		return rightEH;
	}
	public void setRightEH(Integer rightEH) {
		this.rightEH = rightEH;
	}
	
	public Integer getRightRE() {
		return rightRE;
	}
	public void setRightRE(Integer rightRE) {
		this.rightRE = rightRE;
	}
	
	public Integer getRightMC() {
		return rightMC;
	}
	public void setRightMC(Integer rightMC) {
		this.rightMC = rightMC;
	}
	
	public Integer getRightTHC() {
		return rightTHC;
	}
	public void setRightTHC(Integer rightTHC) {
		this.rightTHC = rightTHC;
	}
	
	public Integer getRightCLB() {
		return rightCLB;
	}
	public void setRightCLB(Integer rightCLB) {
		this.rightCLB = rightCLB;
	}
	
	
	public String getMidfootLeftPosterior() {
		return midfootLeftPosterior;
	}

	public void setMidfootLeftPosterior(String midfootLeftPosterior) {
		this.midfootLeftPosterior = midfootLeftPosterior;
	}

	public String getMidfootRightPosterior() {
		return midfootRightPosterior;
	}

	public void setMidfootRightPosterior(String midfootRightPosterior) {
		this.midfootRightPosterior = midfootRightPosterior;
	}

	public String getMidfootLeftHeel() {
		return midfootLeftHeel;
	}

	public void setMidfootLeftHeel(String midfootLeftHeel) {
		this.midfootLeftHeel = midfootLeftHeel;
	}

	public String getMidfootRightHeel() {
		return midfootRightHeel;
	}

	public void setMidfootRightHeel(String midfootRightHeel) {
		this.midfootRightHeel = midfootRightHeel;
	}

	public String getMidfootLeftEquinus() {
		return midfootLeftEquinus;
	}

	public void setMidfootLeftEquinus(String midfootLeftEquinus) {
		this.midfootLeftEquinus = midfootLeftEquinus;
	}

	public String getMidfootRightEquinus() {
		return midfootRightEquinus;
	}

	public void setMidfootRightEquinus(String midfootRightEquinus) {
		this.midfootRightEquinus = midfootRightEquinus;
	}

}
