package com.packt.clubfootReg.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 
 * @author David
 * newPatient model class that contains all the attributes to be added to the database and visible on the form.
 */
//newPatient class
public class newPatient {
	// Form attributes to by synchronized to the database
	private int id;
	private Integer guardianConsent;
	private Integer photoConsent;
	private Integer hospital;
	private String patientLastName;
	private String patientFirstName;
	private String patientMiddleName;
	private String sex;
	private String race;
	private String tribe;
	private String dob;
	private String addr1;
	private String addr2;
	private String village;
	private String province;
	private String country;
	private String guardianLastName;
	private String guardianFirstName;
	private String guardianMiddleName;
	private String guardianRelationship;
	private String guardianPhone1;
	private String guardianPhone2;
	private String secondGuardianLast;
	private String secondGuardianFirst;
	private String secondGuardianMiddle;
	private String secondGuardianRelationship;
	private String secondGuardianPhone1;
	private String secondGuardianPhone2;
	private String emergencyContact;
	private String otherGuardianLast;
	private String otherGuardianFirst;
	private String otherGuardianMiddle;
	private String otherGuardianRelationship;
	private String otherGuardianPhone1;
	private String otherGuardianPhone2;
	private String deformityHistory;
	private Integer deformityHistoryNum;
	private Integer pregnancy;
	private String pregnancyComplicationsExplained;
	private String pregnancyAlc; 
	private String pregnancySmoke; 
	private String complications; 
	private Integer placeBirth;
	private String referral;
	private String referralDocName;
	private String referralHospitalName;
	private String referralOther;
	private Integer evaluator;
	private String evaluationDate;
	private String feet;
	private String diagnosis;
	private String deformityAtBirth; 
	private String previousTreatments; 
	private String previousTreatmentsNum;
	private String diagnosisPrenatally; 
	private Integer diagnosisPrenatallyWeek;
	private String prenatallyDiagConfirmation; 
	private String diagnosisComments;
	private String abnormalities;
	private String weakness;
	private CommonsMultipartFile fileName;

	public newPatient() {
		super();
	}
	
	// newPatient constructor that sets up the retriving information from the database via this model
	public newPatient(int id, Integer guardianConsent, Integer photoConsent, Integer hospital, String patientFirstName, 
			          String patientLastName, String patientMiddleName, String dob, Integer evaluator,
			          String evaluationDate, String feet, String diagnosis) {
		// Sets current object "this" to the value being passed when this model is being instantiated 
		this.id = id;
		this.guardianConsent = guardianConsent;
		this.photoConsent = photoConsent;
		this.hospital = hospital;
		this.patientFirstName = patientFirstName;
		this.patientLastName = patientLastName;
		this.patientMiddleName = patientMiddleName;
		this.dob = dob;
		this.evaluator = evaluator;
		this.evaluationDate = evaluationDate;
		this.feet = feet;
		this.diagnosis = diagnosis;
	}
	
	
	/**
	 * 
	 * Getter and setter methods for all of the forms attributes. These get the value being passed into the model, and effectively set
	 * the value to the model attribute to be synchronized to the database (visa versa for pull requests). 
	 */
	
