package com.packt.clubfootReg.domain;

public class Visit {

	private int id;
	private String hospitalName;
	private String evaluatorName;
	private String dateOfVisit;
	private String finalTreatment;
	private String relapse;
	private String hindfootLeftVarus;
	private String hindfootRightVarus;
	private String hindfootLeftCavus;
	private String hindfootRightCavus;
	private String hindfootLeftAbductus;
	private String hindfootRightAbductus;
	private String hindfootLeftEquinus;
	private String hindfootRightEquinus;
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
	private String leftTreatment;
	private String rightTreatment;
	private String complications;
	private String comments;
	private String description;
	private String treatmentComplications;
	private String results;
	private String surgeryRight;
	private String rightSurgeryComments;
	private String otherRight;
	private String actionsRight;
	private String problemsRight;
	private String braceRight;
	private String dorsiflexionRight;
	private String abductionRight;
	private String castRightNum;
	private String casterRight;
	private String surgeryLeft;
	private String leftSurgeryComments;
	private String otherLeft;
	private String actionsLeft;
	private String problemsLeft;
	private String braceLeft;
	private String dorsiflexionLeft;
	private String abductionLeft;
	private String castLeftNum;
	private String casterLeft;
	
	
	public Visit() {
		// TODO Auto-generated constructor stub
	}
	
	public Visit(int id) {
		this.id = id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getCasterLeft(){
		return casterLeft;
	}
	public void setCasterLeft(String casterLeft){
		this.casterLeft = casterLeft;
	}
	public String getCastLeftNum(){
		return castLeftNum;
	}
	public void setCastLeftNum(String castLeftNum){
		this.castLeftNum = castLeftNum;
	}
	public String getAbductionLeft(){
		return abductionLeft;
	}
	public void setAbductionLeft(String abductionLeft){
		this.abductionLeft = abductionLeft;
	}
	public String getDorsiflexionLeft(){
		return dorsiflexionLeft;
	}
	public void setDorsiflexionLeft(String dorsiflexionLeft){
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
	public String getCasterRight(){
		return casterRight;
	}
	public void setCasterRight(String casterRight){
		this.casterRight = casterRight;
	}
	public String getCastRightNum(){
		return castRightNum;
	}
	public void setCastRightNum(String castRightNum){
		this.castRightNum = castRightNum;
	}
	public String getAbductionRight(){
		return abductionRight;
	}
	public void setAbductionRight(String abductionRight){
		this.abductionRight = abductionRight;
	}
	public String getDorsiflexionRight(){
		return dorsiflexionRight;
	}
	public void setDorsiflexionRight(String dorsiflexionRight){
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getEvaluatorName() {
		return evaluatorName;
	}

	public void setEvaluatorName(String evaluatorName) {
		this.evaluatorName = evaluatorName;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public String getFinalTreatment() {
		return finalTreatment;
	}

	public void setFinalTreatment(String finalTreatment) {
		this.finalTreatment = finalTreatment;
	}

	public String getRelapse() {
		return relapse;
	}

	public void setRelapse(String relapse) {
		this.relapse = relapse;
	}

	public String getHindfootLeftVarus() {
		return hindfootLeftVarus;
	}

	public void setHindfootLeftVarus(String hindfootLeftVarus) {
		this.hindfootLeftVarus = hindfootLeftVarus;
	}

	public String getHindfootRightVarus() {
		return hindfootRightVarus;
	}

	public void setHindfootRightVarus(String hindfootRightVarus) {
		this.hindfootRightVarus = hindfootRightVarus;
	}

	public String getHindfootLeftCavus() {
		return hindfootLeftCavus;
	}

	public void setHindfootLeftCavus(String hindfootLeftCavus) {
		this.hindfootLeftCavus = hindfootLeftCavus;
	}

	public String getHindfootRightCavus() {
		return hindfootRightCavus;
	}

	public void setHindfootRightCavus(String hindfootRightCavus) {
		this.hindfootRightCavus = hindfootRightCavus;
	}

	public String getHindfootLeftAbductus() {
		return hindfootLeftAbductus;
	}

	public void setHindfootLeftAbductus(String hindfootLeftAbductus) {
		this.hindfootLeftAbductus = hindfootLeftAbductus;
	}

	public String getHindfootRightAbductus() {
		return hindfootRightAbductus;
	}

	public void setHindfootRightAbductus(String hindfootRightAbductus) {
		this.hindfootRightAbductus = hindfootRightAbductus;
	}

	public String getHindfootLeftEquinus() {
		return hindfootLeftEquinus;
	}

	public void setHindfootLeftEquinus(String hindfootLeftEquinus) {
		this.hindfootLeftEquinus = hindfootLeftEquinus;
	}

	public String getHindfootRightEquinus() {
		return hindfootRightEquinus;
	}

	public void setHindfootRightEquinus(String hindfootRightEquinus) {
		this.hindfootRightEquinus = hindfootRightEquinus;
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