	public Integer getGuardianConsent() {
		return guardianConsent;
	}
	public void setGuardianConsent(Integer guardianConsent) {
		this.guardianConsent = guardianConsent;
	}
	
	
	public Integer getPhotoConsent() {
		return photoConsent;
	}
	public void setPhotoConsent(Integer photoConsent) {
		this.photoConsent = photoConsent;
	}
	
	
	public Integer getHospital() {
		return hospital;
	}
	public void setHospital(Integer hospital) {
		this.hospital = hospital;
	}
	
	
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	
	public String getPatientMiddleName() {
		return patientMiddleName;
	}
	public void setPatientMiddleName(String patientMiddleName) {
		this.patientMiddleName = patientMiddleName;
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
	
	
	public String getTribe() {
		return tribe;
	}
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}

	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public String getGuardianLastName() {
		return guardianLastName;
	}
	public void setGuardianLastName(String guardianLastName) {
		this.guardianLastName = guardianLastName;
	}
	
	
	public String getGuardianFirstName() {
		return guardianFirstName;
	}
	public void setGuardianFirstName(String guardianFirstName) {
		this.guardianFirstName = guardianFirstName;
	}
	
	
	public String getGuardianMiddleName() {
		return guardianMiddleName;
	}
	public void setGuardianMiddleName(String guardianMiddleName) {
		this.guardianMiddleName = guardianMiddleName;
	}
	
	
	public String getGuardianRelationship() {
		return guardianRelationship;
	}
	public void setGuardianRelationship(String guardianRelationship) {
		this.guardianRelationship = guardianRelationship;
	}
	
	
	public String getGuardianPhone1() {
		return guardianPhone1;
	}
	public void setGuardianPhone1(String guardianPhone1) {
		this.guardianPhone1 = guardianPhone1;
	}
	
	
	public String getGuardianPhone2() {
		return guardianPhone2;
	}
	public void setGuardianPhone2(String guardianPhone2) {
		this.guardianPhone2 = guardianPhone2;
	}
	
	
/*
	public MultipartFile getPre_imgfile() {
		return pre_imgfile;
	}
	
	public void setPre_imgfile(MultipartFile pre_imgfile) {
		this.pre_imgfile = pre_imgfile;
	}
*/
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	public String getGuardian_check() {
		return guardian_check;
	}
	public void setGuardian_check(String guardian_check) {
		this.guardian_check = guardian_check;
	}
	*/
	
	
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
	public String getDeformityHistory() {
		return deformityHistory;
	}
	public void setDeformityHistory(String deformityHistory) {
		this.deformityHistory = deformityHistory;
	}
	
	
	public Integer getPregnancy() {
		return pregnancy;
	}
	public void setPregnancy(Integer pregnancy) {
		this.pregnancy = pregnancy;
	}
	
	
	public String getPregnancyComplicationsExplained() {
		return pregnancyComplicationsExplained;
	}
	public void setPregnancyComplicationsExplained(String pregnancyComplicationsExplained) {
		this.pregnancyComplicationsExplained = pregnancyComplicationsExplained;
	}
	
	
	public String getPregnancyAlc() {
		return pregnancyAlc;
	}
	public void setPregnancyAlc(String pregnancyAlc) {
		this.pregnancyAlc = pregnancyAlc;
	}
	
	
	public String getPregnancySmoke() {
		return pregnancySmoke;
	}
	public void setPregnancySmoke(String pregnancySmoke) {
		this.pregnancySmoke = pregnancySmoke;
	}
	
	
	public String getComplications() {
		return complications;
	}
	public void setComplications(String complications) {
		this.complications = complications;
	}
	
	
	public Integer getPlaceBirth() {
		return placeBirth;
	}
	public void setPlaceBirth(Integer placeBirth) {
		this.placeBirth = placeBirth;
	}
	
	
	public String getReferral() {
		return referral;
	}
	public void setReferral(String referral) {
		this.referral = referral;
	}
	
	
	public Integer getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(Integer evaluator) {
		this.evaluator = evaluator;
	}
	
	
	public String getEvaluationDate() {
		return evaluationDate;
	}
	public void setEvaluationDate(String evaluationDate) {
		this.evaluationDate = evaluationDate;
	}
	
	
	public String getFeet() {
		return feet;
	}
	public void setFeet(String feet) {
		this.feet = feet;
	}
	
	
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	
	public String getDeformityAtBirth() {
		return deformityAtBirth;
	}
	public void setDeformityAtBirth(String deformityAtBirth) {
		this.deformityAtBirth = deformityAtBirth;
	}
	
	
	public String getPreviousTreatments() {
		return previousTreatments;
	}
	public void setPreviousTreatments(String previousTreatments) {
		this.previousTreatments = previousTreatments;
	}
	
	
	public String getDiagnosisPrenatally() {
		return diagnosisPrenatally;
	}
	public void setDiagnosisPrenatally(String diagnosisPrenatally) {
		this.diagnosisPrenatally = diagnosisPrenatally;
	}
	
	
	public String getPrenatallyDiagConfirmation() {
		return prenatallyDiagConfirmation;
	}
	public void setPrenatallyDiagConfirmation(String prenatallyDiagConfirmation) {
		this.prenatallyDiagConfirmation = prenatallyDiagConfirmation;
	}
	
	
	public String getDiagnosisComments() {
		return diagnosisComments;
	}
	public void setDiagnosisComments(String diagnosisComments) {
		this.diagnosisComments = diagnosisComments;
	}
	
	
	public String getAbnormalities() {
		return abnormalities;
	}
	public void setAbnormalities(String abnormalities) {
		this.abnormalities = abnormalities;
	}
	
	
	public String getWeakness() {
		return weakness;
	}
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	
	
	public String getSecondGuardianLast() {
		return secondGuardianLast;
	}
	public void setSecondGuardianLast(String secondGuardianLast) {
		this.secondGuardianLast = secondGuardianLast;
	}
	
	
	public String getSecondGuardianFirst() {
		return secondGuardianFirst;
	}
	public void setSecondGuardianFirst(String secondGuardianFirst) {
		this.secondGuardianFirst = secondGuardianFirst;
	}
	
	
	public String getSecondGuardianMiddle() {
		return secondGuardianMiddle;
	}
	public void setSecondGuardianMiddle(String secondGuardianMiddle) {
		this.secondGuardianMiddle = secondGuardianMiddle;
	}
	
	
	public String getSecondGuardianRelationship() {
		return secondGuardianRelationship;
	}
	public void setSecondGuardianRelationship(
			String secondGuardianRelationship) {
		this.secondGuardianRelationship = secondGuardianRelationship;
	}
	
	
	public String getSecondGuardianPhone1() {
		return secondGuardianPhone1;
	}
	public void setSecondGuardianPhone1(String secondGuardianPhone1) {
		this.secondGuardianPhone1 = secondGuardianPhone1;
	}
	
	
	public String getSecondGuardianPhone2() {
		return secondGuardianPhone2;
	}
	public void setSecondGuardianPhone2(String secondGuardianPhone2) {
		this.secondGuardianPhone2 = secondGuardianPhone2;
	}
	
	
	public String getOtherGuardianLast() {
		return otherGuardianLast;
	}
	public void setOtherGuardianLast(String otherGuardianLast) {
		this.otherGuardianLast = otherGuardianLast;
	}
	
	
	public String getOtherGuardianFirst() {
		return otherGuardianFirst;
	}
	public void setOtherGuardianFirst(String otherGuardianFirst) {
		this.otherGuardianFirst = otherGuardianFirst;
	}
	
	
	public String getOtherGuardianMiddle() {
		return otherGuardianMiddle;
	}
	public void setOtherGuardianMiddle(String otherGuardianMiddle) {
		this.otherGuardianMiddle = otherGuardianMiddle;
	}
	
	
	public String getOtherGuardianRelationship() {
		return otherGuardianRelationship;
	}
	public void setOtherGuardianRelationship(String otherGuardianRelationship) {
		this.otherGuardianRelationship = otherGuardianRelationship;
	}
	
	
	public String getOtherGuardianPhone1() {
		return otherGuardianPhone1;
	}
	public void setOtherGuardianPhone1(String otherGuardianPhone1) {
		this.otherGuardianPhone1 = otherGuardianPhone1;
	}
	
	
	public String getOtherGuardianPhone2() {
		return otherGuardianPhone2;
	}
	public void setOtherGuardianPhone2(String otherGuardianPhone2) {
		this.otherGuardianPhone2 = otherGuardianPhone2;
	}
	
	
	public Integer getDeformityHistoryNum() {
		return deformityHistoryNum;
	}
	public void setDeformityHistoryNum(Integer deformityHistoryNum) {
		this.deformityHistoryNum = deformityHistoryNum;
	}
	
	
	public String getReferralDocName() {
		return referralDocName;
	}
	public void setReferralDocName(String referralDocName) {
		this.referralDocName = referralDocName;
	}
	
	
	public String getReferralHospitalName() {
		return referralHospitalName;
	}
	public void setReferralHospitalName(String referralHospitalName) {
		this.referralHospitalName = referralHospitalName;
	}
	
	
	public String getReferralOther() {
		return referralOther;
	}
	public void setReferralOther(String referralOther) {
		this.referralOther = referralOther;
	}
	
	
	public String getPreviousTreatmentsNum() {
		return previousTreatmentsNum;
	}
	public void setPreviousTreatmentsNum(String previousTreatmentsNum) {
		this.previousTreatmentsNum = previousTreatmentsNum;
	}
	
	
	public Integer getDiagnosisPrenatallyWeek() {
		return diagnosisPrenatallyWeek;
	}
	public void setDiagnosisPrenatallyWeek(Integer diagnosisPrenatallyWeek) {
		this.diagnosisPrenatallyWeek = diagnosisPrenatallyWeek;
	}

	public MultipartFile getFileName() {
		return fileName;
	}

	public void setFileName(CommonsMultipartFile fileName) {
		this.fileName = fileName;
	}
}
